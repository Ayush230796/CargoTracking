package com.star.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.star.controller.CRMController;
import com.star.controller.TrackingController;
import com.star.model.Crm;
import com.star.model.Tracking;

/**
 * Servlet implementation class InsertCRMJSON
 */
@WebServlet("/InsertCRMJSON")
public class InsertCRMJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCRMJSON() {
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
		Crm  C=new Crm();
		C.setTrackingid(Integer.parseInt(request.getParameter("tid")));
		C.setEmployeeid(Integer.parseInt(request.getParameter("eid")));
		
		C.setCurrdate(request.getParameter("tcd"));
		C.setCurrtime(request.getParameter("tct"));
		C.setConversation(request.getParameter("td"));
		C.setAction(request.getParameter("action"));
	   boolean st=CRMController.addNewRecord(C);
	   JSONObject obj=new JSONObject();
	   if(st)
	   {obj.put("message", "<font Color=green><i>Record Submitted</i></font>");
		   
	   }
	   else
	   {obj.put("message", "<font Color=red><i>Fail to Submit Record</i></font>");
		   
	   }
	   out.println(obj);
		}catch(Exception e)
		{out.println(e);
			
		}

	}

}
