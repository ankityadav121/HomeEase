
import db.DBConnector;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class registeruser extends HttpServlet {
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
      response.sendRedirect("registeruser.html");
       
    }
     
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         String uname=request.getParameter("uname");
         String uaddress=request.getParameter("uaddress");
         String uemail=request.getParameter("uemail");
        
         String uphone=request.getParameter("uphone");
         
         
         String upassword=request.getParameter("upassword");
                  
         PrintWriter out = response.getWriter();
        
         Statement st=null;
         ResultSet rs=null;

         String tableEmail="";
         try{
             
             st=DBConnector.getStatement();
             
             
             String query1 = "SELECT uemail from user where uemail='"+uemail+"'";
             System.out.println("Query="+query1);
             rs=st.executeQuery(query1);
             if(rs.next()){
                
                 tableEmail=rs.getString(1);
                  
             }
             if(uemail.equals(tableEmail)){

                out.println("user already registered");
          }
          else{

               String query="INSERT INTO user values('"+uname+"','"+uemail+"','"+uaddress+"','"+uphone+"','"+upassword+"')";
             System.out.println("Query="+query);
             int i=st.executeUpdate(query);
             
             if(i>0){
               System.out.println("Record Inserted");
                 response.sendRedirect("loginuser.html");
             }else{
                 System.out.println("Record Insertion failed");
                 response.sendRedirect("registeruser.html");
             }
          }
             
      
         }
         catch(SQLException e){
             System.out.println(e);
         }
     
    }
}
