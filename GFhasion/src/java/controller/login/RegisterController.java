/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author hp
 */
public class RegisterController extends HttpServlet {

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
            if (request.getParameter("account").isEmpty() || request.getParameter("account") == null
                    || request.getParameter("pass").isEmpty() || request.getParameter("pass") == null) {
                request.setAttribute("message", "Enter account and password!");
                request.getRequestDispatcher("login/signup.jsp").forward(request, response);
            }
            String account = request.getParameter("account");
            String pass = request.getParameter("pass");
            String repass = request.getParameter("repass");
            String name = request.getParameter("name");
            String gender = request.getParameter("radio").equalsIgnoreCase("male") ? "Male" : "Female";
            boolean sex = gender.equalsIgnoreCase("male") ? true : false;
            String address = request.getParameter("address");
            String dob = request.getParameter("dob");

            User u = new User(account);
            if (u.checkAccount()) {
                request.setAttribute("message", "Account exit!");
                request.getRequestDispatcher("login/signup.jsp").forward(request, response);
            } else {
                if (!pass.equals(repass)) {
                    request.setAttribute("message", "Password and Re-pass need equals!");
                    request.getRequestDispatcher("login/signup.jsp").forward(request, response);
                } else {
                    User u1 = new User();
                    u1.signup(account, pass, name, address, sex, dob, "2", 10000);
                    request.setAttribute("message", "Register successfully");
                    request.getRequestDispatcher("login/login.jsp").forward(request, response);
                }
            }
        } catch (Exception ex) {
            System.out.println("error register: "+ex.getMessage());
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

        request.getRequestDispatcher("login/signup.jsp").forward(request, response);
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
