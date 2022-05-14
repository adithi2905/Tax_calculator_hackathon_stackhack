package com.servicelayer;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.daolayerforUsers.CrudOperfortaxdetails;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/tax")
public class getTaxdetails extends HttpServlet{
		public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
		{
			
			String status=req.getParameter("status");
			String type=req.getParameter("type");
			String year=req.getParameter("year");
			HttpSession sess=req.getSession(false);
			sess.setAttribute("status", status);
			sess.setAttribute("type",type);
			sess.setAttribute("year",year);
			sess.setAttribute("update",false);
			String phno=(String)sess.getAttribute("phno");
				
			try {
				long salary=Long.parseLong(req.getParameter("sal"));
				sess.setAttribute("salary", salary);
				
				CrudOperfortaxdetails.insert(phno, salary,status);
				
				res.sendRedirect("standard");
				
			} catch (ClassNotFoundException | SQLException e) {
				if(e instanceof SQLIntegrityConstraintViolationException)
				{
					
					//res.sendRedirect("standard");
					
				}
				// TODO Auto-generated catch block
				else {
					e.printStackTrace();
					sess.setAttribute("msg","Some error occurred.Pls try again.");
				res.sendRedirect("taxDetails.jsp");}
			}
			catch(NumberFormatException e)
			{
				sess.setAttribute("msg","Pls enter valid salary");
				res.sendRedirect("taxDetails.jsp");
			}		
	}
	}


