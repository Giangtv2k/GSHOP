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
import model.Category;

/**
 *
 * @author Minh Thanh
 */
public class CategoryDAO extends DBcontext1 {

    private PreparedStatement st;
    private ResultSet rs;

    public List<Category> getAllCategory() {

        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM Categories";

        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Category cate = new Category(rs.getString(1),
                                                rs.getString(2), 
                                                rs.getString(3));
                list.add(cate);
            }
        } catch (SQLException ex) {
        }
        return list;
    }
    
    public static void main(String[] args) {
        CategoryDAO dao = new CategoryDAO();
        List<Category> list = dao.getAllCategory();
        
        for (Category category : list) {
            System.out.println(list);
        }
    }

}
