/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.LoginAuthentication;

public class Loginworker extends HttpServlet {
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
      response.sendRedirect("loginworker.html");
        }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         String email=request.getParameter("email");
         String password=request.getParameter("password");
        
         PrintWriter out = response.getWriter();
         LoginAuthentication la=new LoginAuthentication();
         boolean login = la.isLogin(email, password);
             

          
          if(login){
               HttpSession session=request.getSession(true);
               session.setAttribute("email",email);
                response.sendRedirect("home.jsp");
               
          }
          else{

               response.sendRedirect("loginworker.html");
              
          }
          
    }
}
