<%-- This page is to display the calculated AGI after getting the AGI related details--%>

<%@ page language="java" session="false" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
div
{
background-color: #5c5470;
color: white;
font-family: lato;
font-size:140%;
resize: both;
line-height: 1.5;
display: inline-block;
border-color: rgb(0,0,102);
padding:2%;
position: absolute;
top:30%;
left:30%;
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
<%
HttpSession sess=request.getSession(false);
boolean update=(boolean)sess.getAttribute("update");
if(sess.getAttribute("phno")==null)
	response.sendRedirect("Login.jsp");
else{
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); 
    int ti=(int)sess.getAttribute("ti");
    out.print("<I>According to the income details and tax credits you have entered,<br>your Adjusted Gross Income for the year is calculated as<br><center><b>"+ti+"</b><I></center><br><br><hr>");
    if(update==false)
    	out.print("<br><br><a href=\"taxDetails.jsp\">Click here to go back</a>");
    else
    	out.print("<br><br><a href=\"Updatetax.jsp\">Click here to go back</a>");
}
%>

</div>
</body>
</html>