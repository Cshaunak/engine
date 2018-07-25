
<%@ page import="CallCenter.bin.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view customer</title>
</head>
<%
	Users users = (Users)session.getAttribute("users");
	if(users == null)
		response.sendRedirect("login.jsp");
	
	Customer st = (Customer)session.getAttribute("st");
%>
<body bgcolor="silver">	
	<center><h1><font size="30">Customer Details</h1></center></font>
	<center>
		<%
			if(st != null){
		%>
			Customer Name : <b><%=st.getCname()%></b><br>
			Email : <b><%=st.getCemail() %></b><br>
			Dob :<b><%=st.getDob() %></b><br>
			Phone : <b><%=st.getCphone() %></b><br> 
			
			<% if(users.getUrole().equals("executive")||users.getUrole().equals("callcenterExecutive"))
		{%>
			
			<a href="editCustomerDetails.jsp">Edit/Update Details</a>
			<td><a href="CallCenterExecutiveHome.jsp">Home Page</a></td><td align="center">
			
			<% } else {%>
			
			<td><a href="AdminHome.jsp">Home Page</a></td><td align="center">
		<%}
			}else{
		%>
			<b>Sorry..! No Data Found..!</b>
		<%
			}
		%>
	</center>
</body>
</html>