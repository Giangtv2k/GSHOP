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
import model.Revenue;

/**
 *
 * @author Minh Thanh
 */
public class RevenueDAO extends DBcontext1 {

    private PreparedStatement st;
    private ResultSet rs;

    public List<Revenue> getAllRevenue() {

        List<Revenue> list = new ArrayList<>();
        String sql = "SELECT DISTINCT p.[id],\n"
                + "p.[name],\n"
                + "p.[image],\n"
                + "p.[price],\n"
                + "ol.[size],\n"
                + "ol.[quantity],\n"
                + "o.[id],\n"
                + "o.[usernameCustomer],\n"
                + "o.[date]\n"
                + "FROM Products p\n"
                + "JOIN Size s ON s.pid = p.id\n"
                + "JOIN OrderLine ol ON ol.pid = p.id\n"
                + "JOIN Orders o ON o.id = ol.oid\n";
        try {

            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                double totalMoney = rs.getInt("quantity") * rs.getDouble("price") * 1.05;
                Revenue r = new Revenue(rs.getString(1),// pid
                        rs.getString(2), // productName
                        rs.getString(3), // image
                        rs.getDouble(4), // price
                        rs.getString(5), // size ordered
                        rs.getInt(6), // quantity ordered
                        rs.getInt(7), // order id
                        rs.getString(8), // username of customer
                        rs.getDate(9),
                        totalMoney); // order date
                list.add(r);
            }

        } catch (SQLException e) {

        }
        return list;
    }

    public List<Revenue> filterRevenueWithTimeline(String command) {

        List<Revenue> list = new ArrayList<>();
        String sql = "SELECT DISTINCT p.[id],\n"
                + "p.[name],\n"
                + "p.[image],\n"
                + "p.[price],\n"
                + "ol.[size],\n"
                + "ol.[quantity],\n"
                + "o.[id],\n"
                + "o.[usernameCustomer],\n"
                + "o.[date]\n"
                + "FROM Products p\n"
                + "JOIN Size s ON s.pid = p.id\n"
                + "JOIN OrderLine ol ON ol.pid = p.id\n"
                + "JOIN Orders o ON o.id = ol.oid\n"
                + command;
        try {

            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                double totalMoney = rs.getInt("quantity") * rs.getDouble("price") * 1.05;
                Revenue r = new Revenue(
                        rs.getString(1), // pid
                        rs.getString(2), // productName
                        rs.getString(3), // image
                        rs.getDouble(4), // price
                        rs.getString(5), // size ordered
                        rs.getInt(6), // quantity ordered
                        rs.getInt(7), // order id
                        rs.getString(8), // username of customer
                        rs.getDate(9), // order date                        
                        totalMoney); // total Revenue
                list.add(r);
            }

        } catch (SQLException e) {

        }
        return list;
    }

    public static void main(String[] args) {
        RevenueDAO dao = new RevenueDAO();
        List<Revenue> list = dao.getAllRevenue();
        for (Revenue revenue : list) {
            System.out.println(revenue);
        }
    }
}
