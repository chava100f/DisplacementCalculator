package sample.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.beans.Elemento;
import sample.beans.Nodo;

import java.util.List;

public class ElementosController {

    private ObservableList<Elemento> elementoData ;

    @FXML
    private TableView<Elemento> elementosTable;
    @FXML
    private TableColumn<Elemento, String> numElementoColumn;
    @FXML
    private TableColumn<Elemento, String> tipoColumn;
    @FXML
    private TableColumn<Elemento, String> materialColumn;
    @FXML
    private TableColumn<Elemento, String> node1Column;
    @FXML
    private TableColumn<Elemento, String> node2Column;

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.new PropertyValueFactory<Person, String>("firstName")
        numElementoColumn.setCellValueFactory(new PropertyValueFactory<>("numElemento"));
        tipoColumn.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        materialColumn.setCellValueFactory(new PropertyValueFactory<>("material"));
        node1Column.setCellValueFactory(new PropertyValueFactory<>("node1"));
        node2Column.setCellValueFactory(new PropertyValueFactory<>("node2"));
    }

    public List<Elemento> getElementoData() {
        return elementoData;
    }

    public void setElementoData(ObservableList<Elemento> eList) {
        this.elementoData = eList;
        if(elementoData != null) {
            elementosTable.setItems(elementoData);
        }
    }
}
