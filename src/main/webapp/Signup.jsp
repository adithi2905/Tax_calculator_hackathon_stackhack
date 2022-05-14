<%-- This page is to get the signup details --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
body
{
background-color:#5c5470;
}
h2
{
color: rgb(0,0,102);
}
input
{
  border-color: rgb(0,0,102);
  color: black;
  box-shadow:  8px 8px 15px #202020, 
             -8px -8px 15px #2c2c2c;
transition: box-shadow .35s ease !important;
}
div
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
top:10%;
left:40%;
box-shadow:  8px 8px 15px #202020, 
             -8px -8px 15px #2c2c2c;
transition: box-shadow .35s ease !important;
    
}
input[type=submit] {
            background-color: black;
            border: none;
            font-size: 80%;
            text-decoration: none;
            color: white;
            padding: 20px 20px;
            margin: 20px 20px;
            cursor: pointer;
            top: 75%;          
}
</style>
<body>

<%
String msg=(String)session.getAttribute("msg");
if(msg!=null)
{
	out.print("<center><h3><b>"+msg+"</b></h3></center>");
}
	session.removeAttribute("msg");
%>
<div>
<form action="signup">
<br>
<b>Enter your User Name:</b><br>
<input type="text" name="username" required><br><br>
<b>Enter the password:</b><br>
<input type="password" name="pass" required><br><br>
<b>Enter the mail id:</b><br>
<input type="email" name="mail" required><br><br>
<b>Enter the contact number:</b><br>
<input type="text" name="phno" required><br><br>
<input type="submit" value="Signup"><br><br>
<h5>Already have an account?<a href="Login.jsp">Sign in</a> here.</h5>
</form>.
</div>
</body>
</html>