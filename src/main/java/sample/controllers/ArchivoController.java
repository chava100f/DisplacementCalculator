package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.beans.InsumoVista;
import sample.service.ExcelReaderService;

import java.io.File;
import java.io.IOException;

public class ArchivoController {

    private final FileChooser fileChooser = new FileChooser();
    private ExcelReaderService readerService = new ExcelReaderService();
    private InsumoVista insumoVista = new InsumoVista();
    private File selectedFile;

    @FXML
    Label fileRute;

    @FXML
    Button botonGrande;

    @FXML
    private void selectFile(MouseEvent event){

        selectedFile = fileChooser.showOpenDialog(null);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText("Advertencia");


        if(selectedFile != null){
            if(getFileExtension(selectedFile).equals("xls") || getFileExtension(selectedFile).equals("xlsx") ) {

                //Cambia texto en label
                fileRute.setText(selectedFile.getPath());
                botonGrande.setDisable(false);

            }else {

                alert.setContentText("No es un archivo Excel");
                alert.showAndWait();
            }
        }else{

            alert.setContentText("No es un archivo valido");
            alert.showAndWait();
        }
    }

    @FXML
    private void readFile(MouseEvent event){

        if(selectedFile!= null) {
            poneValor();
            /*try {

                insumoVista = readerService.leeArchivo(selectedFile.getPath());
            } catch (IOException e) {
                System.out.println("Error al leer el archivo");
            }*/

            /*if (insumoVista != null) {
                if (insumoVista.getLstNods() != null && !insumoVista.getLstNods().isEmpty()) {
                    tablaNodos.getItems().setAll(getNodos(insumoVista));
                }

                if (insumoVista.getListElements() != null && !insumoVista.getListElements().isEmpty()) {
                    tablaElementos.setItems(getElementos(insumoVista));
                }
            }*/

            /*inicializaTablas(insumoVista);*/
        }
    }

    private String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }

    private void poneValor(){
        try {

            Stage st = new Stage();
            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            st.setScene(scene);

            MainController mainController = loader.<MainController>getController();
            mainController.setValor(fileRute.getText());

            st.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
