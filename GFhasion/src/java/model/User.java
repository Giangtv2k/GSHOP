/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {

    private String account, password, fullname, address;
    private boolean gender;
    private String dob, role;
    private int points;

    public User() {
        connect();
    }

    public User(String account) {
        this.account = account;
        connect();
    }

    public User(String acount, String pasword) {
        this.account = acount;
        this.password = pasword;
        connect();
    }

    public User(String account, String password, String fullname, String address, boolean gender, String dob, String role, int points) {
        this.account = account;
        this.password = password;
        this.fullname = fullname;
        this.address = address;
        this.gender = gender;
        this.dob = dob;
        this.role = role;
        this.points = points;
        connect();
    }

    private void connect() {
        try {
            cnn = (new DBContext().getConnection());
            System.out.println("Connect successfully!");
        } catch (Exception e) {
            System.out.println("Lỗi connect:" + e.getMessage());
        }
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    Connection cnn;//kết nối
    Statement stm;//Thực hiện câu lệnh SQL
    ResultSet rs;//chứa kết quả trả về từ câu lệnh select và xử lý

    public boolean checkAccount() {
        try {
            String strSelect = "select * from Users where account='" + account + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);//Thực hiện câu lệnh select
            while (rs.next()) {
                return true;//Tai khoan ton tai
            }
        } catch (Exception e) {
            System.out.println("Login error:" + e.getMessage());
        }
        return false;
    }

    public boolean checkAccountPassword() {
        try {
            String strSelect = "select * from Users where account='" + account + "'and password='" + password + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);//Thực hiện câu lệnh select
            while (rs.next()) {
                return true;//Tai khoan ton tai
            }
        } catch (Exception e) {
            System.out.println("Login error:" + e.getMessage());
        }
        return false;
    }

    private PreparedStatement st;
    private Connection connection;

    public void signup(String username, String password, String fullName, String address, boolean gender, String dob, String role, int points) throws Exception {

        String sql = "INSERT INTO Users VALUES(?,?,?,?,?,?,?,?)";

        try {
            DBContext context = new DBContext();
            connection = context.getConnection();
            st = connection.prepareStatement(sql);

            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, fullName);
            st.setString(4, address);
            st.setBoolean(5, gender);
            st.setString(6, dob);
            st.setString(7, role);
            st.setInt(8, points);
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("error add:" + e.getMessage());
        }
    }

    public void Update(String Name, String address, boolean gender, String dob, String role, int points, String account) throws Exception {
        String sql = "Update Users set fullname = ?, address = ?, gender=?,dob=?,role=?,points=? Where account = ?";

        try {
            DBContext context = new DBContext();
            connection = context.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, Name);
            st.setString(2, address);
            st.setBoolean(3, gender);
            st.setString(4, dob);
            st.setString(5, role);
            st.setInt(6, points);
            st.setString(7, account);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error add:" + e.getMessage());
        }
    }

    public void UpdatePass(String pass, String account) throws Exception {
        String sql = "Update Users set password = ? Where account = ?";

        try {
            DBContext context = new DBContext();
            connection = context.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, pass);
            st.setString(2, account);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error add:" + e.getMessage());
        }
    }

    public boolean login() {
        try {
            String strSelect = "select * from Users where account='" + account + "'and password='" + password + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);//Thực hiện câu lệnh select
            while (rs.next()) {
                return true;//login thành công
            }
        } catch (Exception e) {
            System.out.println("Login error:" + e.getMessage());
        }
        return false;
    }

    public void DeleteByAccount() {
        try {
            String sql = "Delete from Users where account='" + account + "'AND role <> 1"
                    + "DELETE FROM Orders WHERE usernameCustomer = '"+account+"'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);//Thực hiện câu lệnh select
        } catch (Exception e) {
            System.out.println("Delete failse: " + e.getMessage());
        }
    }

    public String getRoleByAccount(String account1){
        try {
            String strSelect = "select role from Users where account = '"+account1+"'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);//Thực hiện câu lệnh select
            while (rs.next()) {
                String role = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Get User error:" + e.getMessage());
        }
        return role;
    }
    
    public ArrayList<User> getListUser() {
        ArrayList<User> list = new ArrayList<User>();

        //xử lý getlist
        try {
            String strSelect = "select * from Users";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);//Thực hiện câu lệnh select
            while (rs.next()) {
                String account = rs.getString(1);
                String pass = rs.getString(2);
                String name = rs.getString(3);
                boolean gender = rs.getBoolean(5);
                String address = rs.getString(4);
                SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");
                String dob = f.format(rs.getDate(6));
                String role = rs.getString(7);
                int points = rs.getInt(8);
                User u = new User(account, pass, name, address, gender, dob, role, points);
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println("Get User error:" + e.getMessage());
        }

        return list;
    }

    public User getUserByName(String name1) {

        //xử lý getlist
        try {
            String strSelect = "select * from Users where account = '" + name1 + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);//Thực hiện câu lệnh select
            while (rs.next()) {
                String account = rs.getString(1);
                String pass = rs.getString(2);
                String name = rs.getString(3);
                boolean gender = rs.getBoolean(5);
                String address = rs.getString(4);
                SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");
                String dob = f.format(rs.getDate(6));
                String role = rs.getString(7);
                int points = rs.getInt(8);
                User u = new User(account, pass, name, address, gender, dob, role, points);
                return u;
            }
        } catch (Exception e) {
            System.out.println("Get User error:" + e.getMessage());
        }

        return null;
    }

}
