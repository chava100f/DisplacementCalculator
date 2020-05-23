package sample.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.beans.Desplazamiento;

import java.util.List;

public class DesplazamientosController {

    private ObservableList<Desplazamiento> desplazamientosData ;

    @FXML
    private TableView<Desplazamiento> desplazamientosTable;
    @FXML
    private TableColumn<Desplazamiento, String> nodeColumn;
    @FXML
    private TableColumn<Desplazamiento, String> loadColumn;
    @FXML
    private TableColumn<Desplazamiento, String> dxColumn;
    @FXML
    private TableColumn<Desplazamiento, String> dyColumn;
    @FXML
    private TableColumn<Desplazamiento, String> dzColumn;
    @FXML
    private TableColumn<Desplazamiento, String> rxColumn;
    @FXML
    private TableColumn<Desplazamiento, String> ryColumn;
    @FXML
    private TableColumn<Desplazamiento, String> rzColumn;


    @FXML
    private void initialize() {

        nodeColumn.setCellValueFactory(new PropertyValueFactory<>("node"));
        loadColumn.setCellValueFactory(new PropertyValueFactory<>("load"));
        dxColumn.setCellValueFactory(new PropertyValueFactory<>("dx"));
        dyColumn.setCellValueFactory(new PropertyValueFactory<>("dy"));
        dzColumn.setCellValueFactory(new PropertyValueFactory<>("dz"));
        rxColumn.setCellValueFactory(new PropertyValueFactory<>("rx"));
        ryColumn.setCellValueFactory(new PropertyValueFactory<>("ry"));
        rzColumn.setCellValueFactory(new PropertyValueFactory<>("rz"));
    }

    public List<Desplazamiento> getDesplazamientosData() {
        return desplazamientosData;
    }

    public void setDesplazamientosData(ObservableList<Desplazamiento> dList) {
        this.desplazamientosData = dList;
        if(desplazamientosTable != null) {
            System.out.println("[setDesplazamientosData] desplazamientosTable != null");
            desplazamientosTable.setItems(desplazamientosData);
        }
    }
}
