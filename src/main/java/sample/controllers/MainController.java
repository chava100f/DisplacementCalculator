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
import sample.Main;
import sample.beans.Elemento;
import sample.beans.InsumoVista;
import sample.beans.Nodo;
import sample.service.ExcelReaderService;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private GridPane gridCenter;
    private ExcelReaderService readerService = new ExcelReaderService();
    private InsumoVista insumoVista = new InsumoVista();
    private String rutaArchivo = "Ruta del Archivo";

    private ObservableList<Nodo> nodoData = FXCollections.observableArrayList();
    private ObservableList<Elemento> elementoData = FXCollections.observableArrayList();

    @FXML
    BorderPane borderPane1;

    @FXML
    Button botonLeeArchivo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void close(MouseEvent event){
        Stage stage = (Stage) borderPane1.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void leeArchivo(MouseEvent event){


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
            }

        }

        if(rutaArchivo!= null) {
            try {
                insumoVista = readerService.leeArchivo(new File(rutaArchivo).getPath());
            } catch (IOException e) {
                System.out.println("Error al leer el archivo");
            }

            if (insumoVista != null) {
                if (insumoVista.getLstNods() != null && !insumoVista.getLstNods().isEmpty()) {
                    nodoData.addAll(insumoVista.getLstNods());/* getItems().setAll(getNodos(insumoVista));*/
                }

                if (insumoVista.getLstElements() != null && !insumoVista.getLstElements().isEmpty()) {
                    elementoData.addAll(insumoVista.getLstElements());
                    /*tablaElementos.setItems(getElementos(insumoVista));*/
                }
            }

            /*inicializaTablas(insumoVista);*/
        }
    }

    @FXML
    private void archivoLoadScene(MouseEvent event){loadUI("Archivo", "ArchivoController"); }

    @FXML
    private void nodosLoadScene(MouseEvent event){
        loadUI("Nodos", "NodosController");
    }

    @FXML
    private void elementosLoadScene(MouseEvent event){
        loadUI("Elementos", "ElementosController");
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
            }
        } catch (IOException | ClassCastException e) {
            e.printStackTrace();
        }

        borderPane1.setCenter(root);
    }

    public void setRutaArchivo(String valor) {
        this.rutaArchivo = valor;
        System.out.println("rutaArchivo!! ->" + this.rutaArchivo);
    }

    public String getRutaArchivo() {
        return this.rutaArchivo;
    }

    public InsumoVista getInsumoVista(){
        return insumoVista;
    }
}
