package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.log4j.Logger;
import sample.controllers.MainController;

public class Main extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    private final Logger log = Logger.getLogger(Main.class);

    @Override
    public void start(Stage primaryStage) throws Exception{

        log.info("------------------------------- Inicia Aplicacion -------------------------------");

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
        //grab your root here
        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        //move around here
        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();

        log.info("Se carga la pantalla principal");

    }


    public static void main(String[] args) {
        launch(args);
    }
}
