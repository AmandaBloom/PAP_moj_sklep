package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Pair;
import pap.Database;
import pap.Employee;
import pap.Employee1;

import java.io.IOException;

public class EmployeesControler {
    private MainController mainController;

    @FXML
    private TableView table;
    @FXML
    private TableColumn<Employee1, String> idColumn;
    @FXML
    private TableColumn<Employee1, String> nameColumn;
    @FXML
    private TableColumn<Employee1, String> surnameColumn;
    @FXML
    private TableColumn<Employee1, String> peselColumn;
    @FXML
    private TableColumn<Employee1, String> sexColumn;
    @FXML
    private TableColumn<Employee1, String> empDateColumn;
    @FXML
    private TableColumn<Employee1, String> salaryColumn;
    @FXML
    private TableColumn<Employee1, String> managerColumn;
    @FXML
    private ComboBox departmentComboBox;

    private ObservableList<Employee1> data = FXCollections.observableArrayList();
    private ObservableList<Pair> depts = FXCollections.observableArrayList();

    @FXML
    public void backMenu(){
        mainController.loadStartScreen();
    }

    @FXML
    public void addEmp(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/pap/AddEmployee.fxml"));
        VBox vbox = null;
        try {
            vbox = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(vbox, 580, 350);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();

        this.data = Database.empConnection();
        setValuesInTable();

    }
    public void backupEmp(ActionEvent actionEvent){
        this.data = Database.empConnection();
        setValuesInTable();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void initialize() {
        this.data = Database.empConnection();
        this.depts= Database.getDepartments();
        this.departmentComboBox.setItems(FXCollections.observableArrayList(this.depts));

        setValuesInTable();
        //uaktywnienie komórek w kolumnach, umożliwienie edytowania ich
        this.idColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.surnameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.peselColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.sexColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.empDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.salaryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.managerColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void setValuesInTable()
    {
        this.idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        this.peselColumn.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        this.sexColumn.setCellValueFactory(new PropertyValueFactory<>("sex"));
        this.empDateColumn.setCellValueFactory(new PropertyValueFactory<>("empDate"));
        this.salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        this.managerColumn.setCellValueFactory(new PropertyValueFactory<>("manager"));
        this.table.setItems(this.data);
    }

    public void editIDColumn(TableColumn.CellEditEvent<Employee1, String> idCellEdit){
        idCellEdit.getNewValue();
    }

    public void editNameColumn(TableColumn.CellEditEvent<Employee1, String> nameCellEdit){
        nameCellEdit.getNewValue();
    }

    public void editSurnameColumn(TableColumn.CellEditEvent<Employee1, String> deptCellEdit){
        deptCellEdit.getNewValue();
    }

    public void editPeselColumn(TableColumn.CellEditEvent<Employee1, String> peselCellEdit){
        peselCellEdit.getNewValue();
    }

    public void editSexColumn(TableColumn.CellEditEvent<Employee1, String> sexCellEdit){
        sexCellEdit.getNewValue();
    }

    public void editEmpDateColumn(TableColumn.CellEditEvent<Employee1, String> dateCellEdit){
        dateCellEdit.getNewValue();
    }

    public void editSalaryColumn(TableColumn.CellEditEvent<Employee1, String> salCellEdit){
        salCellEdit.getNewValue();
    }

    public void editManagerColumn(TableColumn.CellEditEvent<Employee1, String> manCellEdit){
        manCellEdit.getNewValue();
    }
    public void selectedDepartment(){
        Pair department = (Pair) this.departmentComboBox.getSelectionModel().getSelectedItem();
        this.data = Database.empConnectionSelected(department.getKey().toString());
        setValuesInTable();
    }
}
