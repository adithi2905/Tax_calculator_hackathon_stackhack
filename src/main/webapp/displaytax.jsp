<%-- This page is to display the calculated tax for the user selected type in the taxDetails.jsp/Updatetax.jsp--%>

<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
top:40%;
left:40%;
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
if(sess.getAttribute("phno")==null)
	response.sendRedirect("Login.jsp");
else{
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); 
long itemtax=-1,tax=-1;
String type=(String)sess.getAttribute("type");
itemtax=(long)sess.getAttribute("itemtax");
tax=(long)sess.getAttribute("tax");
if(type.equalsIgnoreCase("both")){
	 if((itemtax<0)&&(tax>0))
out.print("Standardised tax= "+tax+"\nNo Itemized tax");
 else if((itemtax>0)&&(tax>0))
	 out.print("Standardised tax= "+tax+"\nItemized tax= "+itemtax);
 else if((itemtax>0)&&(tax<=0))
	 out.print("Itemized tax= "+itemtax+"\nNo Standard tax");}
else if(type.equalsIgnoreCase("standardised"))
{
 out.print("The tax for the given type "+sess.getAttribute("type")+" is "+tax);	
		 
}
else
{
	out.print("The tax for the given type "+sess.getAttribute("type")+" is "+itemtax);	
}

out.print("<I><h4>Want some insights?Pls click<a href=\"Viewdetails.jsp\">here.</a></h4></I>");
}
%>
</div>
</body>
</html>