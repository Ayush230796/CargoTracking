package com.star.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.http.Cookie;

import com.star.controller.AdminController;
import com.star.model.Admin;

/**
 * Servlet implementation class CheckAdminLogin
 */
@WebServlet("/CheckAdminLogin")
public class CheckAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     public CheckAdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String aidf="";String passf="";
       Cookie cc[]=request.getCookies();
if(cc==null){		
	String aid=request.getParameter("aid");
	String password=request.getParameter("password");
	Admin A=AdminController.checkPassword(aid,password);
		if(A!=null)
		{  HttpSession ses=request.getSession();
		   ses.putValue("SADMIN", A);
		   ses.putValue("LTIME", new java.util.Date());
		   Cookie uid=new Cookie("Adminid",A.getAdminid());
		    uid.setMaxAge(1000000000);
		    response.addCookie(uid);
		    Cookie pass=new Cookie("password",A.getPassword());
		    pass.setMaxAge(10000000);
		    response.addCookie(pass);
		    response.sendRedirect("AdminHome");

		}
		else
		{
         out.println("Invalid AdminID/Password");
	 
		}
}

  else
		{
			Cookie T=null;
		
		for(int i=0;i<cc.length;i++){
	
				if(cc[i].getName().equals("Adminid")){
					T=cc[i];
					aidf=T.getValue();
			      		
				}
				if(cc[i].getName().equals("password")){
					T=cc[i];
					passf=T.getValue();
					
				}
		}
		if((aidf!="")&&(passf!=""))
		{
		
			Admin Aa=AdminController.checkPassword(aidf, passf);
			if(Aa!=null){
				
				HttpSession ses=request.getSession();
			   ses.putValue("SADMIN", Aa);
			   ses.putValue("LTIME", new java.util.Date());
				
				  response.sendRedirect("AdminHome");
			}
		}
			else
			{
				 
				response.sendRedirect("AdminLogin");
			}
			
	}
 }
}


