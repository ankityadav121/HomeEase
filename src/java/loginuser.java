/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.userloginauthentication;

public class loginuser extends HttpServlet {
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
      response.sendRedirect("loginuser.html");
        }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         String uemail=request.getParameter("uemail");
         String upassword=request.getParameter("upassword");
         
         UserDTO user=new UserDTO();
         user.setUemail(uemail);
         user.setUpassword(upassword);
         
        
         PrintWriter out = response.getWriter();
         userloginauthentication ula=new userloginauthentication();
         boolean login = ula.isUserLogin(user);
             

          
          if(login){
               HttpSession session=request.getSession(true);
              
               session.setAttribute("uemail",uemail);
//                response.sendRedirect("home.jsp");
                  RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
                  rd.forward(request, response);
          }
          else{

               response.sendRedirect("loginuser.html");
              
          }
          
    }
}
