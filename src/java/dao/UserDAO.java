/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBConnector;
import dto.UserDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ankit Yadav
 */
public class UserDAO {
    
    public UserDTO getUserData(String uemail)
    { 
        UserDTO user=new UserDTO();
        try{
           
            Statement st=DBConnector.getStatement();
            String query= "SELECT * FROM user WHERE uemail='"+uemail+"'";
            ResultSet rs=st.executeQuery(query);
            if(rs.next()){
                
                user.setUname(rs.getString(1));
                user.setUemail(rs.getString(2));
                user.setUaddress(rs.getString(3));
                user.setUphone(rs.getString(4));
                user.setUpassword(rs.getString(5));
                
                rs.getString(1);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return user;
    }
    
    public List<UserDTO> getAllUserData(){
        List<UserDTO> listofUsers =new ArrayList<UserDTO>();
        try{
            Statement st=DBConnector.getStatement();
            String query= "SELECT * FROM user";
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                UserDTO user=new UserDTO();
               
                 user.setUname(rs.getString(1));
                user.setUemail(rs.getString(2));
                user.setUaddress(rs.getString(3));
                user.setUphone(rs.getString(4));
                user.setUpassword(rs.getString(5));
                listofUsers.add(user);
                
            }
            
            }
          catch(SQLException e){
              System.out.println(e);
                    
          }
        return listofUsers;
    }
    
}
