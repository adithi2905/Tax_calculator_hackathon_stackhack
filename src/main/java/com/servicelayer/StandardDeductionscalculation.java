package com.servicelayer;

import java.io.IOException;
import java.sql.SQLException;

import com.daolayerforUsers.CrudOperfortaxdetails;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/standard")
public class StandardDeductionscalculation extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		HttpSession sess=req.getSession(false);
		String year=(String) sess.getAttribute("year");
		String type=(String)sess.getAttribute("type");
		String status=(String)sess.getAttribute("status");
		long salary=(long)sess.getAttribute("salary");
		int stdamount=0;
		if(type.equals("Head")) {
		if(year.equals("2021"))
			stdamount=18800;
		else
			stdamount=19400;}
		else if(type.equals("Joint"))
		{
			if(year.equals("2021"))
				stdamount=25100;
			else
				stdamount=25900;
		}
		else if(type.equals("Separate"))
		{
			if(year.equals("2021"))
				stdamount=12550;
			else
				stdamount=12950;
			
		}
		else if(type.equals("Single"))
		{
			if(year.equals("2021"))
				stdamount=12500;
			else
				stdamount=12950;
		}
		salary-=stdamount;
		StatusImplementation si=new StatusImplementation();
		long tax=si.computePercentageAndCap(salary,status,type);
		try {
			String phno=(String)sess.getAttribute("phno");
			CrudOperfortaxdetails.update("standardised",tax,phno);
			sess.setAttribute("tax",tax);
			res.sendRedirect("getItemized.jsp");
				
		} catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			sess.setAttribute("msg","Some error occurred pls try again");
			if((Boolean)sess.getAttribute("update")==false)
			res.sendRedirect("taxDetails.jsp");
			else
				res.sendRedirect("Updatetax.jsp");
		}

		
	}

}