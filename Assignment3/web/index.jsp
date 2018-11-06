<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Users</title>
    </head>
    <body>
<%--Simulating User Login and Sign Up process--%>
    <h1>User Login Page</h1>
    
    <form method ="post" action = "userlogin1">
        <table border="1">
            <tbody>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="username" value="" size="50" /></td>
                </tr>
                 <tr>
                    <td>password:</td>
                    <td><input type="password" name="password" value="" size="50" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit" name="Submit" /></td>
                </tr>
            </tbody>
        </table>
   </form> 
     <p>New User Sign Up now!</p>
        <a href="JSP1.jsp">Signup</a>
    </body>
</html>
