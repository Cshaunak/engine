
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="CallCenter.bin.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation Page</title>
</head>
<% 
Users user = (Users)session.getAttribute("users");
	if(user == null)
	{
		response.sendRedirect("login.jsp");
	}
	String action = (String)request.getAttribute("action");
	String result = (String)request.getAttribute("result");
%>
<body>
	<center><h1>Confirmation Page</h1></center>
	<center>
		Action : <b><%=action %></b><br>
		Result : <b><%=result %></b><br>
	<a href="CallCenterExecutiveHome.jsp">Home</a>
	
	</center>
</body>
</html>