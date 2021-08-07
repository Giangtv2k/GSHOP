/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import context.DBcontext1;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Size;

/**
 *
 * @author Minh Thanh
 */
public class SizeDAO extends DBcontext1 {

    private PreparedStatement st;
    private ResultSet rs;

    public List<Size> getAllSizeInfor() {

        List<Size> list = new ArrayList<>();
        String sql = "SELECT * FROM Size";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Size s = new Size(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3));
                list.add(s);
            }
        } catch (SQLException e) {

        }

        return list;
    }

    public List<Size> getAllSizeInforByPid(String pid) {

        List<Size> list = new ArrayList<>();
        String sql = "SELECT * FROM Size WHERE pid = ?";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, pid);
            rs = st.executeQuery();
            while (rs.next()) {
                Size s = new Size(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3));
                list.add(s);
            }
        } catch (SQLException e) {

        }

        return list;
    }

    public Size getSizeByPid(String pid) {

        String sql = "SELECT * FROM Size WHERE pid = ?";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, pid);
            rs = st.executeQuery();
            while (rs.next()) {
                Size s = new Size(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3));
                return s;
            }
        } catch (SQLException e) {

        }
        return null;
    }

    public int getQuantityOfSizeByNameAndPid(String pid, String name) {
        String sql = "SELECT size_quantity FROM [Size] WHERE pid = ? AND name = ?";
        int quantity = 0;
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, pid);
            st.setString(2, name);

            rs = st.executeQuery();

            if (rs.next()) {
                quantity = rs.getInt(1);
                return quantity;
            }
        } catch (SQLException e) {

        }
        return quantity;
    }

    public void addSizeInfor(Size size) {
        String sql = "INSERT INTO Size VALUES(?,?,?)";

        try {
            st = connection.prepareStatement(sql);
            st.setString(1, size.getPid());
            st.setString(2, size.getName());
            st.setInt(3, size.getSize_quantity());

            st.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void deleteSizeByPid(String pid) {
        String sql = "DELETE FROM Size WHERE pid = ? ";

        try {
            st = connection.prepareStatement(sql);
            st.setString(1, pid);

            st.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void updateQuantityByNameAndPid(Size s) {
        String sql = "UPDATE Size\n"
                + "SET size_quantity = ?\n"
                + "WHERE pid = ? AND name = ?";
        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, s.getSize_quantity());
            st.setString(2, s.getPid());
            st.setString(3, s.getName());

            st.executeUpdate();
        } catch (SQLException e) {

        }
    }
    
    public void reduceQuantityByNameAndPid(String pid, String sizeName, int quantitySold) {
        int remainingQuantity = getQuantityOfSizeByNameAndPid(pid, sizeName);
        String sql = "UPDATE Size\n"
                + "SET size_quantity = ?\n"
                + "WHERE pid = ? AND name = ?";
        try {
            st = connection.prepareStatement(sql);
            st.setInt(1,remainingQuantity - quantitySold); //reduce the quantity
            st.setString(2, pid);
            st.setString(3, sizeName);

            st.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void editSizeByPid(Size s) {
        String sql = "UPDATE Size\n"
                + "SET size_quantity = ?\n"
                + "WHERE pid = ? AND name = ?";
        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, s.getSize_quantity());
            st.setString(2, s.getPid());
            st.setString(3, s.getName());

            st.executeUpdate();
        } catch (SQLException e) {

        }
    }
}
