package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import sample.beans.InsumoVista;
import sample.service.ExcelReaderService;

import java.io.File;

public class ArchivoController {

    private final FileChooser fileChooser = new FileChooser();
    private File selectedFile;

    @FXML
    Label fileRute;

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

            }else {

                alert.setContentText("No es un archivo Excel");
                alert.showAndWait();
            }
        }else{

            alert.setContentText("No es un archivo valido");
            alert.showAndWait();
        }
    }

    private String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }

    public void setFileRute(String valor){
        fileRute.setText(valor);
    }
}
