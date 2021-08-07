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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Cart;
import model.Item;
import model.User;

/**
 *
 * @author Minh Thanh
 */
public class OrderDAO extends DBcontext1 {

    private PreparedStatement st;
    private ResultSet rs;

    public void addOrder(User u, Cart cart) {

        try {

            LocalDate curDate = java.time.LocalDate.now();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = null;
            utilDate = sdf.parse(curDate.toString());
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            try {
                //add vào bảng Order
                String sql = "insert into [orders] values(?,?,?)";
                st = connection.prepareStatement(sql);
                st.setDate(1, sqlDate);
                st.setString(2, u.getAccount());
                st.setDouble(3, cart.getTotalMoney());
                st.executeUpdate();
                //lấy ra id của Order vừa add
                String sql1 = "select top 1 id from [Orders] order by id desc";
                PreparedStatement st1 = connection.prepareStatement(sql1);
                ResultSet rs = st1.executeQuery();
                //add vào bảng OrderLine
                if (rs.next()) {
                    int oid = rs.getInt(1);
                    for (Item i : cart.getItems()) {
                        String sql2 = "insert into [orderline] values(?,?,?,?,?)";
                        PreparedStatement st2 = connection.prepareStatement(sql2);
                        st2.setInt(1, oid);
                        st2.setString(2, i.getProduct().getId());
                        st2.setString(3, i.getSize());
                        st2.setInt(4, i.getQuantity());
                        st2.setDouble(5, i.getPrice());
                        st2.executeUpdate();
                    }
                }

            } catch (SQLException e) {
                System.out.println(e);
            }
        } catch (ParseException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
