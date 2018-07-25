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
<body bgcolor="orange">
<center><h1><font size="30">CallCenterExecutiveHome</h1></center></font>
	<hr size="3" width="300" color="green" align="center">
	
<center><a href="customer.jsp">Add Customer</a></center>
<center><a href="enquiry.jsp">Add Enquiry</a></center>
	<center><a href="viewCustomer.jsp">View Customer Details</a></center>
	<center><a href="viewenquiry.jsp">View Enquiry Details</a></center>
	<center><a href="logout">Logout</a></center>
</body>
</html>