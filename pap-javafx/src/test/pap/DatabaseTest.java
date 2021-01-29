package pap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private Database database;
    @org.junit.Before
    public void setUp() throws Exception {
        database = new Database();
    }

    @org.junit.Test
    public void getManager() {
        database.getManager();
    }

    @Test
    public void setConnection() throws IOException, SQLException {

        database.setConnection();

    }

    @Test
    public void closeConnection() throws IOException, SQLException {
        Connection con;
        con = database.setConnection();
        database.closeConnection(con);
    }

    @Test
    public void connection() {
        database.connection();
    }

    @Test
    public void emplConnection() {
        database.emplConnection();
    }

    @Test
    public void connectionSelected() {
        database.connectionSelected("1001");
    }

    @Test
    public void deptConnection() {
        database.deptConnection();
    }

    @Test
    public void empConnection() {
        database.empConnection();
    }

    @Test
    public void adrConnection() {
        database.adrConnection();
    }

    @Test
    public void departmentsConnection() {
        database.departmentsConnection();

    }

    @Test
    public void empConnectionSelected() {
        database.empConnection();
    }


    @Test
    public void getDepartments() {

        database.getDepartments();

    }

    @Test
    public void getProducent() {
        database.getProducent();
    }


    @Test
    public void addItem() {
        ObservableList<Item> data;
        data = database.connection();
        database.addItem(data, "1", "2", "opony", 200, "3000", 40000, 3, 2);

    }

    @Test
    public void addEmployee() {
        ObservableList<Employee> data;
        data = database.emplConnection();
        database.addEmployee(data, "1", "macius4", "Maciej", "Kowalski", "123456789","M","2000","3");
    }

    @Test
    public void addDepartment() {
        ObservableList<Department> data;
        data = database.departmentsConnection();
        database.addDepartment(data.size(), "Autokomis 5", "4001", "1001");
    }


    @Test
    public void saveDepartment() {
        ObservableList<Department> data;
        data = database.departmentsConnection();
        database.saveDepartment(data);
    }

    @Test
    public void addAddress() {
        ObservableList<Address> data;
        data = database.adrConnection();
        database.addAddress(data,"20-100","niska","3","Dębiln","Polsak");

    }

    @Test
    public void saveAddress() {
        ObservableList<Address> data;
        data = database.adrConnection();
        database.saveAddress(data);

    }

    @Test
    public void login() {
        Assert.assertTrue(database.login("macius4","macius4"));

    }
    @Test
    public void login1() {
        Assert.assertFalse(database.login("maciu4","macius4"));

    }

    @Test
    public void addUser() {
        database.addUser("jczarot1", "12345");
        Assert.assertTrue(database.login("jczarot1","12345"));

    }


}