<%@ page import="CallCenter.bin.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Customer Details</title>
</head>
<%
	Users users = (Users)session.getAttribute("users");
	if(users == null)
		response.sendRedirect("login.jsp");

%>
<body bgcolor="ffce33">	
	<center><font size="30">View Customer</center></font>
	<form action="CustomerDetailServlet" method="POST">
	<table align="center" width="300" height="70">
		<tr>
			<td>Customer ID :</td><td><input type="number" name="cid" ></td>
		</tr>
		<tr>
		<% if(users.getUrole().equals("executive")||users.getUrole().equals("callcenterExecutive"))
		{%>
			<td><a href="CallCenterExecutiveHome.jsp">Home Page</a></td><td align="center">
			<%}
			 else {%>
			<td><a href="AdminHome.jsp">Home Page</a></td><td align="center">
			<% }%>
			<input type="submit" name="sbmt" value="View Customer"></td>
			
				
			}
				
		</tr>
	</table>
	</form>
</body>
</html>