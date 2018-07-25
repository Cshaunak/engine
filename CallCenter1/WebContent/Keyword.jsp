<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="CallCenter.bin.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome</title>
</head>
<%
	Users users = (Users)session.getAttribute("users");
	if(users == null)
		response.sendRedirect("login.jsp");	 
%>

<body bgcolor="ff3371">
<center><font size="30" >Keyword Register</center></font>
	<form action="AddKeywordServlet" method="POST">
	<table align="center" width="300" height="70">
		 
	
		<tr>
			<td>Keyword name </td><td><input type="text" name="Kname"></td>
		</tr>
		<tr>
			<td>Keyword description </td><td><input type="text" name=" kdescripstion"></td>
		</tr>
	
		
		<tr>
			<td><a href="AdminHome.jsp">Home Page</a></td><td align="center">
			<input type="submit" name="sbmt" value="Update Details"></td>
		</tr>
	</table>
	</form>
</body>
</html>