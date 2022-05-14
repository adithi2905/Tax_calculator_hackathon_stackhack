<%-- This page is  for getting the login details --%>

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
font-size:140%;
resize: both;
line-height: 1.5;
display: inline-block;
border-color: rgb(0,0,102);
padding:2%;
position: absolute;
top:15%;
left:40%;
box-shadow:  8px 8px 15px #202020, 
             -8px -8px 15px #2c2c2c;
transition: box-shadow .35s ease !important;
    
}
.home
{
width: 2%;
radius: 2%;
length: 15%;
align: right;

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
<%

response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); 
String msg=(String)session.getAttribute("msg");
if(msg!=null)
{
	out.print("<center><h3><b>"+msg+"</b></h3></center>");
}
session.removeAttribute("msg");
if(session.getAttribute("phno")!=null)
	response.sendRedirect("logout");

%>
<div>
<form action="log">
<b>Enter your phone number:</b><br>
<input type="text" name="phno" required><br><br>
<b>Enter your password:</b><br>
<input type="password" name="pass" required><br><br>
<input type="submit" value="submit">
</form>
<h6>Don't have account?<a href="Signup.jsp">SignUp</a> here.</h6>
</div>
</html>