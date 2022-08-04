///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package model;
//
//import db.DBConnector;
//import java.io.PrintWriter;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
///**
// *
// * @author Ankit Yadav
// */
//public class RegisterAuthentication {
//    public boolean isRegister(String uname, String uemail, String upassword,String uaddress, String uphone, String uaadhar,String uaddressproof, String ujoiningdate){
//         String tableEmail="";
//         PrintWriter out = response.getWriter();
//          Statement st=null;
//         ResultSet rs=null;
//         try{
//             
//             st=DBConnector.getStatement();
//             
//             
//             String query1 = "SELECT uemail from user where uemail='"+uemail+"'";
//             System.out.println("Query="+query1);
//             rs=st.executeQuery(query1);
//             if(rs.next()){
//                
//                 tableEmail=rs.getString(1);
//             }
//             else{
//                 return false;
//             }
//             if(uemail.equals(tableEmail)){
//
////                out.println("user already registered");
//                boolean reg=true;
//          }
//          else{
//
//               String query="INSERT INTO user values('"+uemail+"','"+uname+"','"+upassword+"','"+uphone+"','"+uaadhar+"','"+uaddressproof+"','"+uaddress+"','"+ujoiningdate+"')";
//             System.out.println("Query="+query);
//             int i=st.executeUpdate(query);
//             
//               }
//             }catch(SQLException e){
//             System.out.println(e);
//             }
//         
//             if(i>0){
////               System.out.println("Record Inserted");
////                 response.sendRedirect("loginworker.html");
//                    return true;
//             }else{
////                 System.out.println("Record Insertion failed");
////                 response.sendRedirect("registerworker.html");
//                    return false;
//             }
//          
//             
//      
//       
//         
//         
//    
//    }
//   
//}
