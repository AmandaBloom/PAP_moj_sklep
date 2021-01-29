package pap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {
    private  Department dept;

    @Before
    public void setUp() throws Exception {
        dept = new Department("1", "nowyDepartament", "101", "1001");
    }

    @Test
    public void getId() {
        String id_True, id_predict;
        id_True = "1";
        id_predict = this.dept.getId();
        Assert.assertEquals(id_predict,id_True);
    }

    @Test
    public void setId() {
        String id_True, id_predict;
        id_True = "2001";
        dept.setId(id_True);
        id_predict = dept.getId();
        Assert.assertEquals(id_predict,id_True);
    }

    @Test
    public void getName() {
        String name_True, name_predict;
        name_True = "nowyDepartament";
        name_predict = dept.getName();
        Assert.assertEquals(name_predict,name_True);
    }

    @Test
    public void setName() {
        String name_True, name_predict;
        name_True = "NowaNazwa";
        dept.setName(name_True);
        name_predict = dept.getName();
        Assert.assertEquals(name_predict,name_True);
    }

    @Test
    public void getAdressID() {
        String adressID_True, adressID_predict;
        adressID_True = "101";
        adressID_predict = dept.getAdressID();
        Assert.assertEquals(adressID_predict, adressID_True);


    }

    @Test
    public void setAdressID() {
        String adressID_True, adressID_predict;
        adressID_True = "202";
        dept.setAdressID(adressID_True);
        adressID_predict = dept.getAdressID();
        Assert.assertEquals(adressID_predict, adressID_True);
    }

    @Test
    public void getManagerID() {
        String managerID_True, managerID_predict;
        managerID_True = "1001";
        managerID_predict = dept.getManagerID();
        Assert.assertEquals(managerID_predict, managerID_True);
    }

    @Test
    public void setManagerID() {
        String managerID_True, managerID_predict;
        managerID_True = "2002";
        dept.setManagerID(managerID_True);
        managerID_predict = dept.getManagerID();
        Assert.assertEquals(managerID_predict, managerID_True);
    }
}