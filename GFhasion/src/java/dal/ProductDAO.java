/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import context.DBcontext1;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import model.Size;

/**
 *
 * @author Minh Thanh
 */
public class ProductDAO extends DBcontext1 {

    private PreparedStatement st;
    private ResultSet rs;

    public List<Product> getAllProducts() {

        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Products";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            SizeDAO sDAO = new SizeDAO();
            while (rs.next()) {
                Product p = new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getDate(7)
                );
                List<Size> listSize = sDAO.getAllSizeInforByPid(rs.getString(1));
                p.setListSize(listSize);

                list.add(p);
            }
        } catch (SQLException ex) {

        }
        return list;
    }

    public List<Product> getAllProductsByCondition(String condition) {

        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Products ORDER BY " + condition;
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getDate(7)
                );

                list.add(p);
            }
        } catch (SQLException ex) {

        }
        return list;
    }

    public List<Product> searchProductByName(String txtName) {

        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE [name] LIKE ?";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, "%" + txtName + "%");
            rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getDate(7)
                );
                list.add(p);
            }
        } catch (SQLException ex) {

        }
        return list;
    }

    public List<Product> groupProductByCategoryId(String cid) {

        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE [cid] = ?";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, cid);
            rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getDate(7)
                );
                list.add(p);
            }
        } catch (SQLException ex) {

        }
        return list;
    }

    public List<Product> groupProductByCidAndCondition(String cid, String condition) {

        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE [cid] = ? ORDER BY " + condition;
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, cid);
            rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getDate(7)
                );
                list.add(p);
            }
        } catch (SQLException ex) {

        }
        return list;
    }

    public Product getProductById(String pid) {

        String sql = "SELECT * FROM Products WHERE [pid] = ?";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, pid);
            rs = st.executeQuery();
            if (rs.next()) {
                Product p = new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getDate(7)
                );
                return p;
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    public boolean addProduct(Product p) {
        String sql = "INSERT INTO Products VALUES(?, ? , ?, ?, ?, ?, ?)";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, p.getId());
            st.setString(2, p.getName());
            st.setString(3, p.getCid());
            st.setString(4, p.getImage());
            st.setDouble(5, p.getPrice());
            st.setString(6, p.getDescription());
            st.setDate(7, (Date) p.getDateCreated());

            if (!isExistProductID(p.getId())) {
                st.executeUpdate();
                return true;
            }
        } catch (SQLException e) {

        }
        return false;
    }

    public void deleteProduct(String pid) {
        String sql = "DELETE FROM Products WHERE pid = ?";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, pid);
            st.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void editProduct(Product p) {
        String sql = "UPDATE Products\n"
                + "SET name = ?, cid=?, image = ?, price = ?, description=?, dateCreated = ?\n"
                + "WHERE id = ?";
        try {
            st = connection.prepareStatement(sql);

            st.setString(1, p.getName());
            st.setString(2, p.getCid());
            st.setString(3, p.getImage());
            st.setDouble(4, p.getPrice());
            st.setString(5, p.getDescription());
            st.setDate(6, (Date) p.getDateCreated());
            st.setString(7, p.getId());

            st.executeUpdate();

        } catch (SQLException e) {

        }

    }

//Paging

    public List<Product> getProductByPage(int pageIndex, int pageSize) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * from products ORDER BY id "
                + "OFFSET (?*?-?) ROWS FETCH NEXT ? ROWS ONLY";
        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, pageIndex);
            st.setInt(2, pageSize);
            st.setInt(3, pageSize);
            st.setInt(4, pageSize);
            rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getDate(7)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return list;
    }

    public int countPage(int pageSize) {
        String sql = "select Count(*) from products"; //count number of all product
        try {

            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1); //get number of product
            }
            int numOfPage = count / pageSize;
            if (count % pageSize != 0) {
                numOfPage++;
            }
            return numOfPage;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return 0;
    }

    //getproduct by categoryID with paging
    public ArrayList getProductByCategoryWithPaging(int cateID, int pageIndex, int pageSize) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "with t as (select * from products where cid = ?)\n"
                + "                    SELECT * FROM t ORDER BY t.id\n"
                + "                    OFFSET (?*?-?) ROWS FETCH NEXT ? ROWS ONLY";
        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, cateID);
            st.setInt(2, pageIndex);
            st.setInt(3, pageSize);
            st.setInt(4, pageSize);
            st.setInt(5, pageSize);
            rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getDate(7)));
            }
        } catch (SQLException ex) {
        }
        return list;
    }

    public int countPageWithCategory(int pageSize, String cateID) {
        String sql = "select Count(*) from products where cid = ?";

        try {
            st = connection.prepareStatement(sql);
            st.setString(1, cateID);
            rs = st.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
            }
            int numOfPage = count / pageSize;
            if (count % pageSize != 0) {
                numOfPage++;
            }
            return numOfPage;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return 0;
    }

    public boolean isExistProductID(String pid) {
        ProductDAO dao = new ProductDAO();
        List<Product> list = dao.getAllProducts();
        for (Product product : list) {
            if (product.getId().equalsIgnoreCase(pid)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ProductDAO pa = new ProductDAO();
//         List<Product> p = pa.getAllProducts();
        List<Product> p = pa.getAllProductsByCondition("[name] desc");

//        System.out.println(p);
        for (Product product : p) {
            System.out.println(product);
            System.out.println("");
        }
    }
}
