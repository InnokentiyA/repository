package com.mycompany.testapplication.entity.controller;

import com.mycompany.testapplication.entity.business.BusinessFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistrationServlet", urlPatterns = {"/RegistrationServlet"})
public class RegistrationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {*/
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String message = null;
            
            System.out.println("username" + username);
             System.out.println("password" + password);
            
            System.out.println("AAAAAAAAAAAAAAAA" + username);
            
            boolean registerOk = false;
            try {
                registerOk = BusinessFacade.registerUser(username, email, password);
            } catch (SQLException ex) {
                Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
  
        if (!registerOk) {
            out.println("Wrong");
        } else {
            out.println("GOOD");
            
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
        System.out.println("MYYYYYY SSSERVLETTT");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

/*String username = request.getParameter("usernamesignup");
            String email = request.getParameter("emailsignup");
            String password = request.getParameter("passwordsignup");

            try {

                //loading drivers for mysql
                Class.forName("com.mysql.jdbc.Driver");

                //creating connection with the database 
                Connection con = DriverManager.getConnection("jdbc:mysql:/ /127.0.0.1:3306/sportclub", "username", "password");

                PreparedStatement ps = con.prepareStatement("insert into `user` values(?,?,?)");

                ps.setString(1, username);
                ps.setString(2, email);
                ps.setString(3, password);
                int i = ps.executeUpdate();

                if (i > 0) {
                    out.println("You are sucessfully registered");
                }

            } catch (Exception se) {
                se.printStackTrace();
            }

        }*/

 /*String message = null;
            User user = BusinessFacade.registerUser(firstName, email, password, Sex.Male);

            
            if (user == null) {
                out.println("Wrong");

            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                out.println(user.getFirstName());
            }*/
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
/**
 * Handles the HTTP <code>POST</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
