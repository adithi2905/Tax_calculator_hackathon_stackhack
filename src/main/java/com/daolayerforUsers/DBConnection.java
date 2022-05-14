package com.daolayerforUsers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/taxcalculations";
		Connection con=DriverManager.getConnection(url,"root","9514067534");
		return con;
	}
}
