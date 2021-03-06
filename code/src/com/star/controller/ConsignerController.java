package com.star.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.star.model.Consigner;

public class ConsignerController {
	
	
	//id, firmname, registration_no, ownername, contactperson, mobileno, phoneno, email, address, country, state, city, deals_in, website, firmlogo, password
	public static ResultSet getAllConsigner()
	 {
	   try{
		   Connection cn=DBHelper.openConnection();
		 ResultSet rs=DBHelper.executeQuery(cn,"Select * from consigner");   
		   return(rs);
	   }catch(Exception e){
		System.out.println(e);
		return(null);
	   }	 
		 
	 }
	public static Consigner checkPassword(String aid,String password)
	{try{
		//id, firmname, registration_no, ownername, contactperson, mobileno, phoneno, email, address, country, state, city, deals_in, website, firmlogo, password
		Connection cn=DBHelper.openConnection();
		String q="select * from Consigner where id='"+aid+"' and password='"+password+"'";
		ResultSet rs=DBHelper.executeQuery(cn, q);
		if(rs.next())
		{Consigner C=new Consigner();
		C.setId(Integer.parseInt(rs.getString(1)));
		C.setFirmname(rs.getString(2));
		C.setFirmlogo(rs.getString(15));
		return(C);
			
			
		}
		else
		{return(null);
			
		}
		 
	  }
	catch(Exception e)
	{System.out.println("ConsignerController:CheckPassword:"+e);
	return null;	
	}
	}	

       public static boolean addNewRecord(Consigner C){
    	   try{
    		   Connection cn=DBHelper.openConnection();
               String q="Insert into Consigner(firmname,registration_no,ownername,contactperson,mobileno,phoneno,email,address,country,state,city,deals_in,website,firmlogo,password) values ('"+C.getFirmname()+"','"+C.getRegistration_no()+"','"+C.getOwnername()+"','"+C.getContactperson()+"','"+C.getMobileno()+"','"+C.getPhoneno()+"','"+C.getEmail()+"','"+C.getAddress()+"','"+C.getCountry()+"','"+C.getState()+"','"+C.getCity()+"','"+C.getDeals_in()+"','"+C.getWebsite()+"','"+C.getFirmlogo()+"','"+C.getPassword()+"')";
               boolean st=DBHelper.executeUpdate(cn, q);
               return (st);
           }
    	   catch(Exception e){
    		   System.out.println("ConsignerController:addNewRecord:"+e);
    		   return false;	
    	   }
       }


       public static ResultSet displayAll()
       {try{
       	Connection cn=DBHelper.openConnection();
       	String q="select id,firmname,registration_no,ownername,contactperson,mobileno,phoneno,email,address,(select countryname from country C where C.countryid=CC.country),(select statename from state S where S.stateid=CC.state), (select cityname from city CI where CI.cityid=CC.city) ,deals_in,website,firmlogo from consigner CC";
       	ResultSet rs=DBHelper.executeQuery(cn, q);
       	return(rs);
         }
       catch(Exception e)
       {System.out.println("ConsignerController:displayAll:"+e);
       return null;	
       }
       }	

     public static Consigner displayById(int cid)
     {try{
     	Connection cn=DBHelper.openConnection();
     	String q="select id,firmname,registration_no,ownername,contactperson,mobileno,phoneno,email,address,country,(select countryname from country C where C.countryid=CC.country),state,(select statename from state S where S.stateid=CC.state),city, (select cityname from city CI where CI.cityid=CC.city) ,deals_in,website,firmlogo from consigner CC where CC.id="+cid;
     	ResultSet rs=DBHelper.executeQuery(cn, q);
     	if(rs.next())
     	{ Consigner C=new Consigner();
     	  C.setId(Integer.parseInt(rs.getString(1)));
     	  C.setFirmname(rs.getString(2));
     	  C.setRegistration_no(rs.getString(3));
     	  C.setOwnername(rs.getString(4));
     	  C.setContactperson(rs.getString(5));
     	  C.setMobileno(rs.getString(6));
     	  C.setPhoneno(rs.getString(7));
     	  C.setEmail(rs.getString(8));
     	  C.setAddress(rs.getString(9));
     	  C.setCountry(rs.getString(10)+","+rs.getString(11));
     	  C.setState(rs.getString(12)+","+rs.getString(13));
     	  C.setCity(rs.getString(14)+","+rs.getString(15));
     	  C.setDeals_in(rs.getString(16));
     	  C.setWebsite(rs.getString(17));
     	  C.setFirmlogo(rs.getString(18));
     		
     		return(C);
     	}
     	else
     	{
     	return(null);	
     	}
     	 
       }
     catch(Exception e)
     {System.out.println("ConsignerController:displayById:"+e);
     return null;	
     }
     }	
 
     public static boolean editRecord(Consigner C)
     {try{
     	Connection cn=DBHelper.openConnection();
     	String q="update  consigner set firmname='"+C.getFirmname()+"',registration_no='"+C.getRegistration_no()+"',ownername='"+C.getOwnername()+"',contactperson='"+C.getContactperson()+"',mobileno='"+C.getMobileno()+"',phoneno='"+C.getPhoneno()+"',email='"+C.getEmail()+"',address='"+C.getAddress()+"',country='"+C.getCountry()+"',state='"+C.getState()+"',city='"+C.getCity()+"',deals_in='"+C.getDeals_in()+"',website='"+C.getWebsite()+"' where id="+C.getId();
     	boolean st=DBHelper.executeUpdate(cn, q);
     	return(st);

     }
     catch(Exception e)
     {System.out.println("ConsignerController:editRecord:"+e);
     return false;	
     }
     }
     
     public static boolean updatePicture(Consigner C)
     {try{
     	Connection cn=DBHelper.openConnection();
     	String q="update  consigner set firmlogo='"+C.getFirmlogo()+"' where id="+C.getId();
     	boolean st=DBHelper.executeUpdate(cn, q);
     	return(st);

     }
     catch(Exception e)
     {System.out.println("ConsignerController:editRecord:"+e);
     return false;	
     }
     }
     

     public static boolean deleteRecord(int id)
     {try{
     	Connection cn=DBHelper.openConnection();
     	String q="Delete from consigner where id="+id;
     			 
     	boolean st=DBHelper.executeUpdate(cn, q);
     	return(st);

     }
     catch(Exception e)
     {System.out.println("ConsignerController:deleteRecord:"+e);
     return false;	
     }
     } 
 
}
