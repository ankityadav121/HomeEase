<%-- 
    Document   : home
    Created on : 5 Mar, 2022, 2:10:43 PM
    Author     : Ankit Yadav
--%>

<%@page import="dto.UserDTO"%>
<%@page import="dao.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="logout.jsp">Sign out</a>
        
        <%
         String uemail=(String) session.getAttribute("uemail");
         if(uemail==null){
             response.sendRedirect("loginuser.html");
             
         }
         UserDAO udao=new UserDAO();
         UserDTO user= udao.getUserData(uemail);
         
        %>
        <h1>Welcome <%=uemail%>...!</h1>
        <h2>Login successful</h2>
        <table>
            <tr>
                <td> <strong> User Name</strong></td>
                <td> <strong> <%=user.getUname()%></strong></td>
               
            </tr>
             <tr>
                <td> <strong> User Email</strong></td>
                <td> <strong> <%=user.getUemail()%></strong></td>
               
            </tr>
             <tr>
                <td> <strong> User Address</strong></td>
                <td> <strong><%=user.getUaddress()%></strong></td>
               
            </tr>
             <tr>
                <td> <strong> User Phone</strong></td>
                <td> <strong> <%=user.getUphone()%></strong></td>
               
            </tr>
             <tr>
                <td> <strong> User Password</strong></td>
                <td> <strong> <%=user.getUpassword()%></strong></td>
               
        </table>
           
    </body>
</html>
