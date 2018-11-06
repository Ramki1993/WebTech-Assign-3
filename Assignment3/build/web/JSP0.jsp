<%-- 
    Document   : JSP2
    Created on : Sep 22, 2009, 3:39:59 PM
    Author     : spring
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CW</title>
        <%--Using Java Bean--%>
        <jsp:useBean id="mb" class="assignment3.myBean" scope="session" />
    </head>
    <body>
        <h2>Welcome
            <%--Using Java Bean to get username--%>
        <jsp:getProperty name="mb" property="name" />
        </h2>
        <br></br>
        <p>The above user name is retrieved from Java Bean</p>
        <%--To List all the users--%>
       <form method ="post" action = "listusers">
        List All Users: <input type="submit" value="ListUsers" name="Submit" />
        </form>
    </body>
</html>
