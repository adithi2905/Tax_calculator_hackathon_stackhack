package com.servicelayer;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.daolayerforUsers.CrudOperations;
import com.entitylayer.Signupdetails;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signup")
public class getSignupdetails extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		String user=req.getParameter("username");
		String pass=req.getParameter("pass");
		String email=req.getParameter("mail");
		Long contact=(long)0;
		HttpSession sess=req.getSession();
		try {
			Signupdetails sd=new Signupdetails();
		contact=Long.parseLong(req.getParameter("phno"));
		if(Long.toString(contact).length()!=10)
		{
			sess.setAttribute("msg","Please enter valid phone number.");
			res.sendRedirect("Signup.jsp");
				
		}
		sd.setName(user);
		sd.setPassword(pass);
		sd.setEmail(email);
		sd.setContactno(contact);
		CrudOperations c=new CrudOperations();
		c.insertData(sd);
		sess.setAttribute("msg","Successfully signed up.Please sign in.");
		res.sendRedirect("Signup.jsp");
		
		}
		catch(NumberFormatException e)
		{
			sess.setAttribute("msg","Pls provide some valid phone number.");
			res.sendRedirect("Signup.jsp");}
		 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			HttpSession ses=req.getSession();
			ses.setAttribute("msg","Some internal error occured.Try again later.");
			res.sendRedirect("Signup.jsp");
		}
		catch(SQLException e)
		{
			if(e instanceof SQLIntegrityConstraintViolationException)
			{
				//HttpSession sess=req.getSession();
				sess.setAttribute("msg","Already registered!Pls try logging in.");
   				res.sendRedirect("Signup.jsp");}
				
			else {
			//HttpSession sess=req.getSession();
			sess.setAttribute("msg","Some error occurred pls try again.");
			res.sendRedirect("Signup.jsp");}
		}
		catch(Exception e)
		{
			//HttpSession sess=req.getSession();
			sess.setAttribute("msg","Some error occured pls try again.");
			res.sendRedirect("Signup.jsp");
		}
}
}
