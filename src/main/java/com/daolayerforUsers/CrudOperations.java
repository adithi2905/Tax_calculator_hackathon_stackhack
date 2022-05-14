package com.daolayerforUsers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entitylayer.Signupdetails;

public class CrudOperations {
	Connection con=null;
	public void insertData(Signupdetails sd) throws ClassNotFoundException, SQLException
	{
		if(con==null) 
			con=DBConnection.getConnection();
		String url="Insert into taxcalculations.tax(username,password,email,contactno) values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(url);
		ps.setString(1,sd.getName());
		ps.setString(2,sd.getPassword());
		ps.setString(3,sd.getEmail());
		ps.setLong(4,sd.getContactno());
		ps.executeUpdate();
	}
	public List<String> fetchRows(String phno,String password) throws SQLException, ClassNotFoundException
	{
		if(con==null) 
			con=DBConnection.getConnection();
		String url="Select * from taxcalculations.tax where contactno=? and password=?";
		PreparedStatement ps=con.prepareStatement(url);
		ps.setString(1,phno);
		ps.setString(2,password);
		ResultSet x=ps.executeQuery();
		List<String>res=new ArrayList<>();
		while(x.next())
		{
			res.add(x.getString(1));
			res.add(x.getString(2));
		}
		return res;
	
	}
	
	}
