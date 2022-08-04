/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.DBConnector;
import dto.UserDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ankit Yadav
 */
public class userloginauthentication {
    public boolean isUserLogin(UserDTO user){
        String uemail=user.getUemail();
        String upassword = user.getUpassword();
       
        Statement st=null;
         ResultSet rs=null;
         String tablePassword="";
         
         try{
             
             st=DBConnector.getStatement();
             String query = "SELECT upassword FROM user where uemail='"+uemail+"'";
             System.out.println("Query="+query);
             
             rs=st.executeQuery(query);
             
           
             if(rs.next()){
               
                 tablePassword=rs.getString(1);
                
               
             }
             else{
                 return false;
             }
             
         }
         catch(SQLException e){
             System.out.println(e);
         }
         
        if(uemail!=null && upassword!=null  && upassword.equals(tablePassword)){
            
            return true;
        }
        return false;
    }

    
//    public boolean isUserLogin(String uemail, String upassword) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
