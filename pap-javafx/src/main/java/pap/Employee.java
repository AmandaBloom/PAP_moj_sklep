package pap;

import javafx.beans.property.SimpleStringProperty;

public class Employee {
    private SimpleStringProperty id;
    private SimpleStringProperty dept_id;
    private SimpleStringProperty username;
    private SimpleStringProperty name;
    private SimpleStringProperty surname;
    private SimpleStringProperty pesel;
    private SimpleStringProperty sex;
    private SimpleStringProperty managerID;
    private SimpleStringProperty empDate;
    private SimpleStringProperty salary;
    private SimpleStringProperty userType;


    public Employee(String id, String dept_id, String username, String name, String surname, String pesel, String sex, String empDate, String salary, String managerID, String userType) {
        this.id = new SimpleStringProperty(id);
        this.dept_id = new SimpleStringProperty(dept_id);
        this.username = new SimpleStringProperty(username);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.pesel = new SimpleStringProperty(pesel);
        this.sex = new SimpleStringProperty(sex);
        this.managerID = new SimpleStringProperty(managerID);
        this.empDate = new SimpleStringProperty(empDate);
        this.salary = new SimpleStringProperty(salary);
        this.userType = new SimpleStringProperty(userType);

    }

    public Employee(){

    }

    public String getId() { return id.get(); }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) { this.id.set(id); }

    public String getDept_id() { return dept_id.get(); }

    public SimpleStringProperty dept_idProperty() {
        return dept_id;
    }

    public void setDept_id(String dept_id) { this.dept_id.set(dept_id); }

    public String getUsername() { return username.get(); }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) { this.username.set(username); }

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

    public String getManagerID() {
        return managerID.get();
    }

    public SimpleStringProperty managerIDProperty() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID.set(managerID);
    }
    public String getUserType() {
        return userType.get();
    }

    public SimpleStringProperty userTypeProperty() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType.set(userType);
    }



}
