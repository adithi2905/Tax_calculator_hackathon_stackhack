package com.servicelayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.daolayerforUsers.CrudOperations;
import com.daolayerforUsers.DBConnection;

public class checkLogindetails {
	public static boolean check(String phno,String password) throws ClassNotFoundException, SQLException
	{
		CrudOperations c=new CrudOperations();
		 List<String> res=c.fetchRows(phno,password);
		 if(res.isEmpty()==false)
			 return true;
		 return false;	
	}

}
