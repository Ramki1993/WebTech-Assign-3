/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ramki
 */
@WebServlet(name = "usersignup", urlPatterns = {"/usersignup"})
public class usersignup extends HttpServlet {
     private Connection conn;
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
        
            /* TODO output your page here. You may use following sample code. */
        //Getting user input
        Statement st;
        boolean valid = false;
        String username = request.getParameter ("username");
        String password = request.getParameter ("password");
        String username1 = null;
     //DBMS connection
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/ramki";
            conn = DriverManager.getConnection(connectionURL, "is2560", "is2560");
            String sql = "INSERT INTO IS2560.USERDETAILS (USERNAME, PASSWORD) VALUES ('"+username+"','"+password+"')"; 
            st = conn.createStatement(); 
            st.executeUpdate(sql); 
            st.close(); 
            conn.close();
            valid = true;
             
     }
     catch (SQLException se)
        {
            se.printStackTrace();  
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        //printing output
      PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        if (valid)
        {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>New User Addtion</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Insert Successfull</p>");
        out.println("<a href =\"index.jsp\">Click here to login</a>");        
        out.println("</body>");
        out.println("</html>"); 
        }
        //printing errors
        else
        {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Insertion Problem</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>We were unable to Insert:</p>");
        out.println("<a href =\"JSP1.jsp\">Please Try again</a>");
        out.println("</body>");
        out.println("</html>");   
        }
        out.close();
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
