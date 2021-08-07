/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.shop;

import dal.CategoryDAO;
import dal.ProductDAO;
import dal.SizeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;

/**
 *
 * @author hp
 */
public class detail extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String pid = request.getParameter("code");

        CategoryDAO cate = new CategoryDAO();
        List<Category> listC = cate.getAllCategory();

        ProductDAO pdb = new ProductDAO();
        Product p = pdb.getProductById(pid);
        List<Product> listP = pdb.getAllProducts();

        SizeDAO sDAO = new SizeDAO();

        int M = sDAO.getQuantityOfSizeByNameAndPid(pid, "M");
        int L = sDAO.getQuantityOfSizeByNameAndPid(pid, "L");
        int XL = sDAO.getQuantityOfSizeByNameAndPid(pid, "XL");

        String sizeM = display(M);
        String sizeL = display(L);
        String sizeXL = display(XL);

        request.setAttribute("sizeM", sizeM);
        request.setAttribute("sizeL", sizeL);
        request.setAttribute("sizeXL", sizeXL);
        request.setAttribute("pid", pid);
        request.setAttribute("listProduct", listP);
        request.setAttribute("detail", p);
        request.setAttribute("listCategory", listC);
        request.getRequestDispatcher("shop/item-detail.jsp").forward(request, response);
        }
    }
    public String display(int iSize) {
        String sizeQuantity = "";
        if (iSize <= 0) {
            sizeQuantity = "Out of stocks";
        } else {
            sizeQuantity = "Left " + iSize + " items";
        }
        return sizeQuantity;
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
        processRequest(request, response);
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
        processRequest(request, response);
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
