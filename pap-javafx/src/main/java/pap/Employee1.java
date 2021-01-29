package pap;

import javafx.beans.property.SimpleStringProperty;

import java.util.List;

public class Employee1 {
    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty surname;
    private SimpleStringProperty pesel;
    private SimpleStringProperty sex;
    private SimpleStringProperty empDate;
    private SimpleStringProperty salary;
    private SimpleStringProperty manager;

    public Employee1(String id, String name, String surname, String pesel, String sex, String empDate, String salary, String manager) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.pesel = new SimpleStringProperty(pesel);
        this.sex = new SimpleStringProperty(sex);
        this.empDate = new SimpleStringProperty(empDate);
        this.salary = new SimpleStringProperty(salary);
        this.manager = new SimpleStringProperty(manager);
    }

    public Employee1(){

    }

    public String getId() { return id.get(); }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) { this.id.set(id); }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return name;
    }

    public void setFirstName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public SimpleStringProperty surnameProperty() { return surname; }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getPesel() {
        return pesel.get();
    }

    public SimpleStringProperty peselProperty() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel.set(pesel);
    }

    public String getSex() {
        return sex.get();
    }

    public SimpleStringProperty sexProperty() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex.set(sex);
    }

    public String getEmpDate() { return empDate.get(); }

    public SimpleStringProperty empDateProperty() { return empDate; }

    public void setEmpDate(String empDate) {
        this.empDate.set(empDate);
    }

    public String getSalary() {
        return salary.get();
    }

    public SimpleStringProperty salaryProperty() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary.set(salary);
    }

    public String getManager() {
        return manager.get();
    }

    public SimpleStringProperty managerProperty() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager.set(manager);
    }



}
