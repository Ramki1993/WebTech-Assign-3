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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ramki
 */
@WebServlet(name = "listusers", urlPatterns = {"/listusers"})
public class listusers extends HttpServlet {
    private Connection conn;
    private Statement st;
    private ResultSet rs=null;
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
        PrintWriter out = response.getWriter();
        // Connecting to DB
         try{
              Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/ramki";
            conn = DriverManager.getConnection(connectionURL, "is2560", "is2560");
            st = conn.createStatement();
            String q1 = new String("SELECT username FROM USERDETAILS");
            //Query Execution
            rs =  st.executeQuery(q1);
        }        
        catch (SQLException se)
        {
            se.printStackTrace();  
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
         
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet List Users</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("</h2>");
        out.println("<h1>The following are the list of users</h1>");
        out.println("<ol>");
      //printing output
        try{
           while(rs.next())
           {
             out.println("<li>"+rs.getString("username")+"</li>");
           }
       }
       catch(SQLException sqle)
                 {
            sqle.printStackTrace();  
        }
        out.println("</ol>");
        //redirect to loginpage
        out.println("<a href =\"index.jsp\">Click here go back to login page</a>");
        out.println("</body>");
        out.println("</html>");
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
