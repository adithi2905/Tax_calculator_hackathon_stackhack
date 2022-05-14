<%-- This page is to get the itemized tax details from the user --%>
<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
.details
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
top:15%;
left:10%;
box-shadow:  8px 8px 15px #202020, 
             -8px -8px 15px #2c2c2c;
transition: box-shadow .35s ease !important;
    
}
.info
{
background-color: black;
color: white;
font-family: lato;
font-size:100%;
resize: both;
line-height: 1.5;
display: inline-block;
border-color: rgb(0,0,102);
padding:2%;
position: absolute;
top:35%;
left:50%;
box-shadow:  8px 8px 15px #202020, 
             -8px -8px 15px #2c2c2c;
transition: box-shadow .35s ease !important;

}
body
{
background-color:#5c5470;
}
input
{
  border-color: rgb(0,0,102);
  color: black;
  box-shadow:  8px 8px 15px #202020, 
             -8px -8px 15px #2c2c2c;
transition: box-shadow .35s ease !important;
top: 25%;


}
input[type=submit] {
            background-color: black;
            border: none;
            font-size: 80%;
            text-decoration: none;
            color: white;
            padding: 15px 15px;
            margin: 20px 20px;
            cursor: pointer;
            top: 20%; 
            float:left;
            

            
}
.home
{
width: 2%;
radius: 2%;
length: 15%;
}
</style>
<% 
HttpSession sess=request.getSession(false);
if(sess.getAttribute("phno")==null)
	response.sendRedirect("Login.jsp");
else{
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); 
	String msg=(String)sess.getAttribute("msg");
	if(msg!=null)
	{
		out.print("<center><h3><b>"+msg+"</b></h3></center>");
	}
	sess.removeAttribute(msg);
}
%>

<a href="frontpage.jsp"><img align="left" src="https://cdn.onlinewebfonts.com/svg/img_67037.png" class="home"></a>
<a href="logout"><img align="right" src="https://duthiepower.com/wp-content/uploads/2021/05/Duthie-Power-top-generators-270x270.png" class="home"></a><br><br><br><br> 
<body>
<div class="details">
<form action="getItem">
<b>Enter your unreimbursed medical expenses:</b><br><br>
<input type="text" name="unreim"><br><br>
<b>Enter your long-term care premium insurances:</b><br><br>
<input type="text" name="insu"><br><br>
<b>Enter your State,local taxes,income,property taxes:</b><br><br>
<input type="text" name="tax"><br><br>
<b>Enter your mortgage interest paid:</b><br><br>
<input type="text" name="mort"><br><br>
<b>Enter your losses due to federal disasters:</b><br><br>
<input type="text" name="federal"><br><br>
<input type="submit" value="Submit">
</form>
</div>
<div class="info">
<br><br><br>
This page allows you to enter the information to calculate the itemized tax.<br>
In case you have not any of these expenses, it is better to go with the<br>
standardized tax method. But if you choose to proceed with this anyway,<br>
then click submit. Fill applicable fields for accurate results.<br><br><br>
<hr>
</div>
</body>
</html>