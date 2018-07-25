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
<body bgcolor="yellow">
	<center><font size="30">Enquiry Register</center></font>
	<form action="EnquiryRegister" method="POST">
	<table align="center" width="300" height="70">
		
		<tr>
			<td>Customer ID :</td><td><input type="number" name="cid" ></td>
		</tr>	
		<tr>
			<td>Keyword ID :</td><td><input type="number" name="kid"></td>
		</tr>
		<tr>
			<td>Enquiry Description </td><td><input type="text" name="edesc"></td>
		</tr>
		<tr>
			<td>Enquiry Solution </td><td><input type="text" name="esolution"></td>
		</tr>
		<tr>
			<td>Enquiry Status </td><td><input type="text" name="estatus" value="PENDING"></td>
		</tr>
		
		<tr>
			<td><a href="CallCenterExecutiveHome.jsp">Home Page</a></td><td align="center">
			<input type="submit" name="sbmt" value="Update Details"></td>
		</tr>
	</table>
	</form>
</body>
</html>
