package com.star.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLogout
 */
@WebServlet("/AdminLogout")
public class AdminLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try{
			 HttpSession ses=request.getSession();
			 
	        	
	        	
		ses.invalidate(); 
	 		    
	        	Cookie cc[]=request.getCookies();
	        	   for(int i=0;i<cc.length;i++){
					if(cc[i].getName().equals("Adminid")){
		    
					   	cc[i].setMaxAge(0);
						 response.addCookie(cc[i]); 
					   	
					}
					if(cc[i].getName().equals("password")){
						
						cc[i].setMaxAge(0);	
						response.addCookie(cc[i]);
					}
					if(cc[i].getName().equals("JSESSIONID")){
					//	System.out.println("JSESSIONID SECTion");
                     cc[i].setPath("/CargoTracking/");
                     cc[i].setValue(null);
					cc[i].setMaxAge(0);
					response.addCookie(cc[i]);
	        	  
				   }
	        	 }  	
	         	  
	         	 
	        	   response.sendRedirect("AdminLogin");
		 }
	        
	
         catch(Exception e)
         {
        	 response.sendRedirect("AdminLogin"); 
        	 
         }

	
	}

}
