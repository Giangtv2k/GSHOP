/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cart;

import dal.ProductDAO;
import dal.SizeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Item;
import model.Product;

/**
 *
 * @author hp
 */
public class cartProcess extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        Cart cart = null;
        Object o = session.getAttribute("cart");

        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }

        String pid = request.getParameter("pid");
        String sizeName = request.getParameter("size");
        String sQuantity = request.getParameter("quantity");
        int quantity, remainQuantity;
        String err;
        try {
            ProductDAO pDAO = new ProductDAO();
            SizeDAO sDAO = new SizeDAO();

            quantity = Integer.parseInt(sQuantity);
            remainQuantity = sDAO.getQuantityOfSizeByNameAndPid(pid, sizeName);

            if ((quantity == -1) && (cart.getQuantityById(pid) <= 1)) {
                cart.removeItem(pid);
            } else {
                quantity += 1;
                if (quantity > remainQuantity) { // if the quantity of this size that order by user much more than remainning quantity
                    quantity = remainQuantity;
                }
                Product p = pDAO.getProductById(pid);
                double price = p.getPrice();
                Item t = new Item(p, quantity, price, sizeName);
                cart.addItem(t);
            }
        } catch (NumberFormatException e) {
            System.out.println("");
        }
        List<Item> list = cart.getItems();

        session.setAttribute("cart", cart);
        session.setAttribute("numOfItems", list.size());
        request.getRequestDispatcher("shop/cart.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        Cart cart = null;
        Object o = session.getAttribute("cart");

        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }
        String pid = request.getParameter("pid");
        cart.removeItem(pid);

        List<Item> list = cart.getItems();

        session.setAttribute("cart", cart);
        session.setAttribute("numOfItems", list.size());
        request.getRequestDispatcher("shop/cart.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
