package com.star.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.star.model.Dispatch;

public class DispatchController {
	 public static boolean addNewRecord(Dispatch D){
  	   try{
  		   
  		   Connection cn=DBHelper.openConnection();
  		// employeeid, transactionid, dispatchdate, dispatchtime, consignerid, consigneeid, productdesc, producttype, totalbox, quaintity_in_box, amount, chargedispatch, dispatchfrom, dispatchto, dispacthBy, veichelNo, approxday, latitude, longitude                                                                             
    String q="Insert into Dispatch (employeeid, dispatchdate, dispatchtime, consignerid, consigneeid, productdesc, producttype, totalbox, quaintity_in_box, amount, chargedispatch, dispatchfrom, dispatchto, dispacthBy, veichelNo, approxday,latitude, longitude ) values ("+D.getEmployeeid()+",'"+D.getDispatch_Date()+"','"+D.getDispatch_Time()+"',"+D.getConsigner_Id()+","+D.getConsignee_Id()+",'"+D.getProduct_Desc()+"','"+D.getProduct_Type()+"','"+D.getTotal_Box()+"','"+D.getQuantity_In_Box()+"','"+D.getAmount()+"','"+D.getCharge_Of_Dispatch()+"','"+D.getDispatch_From()+"','"+D.getDispatch_To()+"','"+D.getDispatch_By()+"','"+D.getVeichel_No()+"','"+D.getApproxdays()+"','"+D.getLatitude()+"','"+D.getLongitude()+"')";
             boolean st=DBHelper.executeUpdate(cn, q);
             return (st);
         }
  	   catch(Exception e){
  		   System.out.println("DispatchController:addNewRecord:"+e);
  		   return false;	
  	   }
     
	 }
	 
	 public static int getTrackingid(){
	  	   try{
	  		   
	  		   Connection cn=DBHelper.openConnection();
	  		                                                                                
	    String q="select max(transactionid) from dispatch";
         ResultSet rs=DBHelper.executeQuery(cn, q);
	           if(rs.next())
	           {int tid=Integer.parseInt(rs.getString(1));
	            return(tid);
	           }
	           else
	           {
	        	   return(-1);
	           }
	         }
	  	   catch(Exception e){
	  		   System.out.println("DispatchController:addNewRecord:"+e);
	  		   return -1;	
	  	   }
	     }
	 

}
