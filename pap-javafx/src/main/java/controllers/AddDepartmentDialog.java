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
import pap.*;
import pap.Department;

import java.util.ArrayList;
import java.util.List;

public class AddDepartmentDialog {
    public Button addDepartment;
    @FXML
    private TextField name;
    @FXML
    private TextField city;
    @FXML
    private TextField postcode;
    @FXML
    private TextField street;
    @FXML
    private TextField number;
    @FXML
    private TextField country;
    @FXML
    private ComboBox managerComboBox;

    private ObservableList<Department> mainObservableList;
    private ObservableList<Employee1> data = FXCollections.observableArrayList();
    private ObservableList<String> empl = FXCollections.observableArrayList();

    public void initialize()
    {
        this.data = Database.empConnection();
        this.empl= Database.getManager();
        this.managerComboBox.setItems(FXCollections.observableArrayList(this.empl));

    }

    public void addDepartment(ActionEvent event) {
        if (name != null && city != null && postcode != null && street != null && number != null && country != null) {

            ObservableList<Department> data = Database.departmentsConnection();
            ObservableList<Address> data1 = Database.adrConnection();

            int addr_id = Database.addAddress(data1,postcode.getText(),street.getText(),number.getText(),city.getText(),country.getText());
            Database.saveAddress(data1);

            String managerID = (String)this.managerComboBox.getSelectionModel().getSelectedItem();
            Database.addDepartment((Integer)(data.size()+2001) ,name.getText(),managerID,Integer.toString(addr_id)); //Juuulka


            this.closeStage(event);
        }


}

    public void setMainObservableList(ObservableList<Department> DepartmentList) {

        this.mainObservableList = DepartmentList;
    }

    private void closeStage(ActionEvent event) {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
