
import db.DBConnector;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig(maxFileSize = 16177215)


public class test extends HttpServlet {
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
      response.sendRedirect("registerworker.html");
       
    }
     
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         String wname=request.getParameter("wname");
         String waddress=request.getParameter("waddress");
         String wemail=request.getParameter("wemail");
        
         String wphone=request.getParameter("wphone");
         String waadhar=request.getParameter("waadhar");
          String waddressproof=request.getParameter("waddressproof");
         String wpassword=request.getParameter("wpassword");
         
         String wjoiningdate=request.getParameter("wjoiningdate");
       
         String wcategory=request.getParameter("wcategory");
         String wrating=request.getParameter("wrating");
         String wage=request.getParameter("wage");
         String warea=request.getParameter("warea");
         String wlocation=request.getParameter("wlocation");
//         String wprofile=request.getParameter("wprofile");
         
        InputStream inputStream=null;
        Part filePart = request.getPart("wprofile");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
         
        
         
         
         PrintWriter out = response.getWriter();


        
         Statement st=null;
         ResultSet rs=null;

         String tableEmail="";
         try{
             
             st=DBConnector.getStatement();
             
             
             String query1 = "SELECT wemail from worker where wemail='"+wemail+"'";
             System.out.println("Query="+query1);
             rs=st.executeQuery(query1);
             if(rs.next()){
                
                 tableEmail=rs.getString(2);
                
             }
             if(wemail.equals(tableEmail)){

                out.println("user already registered");
          }
          else{

               String query="INSERT INTO worker values(1,'"+wemail+"','"+wname+"','"+wpassword+"','"+wphone+"','"+waadhar+"','"+waddressproof+"','"+waddress+"','"+wjoiningdate+"','"+wcategory+"','"+wrating+"','"+wage+"','"+warea+"','"+wlocation+"','"+filePart+"')";
             System.out.println("Query="+query);
             int i=st.executeUpdate(query);
             
             if(i>0){
               System.out.println("Record Inserted");
                 response.sendRedirect("loginworker.html");
             }else{
                 System.out.println("Record Insertion failed");
                 response.sendRedirect("registerworker.html");
             }
          }
             
      
         }
         catch(SQLException e){
             System.out.println(e);
         }
     
    }
}
