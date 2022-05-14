package com.daolayerforUsers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entitylayer.alltaxmethodupdate;
import com.entitylayer.Taxdetailsupdate;

public class CrudOperationsforUsers {
	public static void insert(String phno,String unreim,String insurance,String statetax,String mortgagetax,String federaldisaster) throws ClassNotFoundException, SQLException
	{
		Connection con=DBConnection.getConnection();
		String url="Insert into taxcalculations.itemizedtaxdetails(contactno,unreimmedexpense,insurance,statetax,mortgagetax,federaldisastertax) values(?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(url);
		ps.setString(1,phno);
		ps.setString(2,unreim);
		ps.setString(3,insurance);
		ps.setString(4,statetax);
		ps.setString(5,mortgagetax);
		ps.setString(6,federaldisaster);
		ps.executeUpdate();	
		
	}
	public static ResultSet getResult(String url,String phno)throws ClassNotFoundException, SQLException
	{
		Connection con=DBConnection.getConnection();	
		PreparedStatement ps=con.prepareStatement(url); 
		ps.setString(1,phno);
		ResultSet rs=ps.executeQuery();
		List<String>res=new ArrayList<>();
		return rs;
		
	}
	public static alltaxmethodupdate viewTaxdetails(String phno,String filled) throws ClassNotFoundException, SQLException 
	{
		String url1="Select td.adjustedgrossincome,td.standardisedtax from taxcalculations.tax as t join taxcalculations.taxdetails as td where t.contactno=? and t.contactno=td.contactno";
		String url2="Select td.itemizedtax,itd.unreimmedexpense,itd.insurance,itd.statetax,itd.mortgagetax,itd.federaldisastertax from taxcalculations.tax as t join taxcalculations.taxdetails as td join taxcalculations.itemizedtaxdetails as itd where t.contactno=? and t.contactno=td.contactno and t.contactno=itd.contactno";
		String url3="Select td.adjustedgrossincome,td.standardisedtax,td.itemizedtax,itd.unreimmedexpense,itd.insurance,itd.statetax,itd.mortgagetax,itd.federaldisastertax from taxcalculations.tax as t join taxcalculations.taxdetails as td join taxcalculations.itemizedtaxdetails as itd where t.contactno=? and t.contactno=td.contactno and t.contactno=itd.contactno";
		List<String>res=new ArrayList<>();
		ResultSet rs=getResult(url3,phno);
		alltaxmethodupdate itx=new alltaxmethodupdate();
			
		while(rs.next())
		{
			itx.setAgi(rs.getLong(1));
			itx.setStandardised(rs.getLong(2));
			itx.setItemized(rs.getLong(3));
			itx.setUnreim(rs.getString(4));
			itx.setInsu(rs.getString(5));
			itx.setTax(rs.getString(6));
			itx.setMort(rs.getString(7));
			itx.setFederal(rs.getString(8));
		}		
		return itx ;	
		}
	public static alltaxmethodupdate fetch(String phno) throws ClassNotFoundException, SQLException
	{
		Connection con=DBConnection.getConnection();
		String url="Select * from taxcalculations.itemizedtaxdetails where contactno=?";
		PreparedStatement ps=con.prepareStatement(url);
		ps.setString(1,phno);
		ResultSet rs=ps.executeQuery();	
		List<String>res=new ArrayList<>();
		alltaxmethodupdate itu=new alltaxmethodupdate();
		while(rs.next())
		{
			itu.setUnreim(rs.getString(2));
			itu.setInsu(rs.getString(3));
			itu.setTax(rs.getString(4));
			itu.setMort(rs.getString(5));
			itu.setFederal(rs.getString(6));
		}
		return itu;
	}
	public static void update(String phno, String unreim, String insu, String tax, String mort, String federal) throws ClassNotFoundException, SQLException
	{
		// TODO Auto-generated method stub
		Connection con=DBConnection.getConnection();
		String url="Update taxcalculations.itemizedtaxdetails Set unreimmedexpense=?,insurance=?,statetax=?,mortgagetax=?,federaldisastertax=? where contactno=?";
		PreparedStatement ps=con.prepareStatement(url);
		ps.setString(1,unreim);
		ps.setString(2,insu);
		ps.setString(3,tax);
		ps.setString(4,mort);
		ps.setString(5,federal);
		ps.setString(6,phno);
		ps.executeUpdate();
		
	}
	public static long  fetchMaxItemized(long salary)
	{
		long applicable_ins=(salary*10)/100;
		return applicable_ins;
	}
}
