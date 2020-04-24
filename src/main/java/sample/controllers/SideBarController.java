package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SideBarController implements Initializable {

    @FXML
    BorderPane borderPane1;
    
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
        borderPane1.setCenter(null);
    }

    @FXML
    private void ui1(MouseEvent event){
        loadUI("ui1");
    }

    @FXML
    private void ui2(MouseEvent event){
        loadUI("ui2");
    }

    @FXML
    private void ui3(MouseEvent event){
        loadUI("ui3");
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
}
