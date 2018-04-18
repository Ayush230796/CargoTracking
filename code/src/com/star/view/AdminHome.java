package com.star.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.star.model.Admin;

/**
 * Servlet implementation class AdminHome
 */
@WebServlet("/AdminHome")
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession ses=request.getSession();
		 Cookie cc[]=request.getCookies();
		out.println("<html>");
		try{
		 Admin A=(Admin)ses.getValue("SADMIN");	
		 String nav="<h5><i>Admin id:"+A.getAdminid()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+A.getAdminname()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=images/"+A.getPicture()+" width=35 height=35></i></h5>";	
		 out.println (nav);
		  } 
	     catch(Exception e)
		{
	    	
      	   for(int i=0;i<cc.length;i++){
				if(cc[i].getName().equals("JSESSIONID")){
					System.out.println("JSESSIONID SECTion");
               cc[i].setPath("/CargoTracking/");
               cc[i].setValue(null);
				cc[i].setMaxAge(0);
				response.addCookie(cc[i]);
      	  
			   }
      	 }  	
      	 
	     response.sendRedirect("AdminLogin");		
		}
		out.println("<table>");
		out.println("<tr>");
		out.println("<td valign=top>");
		out.println("<a href=ConsignerView target=mw>Consigner Register</a><br>");
		out.println("<a href=ConsignerDisplayAll target=mw>Update Consigner</a><br>");
		out.println("<a href=ConsigneeView target=mw>Consignee Register</a><br>");
		out.println("<a href=ConsigneeDisplayAll target=mw>Update Consignee</a><br>");
		out.println("<a href=EmployeeView target=mw>Employee Register</a><br>");
		out.println("<a href=EmployeeDisplayAll target=mw>UpdateEmployee</a><br>");
		out.println("<a href=AdminLogout>Logout</a><br>");
		out.println("</td>");
		out.println("<td valign=top>");
		out.println("<iframe name=mw width=700 height=800 frameborder=0></iframe>");
		out.println("</td>");
		out.println("</tr></table></html>");

	}

}