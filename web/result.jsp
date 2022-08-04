<%-- 
    Document   : result
    Created on : 7 Apr, 2022, 9:59:11 PM
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
       <%
String message = request.getParameter("message");
if(message != null){
out.print(message);
}
%>
    </body>
</html>
