<%-- This page is to get the tax exemption details to further calculate the Adjusted Gross Income --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
.details
{
background-color: #5c5470;
color: black;
font-family: lato;
font-size:120%;
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
left:60%;
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
else
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); 
%>
<a href="frontpage.jsp"><img align="left" src="https://cdn.onlinewebfonts.com/svg/img_67037.png" class="home"></a>
	<a href="logout"><img align="right" src="https://duthiepower.com/wp-content/uploads/2021/05/Duthie-Power-top-generators-270x270.png" class="home">
	</a><br>
<body>
<div class="details">
<h2>Enter the tax credits applicable for you<hr></h2><br>

<form action="getRed">
<I><b>Enter your health insurance/<br>
retirement contributions tax credit:</b><br><br>
<input type="text" name="self"><br><br>
<b>Enter your classroom expenses credit if<br>
 you are a teacher/educator:</b><br><br>
<input type="text" name="classroom"><br><br>
<b>Enter your tax credit if you are a performing<br>
 artist/reservist/fee-basis government official:</b><br><br>
<input type="text" name="artists"><br><br>
<b>Enter your charitable contributions</b><br><br>
<input type="text" name="charity"><br><br>
<b>Enter your moving expenses if you are in army:</b><br><br>
<input type="text" name="army"><br><br>
<b>If you are entitled to any other tax credit,<br>
pls enter it</b><br><br>
<input type="text" name="other"><br><br></I>
<input type="submit" value="Submit">
</form>
</div>
<div class="info">
<br><br><br>
These are expenses which can be exempted from your <br>
total taxable income or AGI.If you have any applicable<br>
expenses(with proof), then pls enter those.Otherwise,<br>
give submit and skip to the next page.<br>
<br><br><br><hr>
</div>
</body>
</html>