<%-- This page is to show the tax insights from the data taken from user --%>

<%@ page language="java" import="com.daolayerforUsers.CrudOperationsforUsers,com.entitylayer.alltaxmethodupdate, java.util.List" session="false" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
div
{
background-color: #5c5470;
color: black;
font-family: lato;
font-size:140%;
resize: both;
line-height: 1.5;
display: inline-block;
border-color: rgb(0,0,102);
padding:2%;
position: absolute;
top:10%;
left:20%;
box-shadow:  8px 8px 15px #202020, 
             -8px -8px 15px #2c2c2c;
transition: box-shadow .35s ease !important;
    
}
body
{
background-color:#5c5470;
}
.home
{
width: 2%;
radius: 2%;
length: 15%;
}
</style>
<body>
<a href="frontpage.jsp"><img align="left" src="https://cdn.onlinewebfonts.com/svg/img_67037.png" class="home"></a>
	<a href="logout"><img align="right" src="https://duthiepower.com/wp-content/uploads/2021/05/Duthie-Power-top-generators-270x270.png" class="home">
	</a><br><br><br><br> 


<div>
<h3>Your tax details<hr></h3><br>

<%
HttpSession sess=request.getSession(false);
String filled=(String)sess.getAttribute("filled");
String phno=(String)sess.getAttribute("phno");
alltaxmethodupdate atxu=CrudOperationsforUsers.viewTaxdetails(phno,filled);
if(sess.getAttribute("phno")==null)
	response.sendRedirect("frontpage.jsp");
else{
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); 
	String msg=(String)sess.getAttribute("msg");
	if(msg!=null)
	{
		out.print("<center><h3><b>"+msg+"</b></h3></center>");
		sess.removeAttribute("msg");
	}
	else
	{
	if(filled.equalsIgnoreCase("both"))
	{
		long agi=atxu.getAgi();
		long standard=atxu.getStandardised();
		long itemized=atxu.getItemized();
		String unreim=atxu.getUnreim();
		String insurance=atxu.getInsu();
		String tax=atxu.getTax();
		String mortgage=atxu.getMort();
		String federal=atxu.getFederal();
		long applicable_insu=CrudOperationsforUsers.fetchMaxItemized(atxu.getAgi());
		out.print("<I>Your AGI is: <b>"+agi+"</b><br>Your Standardised tax: <b>"+standard+"</b><br>Your Itemized tax is: <b>"+itemized+"</b><br>Your Unreimbursed medical expenses : <b>"+unreim+"</b><br>Your long medical insurance is:  <b>"+insurance+"<br></b>Your state tax is: <b>"+tax+"<br></b>Your mortgage interest is: <b>"+mortgage+"</b><br>Your federal disaster tax is:  <b>"+federal+"</b></I>");
		if((insurance.length()<1)||(((insurance.length()>0)&&(Long.parseLong(insurance)<applicable_insu))))
			out.print("<br><br><b><br><I>You can reduce your tax by investing this amount on the medical insurance: " +applicable_insu+"</I></b>");
		if(standard>itemized)
		{
			itemized-=applicable_insu;
			if(itemized<standard)
				out.print("<br><br><b><I>Even though your standardized tax is more than your itemized,<br>it would be wise of you to go with itemized if you could invest some<br> more on your long term premium care insurance.</b></I>");
			else	
			out.print("<br><br><b>As your standardized tax is more than your itemized even after applying<br> the maximum applicable long term premium care insurance, it would be<br> wise of you to go with Standardised.</b><I>");
		}
	}
	}
}
%>
<br><br>

<I><p style="color:white">For Updating details,Please use this link<a href="Updatetax.jsp">here</a><br><br></p></I>
</div>
</body>
</html>