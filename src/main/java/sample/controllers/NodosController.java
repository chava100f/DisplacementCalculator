package sample.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.beans.Elemento;
import sample.beans.Nodo;

import java.util.List;

public class NodosController {

    private ObservableList<Nodo> nodoData ;

    @FXML
    private TableView<Nodo> nodoTable;
    @FXML
    private TableColumn<Nodo, String> numNodoColumn;
    @FXML
    private TableColumn<Nodo, String> xColumn;
    @FXML
    private TableColumn<Nodo, String> yColumn;
    @FXML
    private TableColumn<Nodo, String> zColumn;

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.new PropertyValueFactory<Person, String>("firstName")
        numNodoColumn.setCellValueFactory(new PropertyValueFactory<>("numNodo"));
        xColumn.setCellValueFactory(new PropertyValueFactory<>("x"));
        yColumn.setCellValueFactory(new PropertyValueFactory<>("y"));
        zColumn.setCellValueFactory(new PropertyValueFactory<>("z"));

    }

    public List<Nodo> getNodoData() {
        return nodoData;
    }

    public void setNodoData(ObservableList<Nodo> nList) {
        this.nodoData = nList;
        if(nodoData != null) {
            nodoTable.setItems(nodoData);
        }
    }
}
