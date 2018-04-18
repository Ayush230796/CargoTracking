package com.star.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.star.model.Consignee;


/**
 * Servlet implementation class ConsigneeHome
 */
@WebServlet("/ConsigneeHome")
public class ConsigneeHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsigneeHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		HttpSession sescn=request.getSession();
		
		
		out.println("<html>");
		out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
        out.println("<script src='asset/trackingConsigner.js'></script>");
		try{
		 Consignee C=(Consignee)sescn.getValue("SCONSIE");	
		 String nav="<h5><i>Consignee id:"+C.getId()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+C.getFirmname()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+sescn.getValue("LTIME")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=images/"+C.getFirmlogo()+" width=35 height=35>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=ConsigneeLogout>Logout</a></i></h5>";	
		 out.println (nav);		 
			
		}catch(Exception e)
		{
	     response.sendRedirect("ConsigneeLogin");		
		}

         out.print("<html>");
		out.println("<table>");
	
		out.println("<tr><td><b><i>Tracking Id:</i></b></td><td><input type=text name=tid id=tid></td><td><input type=button value='Search' id=btn></tr>");
		out.println("</table><br>");
		out.println("<span id=result></span>");
		out.print("</html>");

	}

	}

