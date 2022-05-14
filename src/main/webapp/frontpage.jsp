
<%-- This page is the starting point of the application --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<style>
body
{
background-color:#5c5470;
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
left:30%;
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
            top: 20%; 
            float:right;
            

            
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
</style>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); 
%>
<body>
<div>
<h3 style="color: black;">About the site<hr></h3>

<p style="color:white">
<I>This site is designed to help the people calculate their <br>
taxes for free and make better financial decisions.<br>
There are various sites which actually are of great help <br>
when it comes to knowing about your tax benefits.<br>
For more details,please use the given link.<a href="taxInfo.html" style="color:blue">here</a></I></p>
</div>
<span>
<form action="Signup.jsp">
<input type="submit" value="Signup">
</form>

<form action="Login.jsp">
<input type="submit" value="Signin">
</form>
</span>

</body>
</html>