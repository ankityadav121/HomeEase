<%-- 
    Document   : logout
    Created on : 5 Mar, 2022, 2:22:54 PM
    Author     : Ankit Yadav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% session.invalidate();
      response.sendRedirect("loginworker.html");
      %>
    </body>
</html>
