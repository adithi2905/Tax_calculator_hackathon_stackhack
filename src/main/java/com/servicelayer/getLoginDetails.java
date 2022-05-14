package com.servicelayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.daolayerforUsers.CrudOperfortaxdetails;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/log")
public class getLoginDetails extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		//System.out.print("\n"+phno);
		HttpSession sess=req.getSession();
		
    	try {
    		long phno=Long.parseLong(req.getParameter("phno"));
    		String password=req.getParameter("pass");
    		
			if(checkLogindetails.check(Long.toString(phno),password))
			{
				sess.setAttribute("phno",Long.toString(phno));
	    		sess.setAttribute("password",password);
				String result=CrudOperfortaxdetails.checkIfTaxCalculated(Long.toString(phno));
				if(result.length()>0)
				{
					sess.setAttribute("filled",result);
					sess.setAttribute("update", true);
					res.sendRedirect("Viewdetails.jsp");
				}
				else
				{
					sess.setAttribute("update",false);
				   res.sendRedirect("taxDetails.jsp");}
			}
			else
			{
				sess.setAttribute("msg","Login failed.Pls check your credentials");
				res.sendRedirect("Login.jsp");
				}
		} 
    	catch(NumberFormatException e)
    	{
    		sess.setAttribute("msg","Pls enter valid registered phone number!");
			res.sendRedirect("Login.jsp");
    	}
    	catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			sess.setAttribute("msg","Some error occured.Pls try again!");
			res.sendRedirect("Login.jsp");
		}	
	}

	
}
