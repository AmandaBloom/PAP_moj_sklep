package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pap.Database;

import pap.Employee;

public class AddEmployeeDialog {
    public Button addEmployee;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField pesel;
    @FXML
    private TextField salary;
    @FXML
    private TextField login;
    @FXML
    private TextField password;
    @FXML
    private ComboBox sexComboBox;
    @FXML
    private ComboBox menagerComboBox;

    String sex[] = {"F", "M"};
    private ObservableList<String> empl = FXCollections.observableArrayList();
    private ObservableList<Employee> data = Database.emplConnection();

    public void initialize()
    {
        this.data = Database.emplConnection();
        this.empl= Database.getManager();

        this.menagerComboBox.setItems(FXCollections.observableArrayList(this.empl));

        this.sexComboBox.setItems(FXCollections.observableArrayList(sex));
    }

    public void addEmployee(ActionEvent event) {
        if ( name != null && surname != null && pesel != null && salary != null && login != null && password != null) {
            String managerID;
            if (menagerComboBox.getSelectionModel().isEmpty()) {
                managerID = "Null";
            } else {
                managerID = this.menagerComboBox.getValue().toString();
            }
            Database.addEmployee(this.data, menagerComboBox.getId(), this.login.getText().trim(), this.name.getText().trim(), this.surname.getText().trim(), this.pesel.getText().trim(), this.sexComboBox.getValue().toString(), this.salary.getText().trim(), managerID);
            Database.addUser(this.login.getText(), this.password.getText());


            closeStage(event);

        }


    }

    private void closeStage(ActionEvent event) {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
