package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;
import org.apache.log4j.Logger;
import sample.Main;
import sample.beans.Desplazamiento;
import sample.beans.Elemento;
import sample.beans.InsumoVista;
import sample.beans.Nodo;
import sample.service.AnalizadorService;
import sample.service.ExcelReaderService;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private final Logger log = Logger.getLogger(MainController.class);

    private GridPane gridCenter;
    private ExcelReaderService readerService = new ExcelReaderService();
    private AnalizadorService analizadorService = new AnalizadorService();
    private InsumoVista insumoVista = new InsumoVista();
    private String rutaArchivo = "Ruta del Archivo";

    private ObservableList<Nodo> nodoData = FXCollections.observableArrayList();
    private ObservableList<Elemento> elementoData = FXCollections.observableArrayList();
    private ObservableList<Desplazamiento> desplazamientosData = FXCollections.observableArrayList();

    @FXML
    BorderPane borderPane1;

    @FXML
    Button botonLeeArchivo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void close(){
        Stage stage = (Stage) borderPane1.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void leeArchivo(){

        log.debug("[leeArchivo] Inicia");

        if(borderPane1.getCenter() != null ){
            try {
                gridCenter = (GridPane) borderPane1.getCenter();
            }catch(ClassCastException cce){
                gridCenter =null;
            }
            if(gridCenter != null) {
                ObservableList<Node> obs = gridCenter.getChildren();
                HBox hbox1 = (HBox) obs.get(0);

                ObservableList<Node> obs2 = hbox1.getChildren();
                Label label = (Label) obs2.get(0);
                setRutaArchivo(label.getText());
                log.debug("[leeArchivo] Se obtiene ruta del archivo " + getRutaArchivo());
            }

        }

        if(rutaArchivo!= null) {
            try {
                log.debug("[leeArchivo] Se lee el archivo");
                insumoVista = readerService.leeArchivo(new File(rutaArchivo).getPath());
            } catch (IOException e) {
                log.error("Error al leer el archivo");
            }

            if (insumoVista != null) {
                if (insumoVista.getLstNods() != null && !insumoVista.getLstNods().isEmpty()) {
                    log.debug("[leeArchivo] Se pobla la lista de Nodos");
                    nodoData.addAll(insumoVista.getLstNods());/* getItems().setAll(getNodos(insumoVista));*/
                }

                if (insumoVista.getLstElements() != null && !insumoVista.getLstElements().isEmpty()) {
                    log.debug("[leeArchivo] Se pobla la lista de Elementos");
                    elementoData.addAll(insumoVista.getLstElements());
                }

                if (insumoVista.getLstDesplazamientos() != null && !insumoVista.getLstDesplazamientos().isEmpty()) {
                    log.debug("[leeArchivo] Se pobla la lista de Desplazamientos");
                    System.out.println("[leeArchivo] Se pobla la lista de Desplazamientos");
                    desplazamientosData.addAll(insumoVista.getLstDesplazamientos());
                }
            }
        }
    }
    @FXML
    private void analizaArchivo() {
        analizadorService.realizaAnalisis(insumoVista);
    }

    @FXML
    private void archivoLoadScene(){
        log.debug("[archivoLoadScene] Se carga la pantalla de Archivo");
        loadUI("Archivo", "ArchivoController");
    }

    @FXML
    private void nodosLoadScene(){
        log.debug("[nodosLoadScene] Se carga la pantalla de Nodos");
        loadUI("Nodos", "NodosController");
    }

    @FXML
    private void elementosLoadScene(){
        log.debug("[elementosLoadScene] Se carga la pantalla de Elementos");
        loadUI("Elementos", "ElementosController");
    }

    @FXML
    private void desplazamientosLoadScene(){
        log.debug("[desplazamientosLoadScene] Se carga la pantalla de Desplazamientos");
        loadUI("Desplazamientos", "DesplazamientosController");
    }


    private void loadUI(String ui, String controller){
        Parent root = null;
        try {

            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(Main.class.getResource("/fxml/"+ui+".fxml"));

            switch(controller.trim()) {

                case "ElementosController": {
                    root = (VBox) loader.load();
                    borderPane1.setCenter(root);
                    ElementosController eController = loader.getController();
                    eController.setElementoData(elementoData);
                }
                break;

                case "NodosController": {
                    root = (VBox) loader.load();
                    borderPane1.setCenter(root);
                    NodosController nController = loader.getController();
                    nController.setNodoData(nodoData);
                }
                break;

                case "ArchivoController": {
                    root = (GridPane) loader.load();
                    borderPane1.setCenter(root);
                    ArchivoController aController = loader.getController();
                    aController.setFileRute(this.getRutaArchivo());
                }
                break;

                case "DesplazamientosController": {
                    root = (VBox) loader.load();
                    borderPane1.setCenter(root);
                    DesplazamientosController dController = loader.getController();
                    dController.setDesplazamientosData(desplazamientosData);
                }
                break;
            }
        } catch (IOException | ClassCastException e) {
            e.printStackTrace();
        }

        borderPane1.setCenter(root);
    }

    public void setRutaArchivo(String valor) {
        this.rutaArchivo = valor;
        log.debug("rutaArchivo!! ->" + this.rutaArchivo);
    }

    public String getRutaArchivo() {
        return this.rutaArchivo;
    }

    public InsumoVista getInsumoVista(){
        return insumoVista;
    }
}
