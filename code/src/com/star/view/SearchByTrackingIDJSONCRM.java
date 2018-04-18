package com.star.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.star.controller.CRMController;

import com.star.controller.DBHelper;

/**
 * Servlet implementation class SearchByTrackingIDJSONCRM
 */
@WebServlet("/SearchByTrackingIDJSONCRM")
public class SearchByTrackingIDJSONCRM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByTrackingIDJSONCRM() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	PrintWriter out=response.getWriter();
		
	try{
		//searchByTrackingId
		ResultSet rs=CRMController.searchByTrackingId(Integer.parseInt(request.getParameter("tid")));
		ArrayList<JSONObject>obj;
	     obj=DBHelper.JsonEngine(rs);
		 out.println(obj);
			
			
		}catch(Exception e){
			
			out.println("Error");
		}
		 out.flush();

	
	
	
	}

}
