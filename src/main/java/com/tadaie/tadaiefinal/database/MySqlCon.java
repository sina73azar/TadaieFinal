package com.tadaie.tadaiefinal.database;


import com.tadaie.tadaiefinal.model.ClientT;
import com.tadaie.tadaiefinal.model.Hamkar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySqlCon {
    static final String SQL_JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String MYSQL_DB_URL = "jdbc:mysql://localhost/tadaie_db";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    private Connection con;
    private static MySqlCon instance = null;
    private MySqlCon() {
        try {
            //load driver
            Class.forName(SQL_JDBC_DRIVER);
            //get connection
            con = DriverManager.getConnection(
                    MYSQL_DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(" asdsdasdasdasd-----?java.lang.NoClassDefFoundError");
        }
    }
    public static MySqlCon getInstance() {
        if (instance == null) {
            instance = new MySqlCon();
        }
        return instance;
    }


//    public void getConnection() throws SQLException, ClassNotFoundException {
//        if (con == null) {
//            Class.forName(MARIA_JDBC_DRIVER);
//            Properties connectionProps = new Properties();
//            connectionProps.put("user", USER);
//            connectionProps.put("password", PASS);
//
//
//            con = DriverManager.getConnection(
//                    MARIA_DB_URL,
//                    connectionProps);
//
//            System.out.println("Connected to database");
//        }
//    }

    public Boolean insertClient(ClientT client) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO client \n" +
                    "(`name`, `phone` , `company` , `address`, `details`) VALUES ( ?, ?, ? ,? , ?); ");

            stmt.setString(1, client.getName());
            stmt.setString(2, client.getPhone());
            stmt.setString(3, client.getCompany());
            stmt.setString(4, client.getAddress());
            stmt.setString(5, client.getDetails());

            int rowCount = stmt.executeUpdate();
            System.out.println("rowCount affected by insert client query is: "+rowCount);
        } catch (Exception e) {
            System.out.println("ثبت مشتری با مشکلی مواجه شد");
            return false;
        }

        return true;
    }

    public List<ClientT> getAllClients() {
        List<ClientT> clients = new ArrayList<ClientT>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from client");
            while (rs.next()) {
                ClientT c = new ClientT();
                c.setId(rs.getInt(1));
                c.nameProperty().setValue(rs.getString(2));
                c.phoneProperty().setValue(rs.getString(3));
                c.companyProperty().setValue(rs.getString(4));
                c.addressProperty().setValue(rs.getString(5));
                c.detailsProperty().setValue(rs.getString(6));

                clients.add(c);
            }
            return clients;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Hamkar> getAllHamkaran() {
        List<Hamkar> hamkaran = new ArrayList<Hamkar>();

        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from hamkar");

            while (rs.next()) {
                Hamkar hamkar = new Hamkar();

                hamkar.setId(rs.getInt("id"));
                hamkar.nameProperty().setValue(rs.getString("name"));
                hamkar.phoneProperty().setValue(rs.getString("phone"));
                hamkar.addressProperty().setValue(rs.getString("address"));
                hamkar.detailsProperty().setValue(rs.getString("details"));
                hamkaran.add(hamkar);
            }
            return hamkaran;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public boolean insertHamkar(Hamkar mHamkar){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO `hamkar`(`name`, `phone`, `address`, `details`) VALUES (?,?,?,?);");
            stmt.setString(1, mHamkar.getName());
            stmt.setString(2, mHamkar.getPhone());
            stmt.setString(3, mHamkar.getAddress());
            stmt.setString(4, mHamkar.getDetails());
            int result = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ثبت مشتری با مشکلی مواجه شد");
            return false;
        }
        return true;
    }

    public List<String> checkIfHamkarAlreadyExists(String nameSearch) {
        //returns null if found no similarities
        List<String> hamkars = new ArrayList<>();
        String str = "%" + nameSearch + "%";
        try {
            String sql = "select * from hamkar where name like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, str);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                hamkars.add(rs.getString(2));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hamkars;
    }


    public int getHamkarIdFromName(String name) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("SELECT hamkarId from hamkar WHERE name=?;");
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();
        int id = 1;
        while (rs.next()) {
            System.out.println("id hamkar searched from name is :" + rs.getInt("hamkarId"));
            id = rs.getInt("hamkarId");
        }
        return id;
    }


    public String getNameOfHamkarFromId(Integer id) {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT name from hamkar WHERE hamkarId=?;");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            String name = null;
            int counter = 0;
            while (rs.next()) {
                name = rs.getString("name");
                System.out.println("name selected hamkar is " + name);
                counter++;
            }
            System.out.println("counter loop is :" + counter);
            return name;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;

    }

    public void updateHamkarName(int id, String newName) {
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE hamkar\n" +
                    "SET name = ?\n" +
                    "WHERE id=?;");
            stmt.setString(1, newName);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updatePhoneHamkarFromId(int id, String newPhone) {
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE hamkar\n" +
                    "SET phone = ?\n" +
                    "WHERE id=?;");
            stmt.setString(1, newPhone);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAddressHamkarFromId(int id, String newAddress) {
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE hamkar\n" +
                    "SET address = ?\n" +
                    "WHERE id=?;");
            stmt.setString(1, newAddress);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateDetailsHamkarFromId(int id, String newDetails) {
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE hamkar\n" +
                    "SET details = ?\n" +
                    "WHERE id=?;");
            stmt.setString(1, newDetails);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> checkIfClientAlreadyExists(String text) {
        //returns null if found no similarities
        List<String> clientListNames = new ArrayList<>();
        String str = "%" + text + "%";
        try {
            String sql = "select * from clients where name like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, str);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                clientListNames.add(rs.getString(2));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clientListNames;
    }

    public void updateClientNameFromId(int id, String newValue) {
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE client\n" +
                    "SET name = ?\n" +
                    "WHERE id=?;");
            stmt.setString(1, newValue);
            stmt.setInt(2, id);
            int rowCount = stmt.executeUpdate();
            System.out.println("client with id " + id + " name is changed to " + newValue);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("could not update name of client");
        }
    }

    public void updateClientPhoneFromId(int id, String newValue) {
        try {

            PreparedStatement stmt = con.prepareStatement("update client\n" +
                    "set phone =? \n" +
                    "where id=?");
            stmt.setString(1, newValue);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("could not update phone of client");
        }
    }

    public void updateClientCompanyNameFromId(int id, String newValue) {
        try {
            PreparedStatement stmt = con.prepareStatement("update client\n" +
                    "set company =? \n" +
                    "where id=?");
            stmt.setString(1, newValue);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void updateClientAddressFromId(int id, String newValue) {
        try {
            PreparedStatement stmt = con.prepareStatement("update client\n" +
                    "set address =? \n" +
                    "where id=?");
            stmt.setString(1, newValue);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateClientDetailsFromId(int id, String newValue) {
        try {
            PreparedStatement stmt = con.prepareStatement("update client\n" +
                    "set details =? \n" +
                    "where id=?");
            stmt.setString(1, newValue);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean deleteHamkar(int id) {
        try {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM `hamkar` WHERE id=?;");
            stmt.setInt(1, id);
            int rs = stmt.executeUpdate();
            return rs != 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean deleteClient(int id) {
        try {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM `client` WHERE id=?;");
            stmt.setInt(1, id);
            int rs = stmt.executeUpdate();
            return rs != 0;
        } catch (Exception e) {
            System.out.println("exception occurred with deleting client");

            return false;
        }
    }
}