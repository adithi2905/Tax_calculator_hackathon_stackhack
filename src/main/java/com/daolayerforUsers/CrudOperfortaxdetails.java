package com.daolayerforUsers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entitylayer.Taxdetailsupdate;

public class CrudOperfortaxdetails {
	static Connection con=null;
	public static void insert(String phno,long salary,String status) throws ClassNotFoundException, SQLException
	{
		if(con==null)
		   con=DBConnection.getConnection();
		String url="Insert into taxcalculations.taxdetails(contactno,status,adjustedgrossincome,standardisedtax,itemizedtax) values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(url);
		ps.setString(1,phno);
		ps.setString(2,status);
		ps.setLong(3,salary);
		ps.setLong(4,0);
		ps.setLong(5,0);
		ps.executeUpdate();
	}
	public static Taxdetailsupdate fetch(String phno) throws ClassNotFoundException, SQLException
	{
		if(con==null)
			con=DBConnection.getConnection();
		String url="Select * from taxcalculations.taxdetails where contactno=?";
		PreparedStatement ps=con.prepareStatement(url);
		ps.setString(1,phno);
		ResultSet rs=ps.executeQuery();	
		List<String>res=new ArrayList<>();
		Taxdetailsupdate txu=new Taxdetailsupdate();
		while(rs.next())
		{
			txu.setStatus(rs.getString(2));
			txu.setAgi(rs.getLong(3));
			
		}
		return txu;
	}
	public static void update(String phno,String status,long salary) throws ClassNotFoundException, SQLException
	{
		String url="Update taxcalculations.taxdetails Set status=?,adjustedgrossincome=? where contactno=?";
		doUpdatedetails(url,status,salary,phno);
		
	}
	public static void update(String type,long tax,String phno) throws ClassNotFoundException, SQLException
	{
		String url="";	
		if(type.equalsIgnoreCase("Standardised"))
		{
			url="Update taxcalculations.taxdetails Set standardisedtax=? where contactno=?";
			doUpdatetax(url,phno,tax);
		}
		else if(type.equalsIgnoreCase("Itemized"))
		{
			url="Update taxcalculations.taxdetails set itemizedtax=? where contactno=?";
			doUpdatetax(url,phno,tax);
		}
		else
		{
		     String url1="Update taxcalculations.taxdetails Set standardisedtax=? where contactno=?";
		     String url2="Update taxcalculations.taxdetails set itemizedtax=? where contactno=?";
		     doUpdatetax(url1,phno,tax);
		     doUpdatetax(url2,phno,tax);	
		}		
	}
	public static void doUpdatedetails(String url,String status,long salary,String phno)throws ClassNotFoundException, SQLException
	{
		if(con==null)
		 con=DBConnection.getConnection();	
		PreparedStatement ps=con.prepareStatement(url); 
		ps.setString(1,status);
		ps.setLong(2,salary);
		ps.setString(3,phno);
		System.out.print(ps.executeUpdate());
	}
	public static Taxdetailsupdate fetchTax(String phno) throws ClassNotFoundException, SQLException
	{
		String url="";
		if(con==null)
			con=DBConnection.getConnection();
		url="Select standardisedtax,itemizedtax from taxcalculations.taxdetails where contactno=?";
		PreparedStatement ps=con.prepareStatement(url);
		ps.setString(1,phno);
		List<Long>res=null;
		ResultSet rs=ps.executeQuery();
		Taxdetailsupdate txu=new Taxdetailsupdate();
		while(rs.next())
		{
			txu.setStandardised(rs.getLong(1));
			txu.setItemized(rs.getLong(2));
		}
		return txu;
	}
	public static void doUpdatetax(String url,String phno,long tax)throws ClassNotFoundException, SQLException
	{
		if(con==null)
		 con=DBConnection.getConnection();	
		PreparedStatement ps=con.prepareStatement(url); 
		ps.setLong(1,tax);
		ps.setString(2,phno);
		ps.executeUpdate();
	}
	
	public static String checkIfTaxCalculated(String phno) throws ClassNotFoundException, SQLException
	{
		Connection con=DBConnection.getConnection();
		String url="Select * from taxcalculations.taxdetails where ((contactno=?)and (standardisedtax>0 || itemizedtax >0));";
		PreparedStatement ps=con.prepareStatement(url);
		ps.setString(1,phno);
		ResultSet rs=ps.executeQuery();
		String res="";
		if(rs.next())
		{
			if((rs.getLong("standardisedtax")>0)&&(rs.getLong("itemizedtax")>0))
			{
			res="Both";
				
			}
			else if((rs.getLong("standardisedtax")<0)&&(rs.getLong("itemizedtax")>0))
				res="itemized";
			else
				res="standardised";
		}
		return res;
	}
}
