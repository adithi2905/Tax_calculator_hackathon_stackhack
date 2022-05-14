package com.agicalculations;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/getRed")
public class getReductiondetails extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		HttpSession sess=req.getSession(false);
		int ti=(int)sess.getAttribute("ti");
		String self=req.getParameter("self");
		String classroom=req.getParameter("classroom");
		String artists=req.getParameter("artists");
		String charity=req.getParameter("charity");
		String army=req.getParameter("army");
		String other=req.getParameter("other");
		if(self.length()>0)
		{
			ti-=Integer.parseInt(self);
			
		}
		if(classroom.length()>0)
		{
			ti-=Integer.parseInt(classroom);
			
		}
		if(artists.length()>0)
		{
			ti-=Integer.parseInt(artists);
			
		}
		if(charity.length()>0)
		{
			ti-=Integer.parseInt(charity);
			
		}
		if(army.length()>0)
		{
			ti-=Integer.parseInt(army);
			
		}
		if(other.length()>0)
		{
			ti-=Integer.parseInt(other);
			
		}
		sess.removeAttribute("ti");
		sess.setAttribute("ti",ti);	
		res.sendRedirect("displayAgi.jsp");
	
		
	}
}