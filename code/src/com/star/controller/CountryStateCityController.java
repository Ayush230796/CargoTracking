package com.star.controller;

import java.sql.Connection;
import java.sql.ResultSet;

public class CountryStateCityController {
	public static ResultSet getAllCountry()
	 {
	   try{
		   Connection cn=DBHelper.openConnection();
		 ResultSet rs=DBHelper.executeQuery(cn,"Select * from country");   
		   return(rs);
	   }catch(Exception e){
		System.out.println(e);
		return(null);
	   }	 
		 
	 }
	 public static ResultSet getAllState(int countryId)
	 {
	   try{
		   Connection cn=DBHelper.openConnection();
		ResultSet rs=DBHelper.executeQuery(cn,"Select * from state where countryid="+countryId);   
		   return(rs);
	   }catch(Exception e){
		System.out.println(e);
		return(null);
	   }	 
		 
	 }	

	 public static ResultSet getAllCity(int stateId)
	 {
	   try{
		   Connection cn=DBHelper.openConnection();
		ResultSet rs=DBHelper.executeQuery(cn,"Select * from city where stateid="+stateId);   
		   return(rs);
		 
	   }catch(Exception e){
		System.out.println(e);
		return(null);
	   }	 
		 
	 }	

}
