<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="CallCenter.bin.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body bgcolor="orange">
<img src="\images\cc pic2.jpg" height=400,width=200 >
<center><h1><font size=24 face="cooper">Login Page</h1></center></font>
	<form action="login" method="POST">
	<table align="center" width="300" height="70">
		<tr>
			<td>Email : </td><td><input type="email" name="email" placeholder="Enter Your Email"></td>
		</tr>
		<tr>
			<td>Password :</td><td><input type="password" name="password" placeholder="Enter Your password"></td>
		</tr>
		<tr>
			<td>Role :</td><td> <select name="role">
								<option value="">Select Role</option>
								<option value="admin">CallCenterAdmin</option>
								<option value="executive">CallCenterExecutive</option>
								</select></td>
		</tr>
		<tr>
		
			 
			 <td align="center"><input type="submit" name="sbmt" value="Login"></td>
			 
			
		</tr>
	</table>
	</form>
</body>
</html>