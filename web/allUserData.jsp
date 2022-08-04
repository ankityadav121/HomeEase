<%-- 
    Document   : allUserData
    Created on : 10 Mar, 2022, 5:11:33 PM
    Author     : Ankit Yadav
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="dto.UserDTO"%>
<%@page import="dao.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Users</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
        UserDAO udao = new UserDAO();
        List<UserDTO> listofUsers = udao.getAllUserData();
        Iterator<UserDTO> itr =listofUsers.iterator();
        
        %>
        <table border="1px ">
            <tr>
                <td><strong>User Name</strong></td>
                 <td><strong>User Email</strong></td>
                  <td><strong>User Address</strong></td>
                   <td><strong>User Phone</strong></td>
                    <td><strong>User Password</strong></td>
                 
            </tr>
            <%
            while(itr.hasNext()){
                UserDTO user=itr.next();
            %>
             <tr>
                 <td><strong><%=user.getUname()%></strong></td>
                 <td><strong><%=user.getUemail()%></strong></td>
                  <td><strong><%=user.getUaddress()%></strong></td>
                   <td><strong><%=user.getUphone()%></strong></td>
                    <td><strong><%=user.getUpassword()%></strong></td>
                 
            </tr>
            <%
                }
             %>
        </table>
    </body>
</html>
