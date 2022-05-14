package com.agicalculations;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/getdetails")
public class getTotalIncomedetails extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
	String salary=req.getParameter("sal");
	String business=req.getParameter("business");
	String farm=req.getParameter("farm");
	String union=req.getParameter("union");
	String tax=req.getParameter("tax");
	String disability=req.getParameter("disability");
	String security=req.getParameter("Security");
	String awards=req.getParameter("awards");
	String labor=req.getParameter("labor");
	String spousal=req.getParameter("spousal");
	String unemp=req.getParameter("unemp");
	String gains=req.getParameter("gains");
	String pay=req.getParameter("pay");
	String rental=req.getParameter("rental");
	HttpSession sess=req.getSession(false);
	
	try
	{
	int totalincome=0;
	if(salary.length()>0)
		totalincome+=Integer.parseInt(salary);
	if(business.length()>0)
		totalincome+=Integer.parseInt(business);
	//System.out.print(totalincome);
	if(farm.length()>0)
		totalincome+=Integer.parseInt(farm);
	
	if(union.length()>0)
		totalincome+=Integer.parseInt(union);
	if(tax.length()>0)
		totalincome+=Integer.parseInt(tax);
	if(disability.length()>0)
		totalincome+=Integer.parseInt(disability);
	if(security.length()>0)
		totalincome+=Integer.parseInt(security);
	if(awards.length()>0)
		totalincome+=Integer.parseInt(awards);
	if(labor.length()>0)
		totalincome+=Integer.parseInt(labor);
	if(spousal.length()>0)
		totalincome+=Integer.parseInt(spousal);
	if(unemp.length()>0)
		totalincome+=Integer.parseInt(unemp);
	if(gains.length()>0)
		totalincome+=Integer.parseInt(gains);
	if(pay.length()>0)
		totalincome+=Integer.parseInt(pay);
	if(rental.length()>0)
		totalincome+=Integer.parseInt(rental);
	//System.out.print(totalincome);
	sess.setAttribute("ti", totalincome);
	System.out.print("\n"+totalincome);
	res.sendRedirect("getReductiondetails.jsp");}
	catch(NumberFormatException e)
	{
		sess.setAttribute("msg","Pls enter valid tax");
		res.sendRedirect("calc.jsp");
		
	}

}
}