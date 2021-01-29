package pap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee empl;
    @Before
    public void setUp() throws Exception {
        empl = new Employee("1", "3", "macius4", "Maciej", "Kowalski", "12345678910","M", "20/01/2020", "2000", "1001", "1");

    }

    @Test
    public void getId() {
        String id_true, id_expected;
        id_expected = "1";
        id_true = empl.getId();
        Assert.assertEquals(id_true, id_expected);
    }

    @Test
    public void setId() {
        String new_Id, true_id, predict_id;
        empl.setId("2");
        true_id = empl.getId();
        predict_id = "2";
        Assert.assertEquals(predict_id, true_id);
    }

    @Test
    public void getDept_id() {
        String dept_id_true, dept_id_predict;
        dept_id_true = "3";
        dept_id_predict = empl.getDept_id();
        Assert.assertEquals(dept_id_predict,dept_id_true);
    }

    @Test
    public void setDept_id() {
        String dept_id_true, dept_id_predict;
        dept_id_true = "100";
        empl.setDept_id(dept_id_true);
        dept_id_predict = empl.getDept_id();
        Assert.assertEquals(dept_id_predict,dept_id_true);
    }

    @Test
    public void getUsername() {
        String user_name_True, user_name_predict;
        user_name_True = "macius4";
        user_name_predict = empl.getUsername();
        Assert.assertEquals(user_name_predict,user_name_True);
    }

    @Test
    public void setUsername() {
        String user_name_True, user_name_predict;
        user_name_True = "macius10";
        empl.setUsername(user_name_True);
        user_name_predict = empl.getUsername();
        Assert.assertEquals(user_name_predict,user_name_True);

    }

    @Test
    public void getName() {
        String name_True, name_predict;
        name_True = "Maciej";
        name_predict = empl.getName();
        Assert.assertEquals(name_predict,name_True);

    }

    @Test
    public void setFirstName() {
        String name_True, name_predict;
        name_True = "Maciek";
        empl.setFirstName(name_True);
        name_predict = empl.getName();
        Assert.assertEquals(name_predict,name_True);
    }

    @Test
    public void getSurname() {
        String surname_True, surname_predict;
        surname_True = "Kowalski";
        surname_predict = empl.getSurname();
        Assert.assertEquals(surname_predict,surname_True);
    }

    @Test
    public void setSurname() {
        String surname_True, surname_predict;
        surname_True = "Nowak";
        empl.setSurname(surname_True);
        surname_predict = empl.getSurname();
        Assert.assertEquals(surname_predict,surname_True);
    }

    @Test
    public void getPesel() {
        String pesel_True, pesel_predict;
        pesel_True = "12345678910";
        pesel_predict = empl.getPesel();
        Assert.assertEquals(pesel_predict,pesel_True);
    }

    @Test
    public void setPesel() {
        String pesel_True, pesel_predict;
        pesel_True = "1234";
        empl.setPesel(pesel_True);
        pesel_predict = empl.getPesel();
        Assert.assertEquals(pesel_predict,pesel_True);

    }

    @Test
    public void getSex() {
        String sex_True, sex_predict;
        sex_True = "M";
        sex_predict = empl.getSex();
        Assert.assertEquals(sex_predict,sex_True);

    }

    @Test
    public void setSex() {
        String sex_True, sex_predict;
        sex_True = "F";
        empl.setSex(sex_True);
        sex_predict = empl.getSex();
        Assert.assertEquals(sex_predict,sex_True);
    }

    @Test
    public void getEmpDate() {
        String empDate_True, empDate_predict;
        empDate_True = "20/01/2020";
        empDate_predict = empl.getEmpDate();
        Assert.assertEquals(empDate_predict,empDate_True);
    }

    @Test
    public void setEmpDate() {
        String empDate_True, empDate_predict;
        empDate_True = "21/01/2021";
        empl.setEmpDate(empDate_True);
        empDate_predict = empl.getEmpDate();
        Assert.assertEquals(empDate_predict,empDate_True);
    }

    @Test
    public void getSalary() {
        String salary_True, salary_predict;
        salary_True = "2000";
        salary_predict = empl.getSalary();
        Assert.assertEquals(salary_predict, salary_True);
    }

    @Test
    public void setSalary() {
        String salary_True, salary_predict;
        salary_True = "4000";
        empl.setSalary(salary_True);
        salary_predict = empl.getSalary();
        Assert.assertEquals(salary_predict, salary_True);
    }

    @Test
    public void getManagerID() {
        String managerId_True, managerId_predict;
        managerId_True = "1001";
        empl.setManagerID(managerId_True);
        managerId_predict = empl.getManagerID();
        Assert.assertEquals(managerId_predict, managerId_True);
    }


    @Test
    public void setManagerID() {
        String managerId_True, managerId_predict;
        managerId_True = "2000";
        empl.setManagerID(managerId_True);
        managerId_predict = empl.getManagerID();
        Assert.assertEquals(managerId_predict, managerId_True);
    }

    @Test
    public void getUserType() {
        String usertype_True, usertype_predict;
        usertype_True = "1";
        usertype_predict = empl.getUserType();
        Assert.assertEquals(usertype_predict, usertype_True);
    }

    @Test
    public void setUserType() {
        String usertype_True, usertype_predict;
        usertype_True = "2";
        empl.setUserType(usertype_True);
        usertype_predict = empl.getUserType();
        Assert.assertEquals(usertype_predict, usertype_True);
    }


}