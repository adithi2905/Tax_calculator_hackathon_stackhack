package com.servicelayer;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.daolayerforUsers.CrudOperationsforUsers;
import com.daolayerforUsers.CrudOperfortaxdetails;
import com.entitylayer.alltaxmethodupdate;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/getItem")
public class getItemizeddetails extends HttpServlet 
{
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		
		double applicable_uni=0,applicable_ins=0,applicable_tax=0,applicable_federal=0;	
		long unr = 0,ins = 0,taxx = 0,mor=0,fed = 0;
	
		HttpSession sess=req.getSession(false);
		String phno=(String) sess.getAttribute("phno");
		String status=(String)sess.getAttribute("status");
		String type=(String)sess.getAttribute("type");
		long salary=(long)sess.getAttribute("salary");
		boolean update=(boolean)sess.getAttribute("update");
		String unreim="",insu="",tax="",mort="",federal="";
		try 
		{
			alltaxmethodupdate itu=CrudOperationsforUsers.fetch(phno);
			if(req.getParameter("unreim")==null)
			{
				if(update==true)
				{
					unreim=itu.getUnreim();
				}
			}
			else {
				unreim=req.getParameter("unreim");
			}
				
			if(req.getParameter("insu")==null)
			{
				if(update==true)
				{
					unreim=itu.getInsu();
				}
			}
			else {
				insu=req.getParameter("insu");}
				
			if(req.getParameter("tax")==null)
			{
				if(update==true)
				{
					tax=itu.getTax();
				}
			}
			else {
				tax=req.getParameter("tax");}
				
			if(req.getParameter("mort")==null)
			{
				if(update==true)
				{
					mort=itu.getMort();
				}
			}
			else {
				mort=req.getParameter("mort");}
				
			if(req.getParameter("federal")==null)
			{
				if(update==true)
				{
					unreim=itu.getFederal();
				}
			}
			else {
			federal=req.getParameter("federal");}
			
			if(unreim.length()>0)
				unr = Long.parseLong(unreim);
			if(insu.length()>0)
				ins=Long.parseLong(insu);
			if(tax.length()>0)
				taxx=Integer.parseInt(tax);
			if(mort.length()>0)
			 mor=Integer.parseInt(mort);
			if(federal.length()>0)
				fed=Integer.parseInt(federal);	
			if(update==false)
				CrudOperationsforUsers.insert(phno,unreim,insu,tax,mort,federal);
			else
				CrudOperationsforUsers.update(phno,unreim,insu,tax,mort,federal);
			applicable_uni=(salary*7.5)/100;
			applicable_ins=(salary*10)/100;
			applicable_tax=10000;
			applicable_federal=(salary*10)/100;
			//applicable mortgage calculation pending
			
			if(applicable_uni-unr>0)
				salary-=unr;
			else
				salary-=applicable_uni;
			if(applicable_ins-ins>0)
				salary-=ins;
			else
				salary-=applicable_ins;
			if(applicable_tax-taxx>0)
				salary-=taxx;
			else
				salary-=applicable_tax;
			if(applicable_federal-fed>0)
				salary-=fed;
			else 
				salary-=applicable_federal;
			salary-=mor;
			long totaltax=0,stdtax=0;
		    StatusImplementation si=new StatusImplementation();
			totaltax=si.computePercentageAndCap(salary,status,type);
			HttpSession ses=req.getSession(false);
			stdtax=(long)ses.getAttribute("tax");
			System.out.print(stdtax);
			sess.setAttribute("itemtax",totaltax);
			CrudOperfortaxdetails.update("itemized",totaltax,phno);
			res.sendRedirect("displaytax.jsp");
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
				e.printStackTrace();
			sess.setAttribute("msg","Some error occurred.Pls try again!");
			res.sendRedirect("getItemized.jsp");
		}
		catch(NumberFormatException e)
		{
			sess.setAttribute("msg","Pls enter valid tax!");
			res.sendRedirect("getItemized.jsp");
		}
	}

}
		