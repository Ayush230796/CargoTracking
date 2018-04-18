package com.star.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.star.model.Crm;
import com.star.model.Tracking;

public class CRMController {
	public static ResultSet searchByTrackingId(int tid){
	  	   try{
	  		   Connection cn=DBHelper.openConnection();
	  		                                                                                                                                        
	  		    String q="Select * from Crm where trackingid="+tid;
	            
	  		    ResultSet rs=DBHelper.executeQuery(cn, q);
	            return (rs);
	         }
	  	   catch(Exception e){
	  		   System.out.println("CrmController:searchTrackingById:"+e);
	  		   return null;	
	  	   }
	     }
	
	public static boolean addNewRecord(Crm C){
	  	   try{
	  		   Connection cn=DBHelper.openConnection();
	//Trackingid, EmployeeID,                                                                                 Curdate, Currtime, Conversation, Action, TransactionID  		                                                                                                                                        
	             String q="Insert into crm (trackingid,employeeid,Curdate,Currtime,Conversation,Action) values ("+C.getTrackingid()+","+C.getEmployeeid()+",'"+C.getCurrdate()+"','"+C.getCurrtime()+"','"+C.getConversation()+"','"+C.getAction()+"')";
	       		  
	             boolean st=DBHelper.executeUpdate(cn, q);
	             return (st);
	         }
	  	   catch(Exception e){
	  		   System.out.println("CrmController:addNewRecord:"+e);
	  		   return false;	
	  	   }
	     }
			
	 
}
