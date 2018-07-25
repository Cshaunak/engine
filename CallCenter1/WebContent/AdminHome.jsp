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
<body bgcolor="pink">
<center><h1><font></font size="30">CallCenterAdmineHome</h1></center></font>
	<hr size="3" width="300" color="green" align="center">
	
<center><a href="customerEx.jsp">Add Customer Executive</a></center>
<center><a href="Keyword.jsp">Add Keyword</a></center>
	<center><a href="viewCustomer.jsp">View Customer Details</a></center>
	<center><a href="GetAllEnquiryServlet">View pending Enquiry Details</a></center>
	<center><a href="logout">Logout</a></center>

</body>
</html>