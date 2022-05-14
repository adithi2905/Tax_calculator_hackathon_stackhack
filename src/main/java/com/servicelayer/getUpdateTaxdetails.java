package com.servicelayer;


import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.daolayerforUsers.CrudOperfortaxdetails;
import com.entitylayer.Taxdetailsupdate;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updatetax")
public class getUpdateTaxdetails extends HttpServlet {
		
		public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
		{
			String status="",type="",year="";
			HttpSession sess=req.getSession(false);
			String phno=(String)sess.getAttribute("phno");
		try {
			Taxdetailsupdate txu=CrudOperfortaxdetails.fetch(phno);
			
			if(req.getParameter("status")!=null)
				status=req.getParameter("status");
			else
				status=txu.getStatus();
			if(req.getParameter("type")!=null)
			   type=req.getParameter("type");
			else
				type=txu.getType();
			if(req.getParameter("year")!=null)
			   year=req.getParameter("year");
			else
				year=txu.getYear();
			
			sess.setAttribute("status", status);
			sess.setAttribute("type",type);
			sess.setAttribute("year",year);
			long salary=0;
			if(req.getParameter("sal")!=null) {
			salary=Long.parseLong(req.getParameter("sal"));}
			else
				salary=txu.getAgi();
			
			sess.setAttribute("salary", salary);
			CrudOperfortaxdetails.update(phno,status,salary);
			res.sendRedirect("standard");
			
		   } 
			catch (ClassNotFoundException | SQLException e) 
			{
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				sess.setAttribute("msg","Some error occurred.Pls try again.");
				res.sendRedirect("Updatetax.jsp");
				
			}
			catch(NumberFormatException e)
			{
				sess.setAttribute("msg","Pls enter valid salary");
				res.sendRedirect("Updatetax.jsp");
			}		
		}
	}





