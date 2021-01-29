package pap;

import javafx.beans.property.SimpleStringProperty;

import java.util.List;

public class Department {
    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty  adressID;
    private SimpleStringProperty managerID;

    public Department(String id, String name, String adressID, String managerID) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.adressID = new SimpleStringProperty(adressID);
        this.managerID = new SimpleStringProperty(managerID);
    }

    public Department(){

    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAdressID() {
        return adressID.get();
    }

    public SimpleStringProperty adressProperty() {
        return adressID;
    }

    public void setAdressID(String adressID) {
        this.adressID.set(adressID);
    }

    public String getManagerID() {
        return managerID.get();
    }

    public SimpleStringProperty managerIDProperty() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID.set(managerID);
    }


}
