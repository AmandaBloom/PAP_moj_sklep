package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pap.Database;
import pap.Department;
import pap.Item;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class DepartmentsController{
    private MainController mainController;

    @FXML
    private TableView table;
    @FXML
    private TableColumn<Department, String> idColumn;
    @FXML
    private TableColumn<Department, String> nameColumn;
    @FXML
    private TableColumn<Department, String> adressColumn;
    @FXML
    private TableColumn<Department, String> managerColumn;

    private ObservableList<Department> data = FXCollections.observableArrayList();
    //private ObservableList<String> depts = FXCollections.observableArrayList();

    @FXML
    public void backMenu(){
        mainController.loadStartScreen();
    }

    @FXML
    public void addDept(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/pap/AddDepartment.fxml"));
        VBox vbox = null;
        try {
            vbox = loader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }

        AddDepartmentDialog addDepartment = loader.getController();
        addDepartment.setMainObservableList(this.data);

        Scene scene = new Scene(vbox, 580, 350);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();

        this.data = Database.deptConnection();
        setValuesInTable();
    }

    @FXML
    public void undo(){
        this.data = Database.deptConnection();
        setValuesInTable();
    }


    @FXML
    public void delete()
    {
        this.table.getItems().removeAll(this.table.getSelectionModel().getSelectedItem());
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void initialize() {
        this.data = Database.deptConnection();


        setValuesInTable();
        //uaktywnienie komórek w kolumnach, umożliwienie edytowania ich
        this.idColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.adressColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.managerColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void setValuesInTable()
    {
        this.idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.adressColumn.setCellValueFactory(new PropertyValueFactory<>("adress"));
        this.managerColumn.setCellValueFactory(new PropertyValueFactory<>("managerID"));
        this.table.setItems(this.data);
    }

    //funkcje pobierające nowe - edytowane wartości z tabeli departamentów
    public void editNameColumn(TableColumn.CellEditEvent<Department, String> deptCellEdit){
        deptCellEdit.getNewValue();
    }
    public void editAdressColumn(TableColumn.CellEditEvent<Department, String> deptCellEdit){
        deptCellEdit.getNewValue();
    }
    public void editManagerColumn(TableColumn.CellEditEvent<Department, String> deptCellEdit){
        deptCellEdit.getNewValue();
    }
}
