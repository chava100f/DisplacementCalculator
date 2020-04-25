package sample.controllers;

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
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;
import org.apache.poi.util.SystemOutLogger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    BorderPane borderPane1;

    @FXML
    Button clearButton;

    private String valor;

    GridPane gridCenter;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void close(MouseEvent event){
        Stage stage = (Stage) borderPane1.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void clear(MouseEvent event){

        gridCenter = (GridPane) borderPane1.getCenter();
        ObservableList<Node> obs = gridCenter.getChildren();
        HBox hbox1 = (HBox) obs.get(0);

        ObservableList<Node> obs2 =  hbox1.getChildren();
        Label label = (Label)  obs2.get(0);
        setValor(label.getText());

    }

    @FXML
    private void archivoLoadScene(MouseEvent event){loadUI("Archivo"); }

    @FXML
    private void nodosLoadScene(MouseEvent event){
        loadUI("Nodos");
    }

    @FXML
    private void elementosLoadScene(MouseEvent event){
        loadUI("Elementos");
    }

    private void loadUI(String ui){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/"+ui+".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        borderPane1.setCenter(root);
    }

    public void setValor(String valor) {
        this.valor = valor;
        System.out.println("valor!! ->" + this.valor);
        clearButton.setText(this.valor);
    }

    public String getValor() {
        return valor;
    }
}
