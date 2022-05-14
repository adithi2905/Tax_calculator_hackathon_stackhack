<%-- This page is to get the total income details of the user --%>

<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1"
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
String msg=(String)sess.getAttribute("msg");
if(sess.getAttribute("phno")==null)
	response.sendRedirect("Login.jsp");
else
{
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); 
	if(msg!=null)
		out.print("<center><h2>"+msg+"</h2></center>");
}
sess.removeAttribute("msg");
%>
<a href="frontpage.jsp"><img align="left" src="https://cdn.onlinewebfonts.com/svg/img_67037.png" class="home"></a>
	<a href="logout"><img align="right" src="https://duthiepower.com/wp-content/uploads/2021/05/Duthie-Power-top-generators-270x270.png" class="home">
	</a><br>
<body>
<div class="details">
<h3>Enter the details that are applicable for you<hr></h3>
<form action="getdetails">
<I><b>Enter your salary:</b><br><br>
<input type="text" name="sal"><br><br>
<b>Enter your business income:</b><br><br>
<input type="text" name="business"><br><br>
<b>Enter your farm income:</b><br><br>
<input type="text" name="farm"><br><br>
<b>Enter your union strike benefits:</b><br><br>
<input type="text" name="union"><br><br>
<b>Enter your Taxable refunds, credits, or offsets of<br> state and local income taxes:</b><br><br>
<input type="text" name="tax"><br><br>
<b>Enter your Long-term disability benefits received<br> prior to minimum retirement age:</b><br><br>
<input type="text" name="disability"><br><br>
<b>Enter your Jury duty fees</b><br><br>
<input type="text" name="Security"><br><br>
<b>Enter your Awards, prizes, gambling, lottery,<br> and contest winnings:</b><br><br>
<input type="text" name="awards"><br><br>
<b>Enter your Back pay from labor discrimination lawsuits:</b><br><br>
<input type="text" name="labor"><br><br>
<b>Spousal support:</b><br><br>
<input type="text" name="spousal"><br><br>
<b>Enter your Unemployment benefits:</b><br><br>
<input type="text" name="unemp"><br><br>
<b>Capital gains:</b><br><br>
<input type="text" name="gains"><br><br>
<b>Severance pay:</b><br><br>
<input type="text" name="pay"><br><br>
<b>Earnings from rental real estate, royalties,partnerships,<br>
corporations, trusts, and license payments:</b><br><br>
<input type="text" name="rental"><br><br>
<input type="submit" value="Submit"><br><br></I>
</form>
</div>
<div class="info">
<br><br><br>
1.This page allows you to calculate the net income for the year.<br>
If you have any income apart from the salary from your work place,<br>
then include it also to calculate your AGI. <br><br>

2.If you are self-employed person, then fill your business income<br>
 and others applicable to you.<br><br>
 
3.Please enter genuine details to get accurate results.<br><br><br><br>
<hr>
</div>
</body>
</html>