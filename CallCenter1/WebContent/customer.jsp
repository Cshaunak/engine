<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="CallCenter.bin.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<%
	Users users = (Users)session.getAttribute("users");
	if(users == null)
		response.sendRedirect("login.jsp");	
%>
<body bgcolor="green">
	<center><font size="30">Customer Register</center></font>
	<form action="CustomerRegisterProcess" method="POST">
	<table align="center" width="300" height="70">
		
		<tr>
			<td>Name </td><td><input type="text" name="name" placeholder="Enter Name Here"></td>
		</tr>	
		<tr>
			<td>Email :</td><td><input type="email" name="email"></td>
		</tr>
		<tr>
			<td>DOB </td><td><input type="text" name="dob"></td>
		</tr>
		<tr>
			<td>Phone </td><td><input type="text" name="phone"></td>
		</tr>
		
		<tr>
			<td><a href="CallCenterExecutiveHome.jsp">Home Page</a></td><td align="center">
			<input type="submit" name="sbmt" value="Update Details"></td>
		</tr>
	</table>
	</form>
</body>
</html>
