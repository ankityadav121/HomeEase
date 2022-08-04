/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.DBConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ankit Yadav
 */
public class LoginAuthentication {
    public boolean isLogin(String wemail, String wpassword){
        Statement st=null;
         ResultSet rs=null;
         String tablePassword="";
         
         try{
             
             st=DBConnector.getStatement();
             String query = "SELECT wpassword FROM worker where wemail='"+wemail+"'";
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
         
        if(wemail!=null && wpassword!=null  && wpassword.equals(tablePassword)){
            return true;
        }
        return false;
    }
}
