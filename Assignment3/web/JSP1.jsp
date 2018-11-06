<%-- 
    Document   : jsp1
    Created on : Nov 5, 2018, 7:05:27 PM
    Author     : Ramki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Sign Up Page</title>
    </head>
    <body>
        <h1>User Sign Up Page</h1>
    <%--User signup page--%>
    <form method ="post" action = "usersignup">
        <table border="1">
            <tbody>
                <tr>
                    <td>Enter new username:</td>
                    <td><input type="text" name="username" value="" size="50" /></td>
                </tr>
                 <tr>
                    <td>Enter new password:</td>
                    <td><input type="password" name="password" value="" size="50" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Signup" name="Submit" /></td>
                </tr>
            </tbody>
        </table>
   </form> 
    </body>
</html>
