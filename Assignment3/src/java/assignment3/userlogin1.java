/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Ramki
 */
@WebServlet(name = "userlogin1", urlPatterns = {"/userlogin1"})
public class userlogin1 extends HttpServlet {

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
         Statement st;
         boolean valid = false;
        //Javabean
        HttpSession session=request.getSession(true);
        myBean mb = new myBean();
        session.setAttribute("mb",mb);
        //get user details
        String username = request.getParameter ("username");
        String password = request.getParameter ("password");
        String username1 = null;
        //DBMS Connection
        try{
             Class.forName("org.apache.derby.jdbc.ClientDriver");
             String connectionURL = "jdbc:derby://localhost:1527/ramki";
             conn = DriverManager.getConnection(connectionURL, "is2560", "is2560");
            
             st = conn.createStatement();
            
            String q1 = new String("SELECT * FROM IS2560.USERDETAILS WHERE username = '"+
                username+"'AND password = '"+
                password+"'");
                System.out.println(q1);
                    ResultSet rs=null; 
                    rs=st.executeQuery(q1); 
                      while(rs.next()){ 
                        username1  = rs.getString("username");      
                       } 
                valid=true;
        }        
        catch (SQLException se)
        {
            se.printStackTrace();  
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        if (valid)
        {
        //redirect to welcome page using Request Dispacher
        mb.setName(username1);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP0.jsp");
        rd.forward(request, response);
        }
        //printing errors
        else
        {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Unable to login</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>We were unable to Login: Please try again</p>");
        out.println("<a href =\"index.jsp\">Click here to try again</a>");
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
