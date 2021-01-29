package pap;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Pair;


public class Database {
    public static Connection setConnection() throws SQLException, IOException {
        Properties prop = new Properties();
        FileInputStream in = new FileInputStream("src\\main\\java\\pap\\database.properties");
        prop.load(in); // zaczytanie danych z pliku properties
        in.close(); // zamkniecie pliku

        String host = prop.getProperty("jdbc.host");
        String username = prop.getProperty("jdbc.username");
        String password = prop.getProperty("jdbc.password");
        String port = prop.getProperty("jdbc.port");
        String serviceName = prop.getProperty("jdbc.service.name");

        String connectionString = String.format(
                "jdbc:oracle:thin:%s/%s@//%s:%s/%s",
                username, password, host, port, serviceName);

        return DriverManager.getConnection(connectionString);
    }

    public static void closeConnection(Connection conn) throws SQLException { // zamkniecie polaczenia
        conn.close();

    }

    public static ObservableList<Item> connection() {
        ObservableList<Item> data = FXCollections.observableArrayList();
        try {
            Connection conn = setConnection();
            Statement myStmt = conn.createStatement();
            String sql = "select iis.item_id, i.item_code, iis.dept_id, i.itemname, iis.amount, " +
                    "iis.price_net, iis.price_brt, it.vat_rate\n" +
                    "from items_in_storage iis left join items i on (i.item_id = iis.item_id) \n" +
                    "join\n" +
                    "item_types it on (it.item_type = i.item_type)\norder by 1";


            ResultSet rs = myStmt.executeQuery(sql);

            while (rs.next())
                data.add(new Item(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getString(6),
                        rs.getDouble(7), rs.getString(8)));
            closeConnection(conn);
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    public static ObservableList<Item> connectionSelected(String dept) {
        ObservableList<Item> data = FXCollections.observableArrayList();
        try {
            Connection conn = setConnection();
            Statement myStmt = conn.createStatement();
            String sql = "select iis.item_id, i.item_code, iis.dept_id, i.itemname, iis.amount, " +
                    "iis.price_net, iis.price_brt, it.vat_rate\n" +
                    "from items_in_storage iis left join items i on (i.item_id = iis.item_id) \n" +
                    "join\n" +
                    "item_types it on (it.item_type = i.item_type)\n" +
                    "where iis.dept_id = " + dept + " order by 1\n";
            ResultSet rs = myStmt.executeQuery(sql);

            while (rs.next())
                data.add(new Item(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getString(6),
                        rs.getDouble(7), rs.getString(8)));
            closeConnection(conn);
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    public static ObservableList<Employee> emplConnection() {
        ObservableList<Employee> data = FXCollections.observableArrayList();
        try {
            Connection conn = setConnection();
            Statement myStmt = conn.createStatement();
            String sql = "select * from employees";
            ResultSet rs = myStmt.executeQuery(sql);

            while (rs.next())
                data.add(new Employee(rs.getString("emp_id"), rs.getString("dept_id"),
                        rs.getString("username"), rs.getString("firstname"),
                        rs.getString("lastname"), rs.getString("pesel"),
                        rs.getString("sex"), rs.getString("manager_id"),
                        rs.getString("emp_date"), rs.getString("salary"),
                        rs.getString("usertype")));

            closeConnection(conn);
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    public static ObservableList<Employee1> empConnection() {
        ObservableList<Employee1> data = FXCollections.observableArrayList();
        try {
            Connection conn = setConnection();
            Statement myStmt = conn.createStatement();
            String sql = "select emp_id, firstname, lastname, pesel, sex, emp_date, salary, manager_id\n" +
                    "from employees\n" +
                    "order by 1";
            ResultSet rs = myStmt.executeQuery(sql);

            while (rs.next())
                data.add(new Employee1(rs.getString("emp_id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("pesel"), rs.getString("sex"), rs.getString("emp_date"), rs.getString("salary"), rs.getString("manager_id")));
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    public static ObservableList<Employee1> empConnectionSelected(String dept) {
        ObservableList<Employee1> data = FXCollections.observableArrayList();
        try {
            Connection conn = setConnection();
            Statement myStmt = conn.createStatement();
            String sql = "select emp_id, firstname, lastname, pesel, sex, emp_date, salary, manager_id\n" +
                    "from employees\n" +
                    "where dept_id =" + dept + "\n" +
                    "order by 1";
            ResultSet rs = myStmt.executeQuery(sql);

            while (rs.next())
                data.add(new Employee1(rs.getString("emp_id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("pesel"), rs.getString("sex"), rs.getString("emp_date"), rs.getString("salary"), rs.getString("manager_id")));
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    public static ObservableList<Department> deptConnection() {
        ObservableList<Department> data = FXCollections.observableArrayList();
        try {
            Connection conn = setConnection();
            Statement myStmt = conn.createStatement();
            String sql = "select d.dept_id, d.dept_name, a.postal || ' ' || a.street || ' ' || a.st_number || ' ' || a.city as \"Address\", e.firstname || ' ' || e.lastname as \"Emplo\"\n" +
                    "                    from departments d join employees e on (d.manager_id = e.emp_id) join addresses a on (a.addr_id = d.address_id)\n" +
                    "order by 1";
            ResultSet rs = myStmt.executeQuery(sql);

            while (rs.next())
                data.add(new Department(rs.getString("dept_id"), rs.getString("dept_name"), rs.getString("Address"), rs.getString("Emplo")));
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    public static ObservableList<Department> departmentsConnection() {
        ObservableList<Department> data = FXCollections.observableArrayList();
        try {
            Connection conn = setConnection();
            Statement myStmt = conn.createStatement();
            String sql = "select dept_id, dept_name, manager_id, address_id from departments\n" +
                    "order by 1";
            ResultSet rs = myStmt.executeQuery(sql);

            while (rs.next())
                data.add(new Department(rs.getString("dept_id"), rs.getString("dept_name"), rs.getString("manager_id"), rs.getString("address_id")));
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    public static ObservableList<Address> adrConnection() {
        ObservableList<Address> data = FXCollections.observableArrayList();
        try {
            Connection conn = setConnection();
            Statement myStmt = conn.createStatement();
            String sql = "select addr_id, postal, street, st_number, city, country from addresses\n" +
                    "order by 1";
            ResultSet rs = myStmt.executeQuery(sql);

            while (rs.next())
                data.add(new Address(rs.getString("addr_id"), rs.getString("postal"), rs.getString("street"), rs.getString("st_number"), rs.getString("city"), rs.getString("country")));
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    public static ObservableList<Pair> getDepartments() {
        ObservableList<Pair> data = FXCollections.observableArrayList();
        try {
            Connection conn = setConnection();
            Statement myStmt = conn.createStatement();
            String sql = "select dept_id, dept_name from Departments";
            ResultSet rs = myStmt.executeQuery(sql);
            while (rs.next())
                data.add(new Pair(rs.getString("dept_id"), rs.getString("dept_name")));
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    public static ObservableList<Pair> getProducent() {
        ObservableList<Pair> data = FXCollections.observableArrayList();
        try {
            Connection conn = setConnection();
            Statement myStmt = conn.createStatement();
            String sql = "select producer_id, producer_name from Producers";
            ResultSet rs = myStmt.executeQuery(sql);

            while (rs.next())
                data.add(new Pair(rs.getString("producer_id"), rs.getString("producer_name")));
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    public static ObservableList<Pair> getTaxRates() {
        ObservableList<Pair> data = FXCollections.observableArrayList();
        try {
            Connection conn = setConnection();
            Statement myStmt = conn.createStatement();
            String sql = "select vat_rate, type_desc from Item_types";
            ResultSet rs = myStmt.executeQuery(sql);

            while (rs.next())
                data.add(new Pair(rs.getString("vat_rate"), rs.getString("type_desc")));
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    public static ObservableList<String> getManager() {
        ObservableList<String> data = FXCollections.observableArrayList();
        try {
            Connection conn = setConnection();
            Statement myStmt = conn.createStatement();
            String sql = "select DISTINCT  manager_id\n" +
                    "from employees order by manager_id";
            ResultSet rs = myStmt.executeQuery(sql);

            while (rs.next())
                data.add(rs.getString("manager_id"));
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    public static boolean addItem(ObservableList<Item> data, String item_code, String dept_id, String itemname, int amount, String price_net, double price_brt, int vat_rate, int producer_id) {
        int item_id = data.size() + 3001; //itemlist index starts from 3001
        int global_id = getTotalIDinStorage() + 7001;
        try {
            Connection conn = setConnection();
            Statement myStmt = conn.createStatement();
            String insert = "INSERT INTO items VALUES (" + item_id + ", " + item_code + ",'" +
                    itemname + "', " + producer_id + ", " + vat_rate + ")";

            String insert2 = "INSERT INTO items_in_storage VALUES (" + global_id + ", " +
                    item_id + ", " + dept_id + ", " + amount + ", " + price_net + ", " +
                    price_brt + ")";
            myStmt.executeUpdate(insert);
            myStmt.executeUpdate(insert2);
            myStmt.executeUpdate("commit");
            return true;
        } catch (Exception e) {
            System.err.println("WyjÄ…tek zgĹ‚oszono: ");
            System.err.println(e.getMessage());
        }
        return false;
    }

    public static boolean addEmployee(ObservableList<Employee> data, String dept_id, String username, String name, String surname, String pesel, String sex, String salary, String managerID) {
        int emp_id = data.size() + 1001;
        dept_id = "2001";
        String empDate = "CURRENT_DATE";
        String usertype = "1";
        try {
            Connection conn = setConnection();
            Statement myStmt = conn.createStatement();
            //String insert1 = "ALTER SESSION SET NLS_DATE_FORMAT = \"DD/MM/YYYY\"\n";
            String insert = "INSERT INTO employees VALUES (" + Integer.toString(emp_id) + ", " + dept_id +
                    ", '" + username + "', '" + name + "', '" + surname + "', '" + pesel + "', '" + sex +
                    "', " + managerID + ", to_date('16/01/2020', 'DD/MM/YYYY') , " + salary + ", " + usertype + ")";
            myStmt.executeUpdate(insert);

            myStmt.executeUpdate("commit");

            return true;
        } catch (Exception e) {
            System.err.println("WyjÄ…tek zgĹ‚oszono: ");
            System.err.println(e.getMessage());
        }
        return false;
    }

    public static boolean addDepartment(int dataSize, String name, String addressID, String managerID) {
        ObservableList<Department> new_record = FXCollections.observableArrayList();
        new_record.add(new Department(Integer.toString(dataSize), name, managerID, addressID));

        return insertIntoDepartment(new_record);
    }

    public static boolean addUser(String username, String pword) {
        try {
            Connection conn = setConnection();
            Statement myStmt = conn.createStatement();
            String insert = "INSERT INTO passwords VALUES ('" + username + "', '" + pword + "')";
            myStmt.executeUpdate(insert);
            myStmt.executeUpdate("commit");
            return true;
        } catch (Exception e) {
            System.err.println("WyjÄ…tek zgĹ‚oszono: ");
            System.err.println(e.getMessage());
        }
        return false;
    }

    public static boolean addReceipt(ObservableList<SoldItem> data) {
        try {
            Connection conn = setConnection();
            Statement myStmt = conn.createStatement();
            int id = 0;
            String item_id = new String();
            ResultSet rs = myStmt.executeQuery("SELECT count(*) FROM reciepts");
            while (rs.next()) id = rs.getInt("count(*)");
            for (int i = 0; i < data.size(); i++) {
                ResultSet rs1 = myStmt.executeQuery("SELECT item_id FROM items WHERE item_code = "
                        + data.get(i).getBarecode());
                while (rs1.next()) item_id = rs1.getString("item_id");
                String insert = "INSERT INTO reciepts VALUES (" + id + 1 + "," + item_id
                        + ", 0000, " + data.get(i).getAmount() + ", " + data.get(i).getPrice() + ", " +
                        data.get(i).getPrice() + ", SYSDATE)";
                myStmt.executeUpdate(insert);
            }
            myStmt.executeUpdate("commit");
            return true;
        } catch (Exception e) {
            System.err.println("WyjÄ…tek zgĹ‚oszono: ");
            System.err.println(e.getMessage());
        }
        return false;
    }

    public static int addAddress(ObservableList<Address> data, String postal, String street, String stNum, String city, String country) {

        int id = data.size() + 4001; //itemlist index starts from 3001

        data.add(new Address(Integer.toString(id), postal, street, stNum, city, country));
        return id;

    }

    public static boolean insertIntoDepartment(ObservableList<Department> data) {
        try {
            Connection conn = setConnection();
            Statement myStmt = conn.createStatement();

            for (int i = 0; i < data.size(); i++) {
                String insert = "INSERT INTO Departments VALUES (" + data.get(i).getId() + ", '" + data.get(i).getName() + "', " + data.get(i).getManagerID() + ", " + data.get(i).getAdressID() + ")";

                myStmt.executeUpdate(insert);
            }
            return true;
        } catch (Exception e) {
            System.err.println("WyjÄ…tek zgĹ‚oszono: ");
            System.err.println(e.getMessage());
        }
        return false;
    }

    public static boolean saveDepartment(ObservableList<Department> data) {
        try {
            Connection conn = setConnection();
            Statement myStmt = conn.createStatement();
            myStmt.execute("DELETE FROM Departments");


            for (int i = 0; i < data.size(); i++) {
                String insert = "INSERT INTO Departments VALUES (" + data.get(i).getId() + ", '" + data.get(i).getName() + "', " + data.get(i).getAdressID() + ", " + data.get(i).getManagerID() + ")";

                myStmt.executeUpdate(insert);
            }

            myStmt.executeUpdate("commit");
            return true;
        } catch (Exception e) {
            System.err.println("WyjÄ…tek zgĹ‚oszono: ");
            System.err.println(e.getMessage());
        }
        return false;
    }

    public static boolean saveAddress(ObservableList<Address> data) {
        try {
            Connection conn = setConnection();
            Statement myStmt = conn.createStatement();
            myStmt.execute("DELETE FROM Addresses");


            for (int i = 0; i < data.size(); i++) {
                String insert = "INSERT INTO Addresses VALUES (" + data.get(i).getId() + ", '" + data.get(i).getPostal() + "', '" + data.get(i).getStreet() + "', '" + data.get(i).getSt_num() + "', '" + data.get(i).getCity() + "', '" + data.get(i).getCountry() + "')";
                myStmt.executeUpdate(insert);
            }

            myStmt.executeUpdate("commit");
            return true;
        } catch (Exception e) {
            System.err.println("WyjÄ…tek zgĹ‚oszono: ");
            System.err.println(e.getMessage());
        }
        return false;
    }


    public boolean login(String username, String pass) {
        try {
            Connection conn = setConnection();
            Statement myStmt = conn.createStatement();
            String sql = "select * from PASSWORDS";
            ResultSet rs1 = myStmt.executeQuery(sql);

            while (rs1.next())
                if (rs1.getString("USERNAME").equals(username) && rs1.getString("PWORD").equals(pass)) {
                    return true;
                }
            return false;
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    private static int getTotalIDinStorage() {
        int TotId = 0;
        try {
            Connection conn = setConnection();
            Statement myStmt = conn.createStatement();
            String sql = "select count(*) from Items_In_Storage";
            ResultSet rs = myStmt.executeQuery(sql);
            rs.next();
            TotId = rs.getInt(1);
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        return TotId;
    }
}