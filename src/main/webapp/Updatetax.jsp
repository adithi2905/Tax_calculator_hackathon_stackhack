<%-- This page is to get type,status of tax filing details to overwrite the existing ones --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
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
top:15%;
left:30%;
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
	response.sendRedirect("frontpage.jsp");
else{
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); 
	String msg=(String)sess.getAttribute("msg");
	if(msg!=null)
	{
		out.print("<center><h3><b>"+msg+"</b></h3></center>");
	}
	sess.removeAttribute("msg");
}
%>
<a href="frontpage.jsp"><img align="left" src="https://cdn.onlinewebfonts.com/svg/img_67037.png" class="home"></a>
	<a href="logout"><img align="right" src="https://duthiepower.com/wp-content/uploads/2021/05/Duthie-Power-top-generators-270x270.png" class="home">
	</a><br><br><br><br> 

<body>
<div class="details">
<h6><b>In case you don't know your AGI,pls calculate it here.<a style="color: blue" href="calc.jsp">Find your AGI</a>
</b></h6>

<form action="updatetax">
<b>Enter your AGI:</b><br><br>
<input type="text" name="sal" placeholder="salary"><br><br>
<b>Select the status of filing:</b><br><br>
<input type="radio" name="status" value="single">  Single<br><br>
<input type="radio" name="status" value="head">  Head of the household<br><br>
<input type="radio" name="status" value="joint">  Married but filing jointly<br><br>
<input type="radio" name="status" value="separate">  Married but filing separately<br><br>
<b>Select the type of tax reduction:</b><br><br>
<input type="radio" name="type" value="Standardised" required>  Standardized<br><br>
<input type="radio" name="type" value="Itemized" required>  Itemized<br><br>
<input type="radio" name="type" value="Both" required>  Both<br><br>
<b>Select the year:</b><br><br>
<input type="radio" name="year" value="2021">2021<br><br>
<input type="radio" name="year" value="2022">2022<br><br>
<input type="submit" value="Submit">
</form>
</div>

</body>
</html>