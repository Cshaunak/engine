<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="CallCenter.bin.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit/Update Details</title>
</head>
	<%
	Users users = (Users)session.getAttribute("users");
	System.out.println("User Edit Customer"+users.getUrole());
	if(users == null)
		response.sendRedirect("login.jsp");
	
	Customer st = (Customer)session.getAttribute("st");
%>
<body bgcolor="silver">
<center><font size="30">Edit/Update Customer</center></font>
	<form action="EditCustomerDetails" method="POST">
	<center><h1>Customer Edit/Update Page</h1></center>

		<tr>
			<td>Customer ID </td><td><input type="number" name="cid" value="<%=st.getCid()%>" disabled="disabled">
							<input type="hidden" name="cid" value="<%=st.getCid()%>">	
						</td>
			
		</tr>
		<tr>
			<td>Name </td><td><input type="text" name="name" value="<%=st.getCname()%>"></td>
		</tr>	
		<tr>
			<td>Email :</td><td><input type="email" name="email" value="<%=st.getCemail()%>"></td>
		</tr>
		
		<tr>
			<td>DOB </td><td><input type="text" name="dob" value="<%=st.getDob()%>"></td>
		</tr>
		<tr>
			<td>Phone </td><td><input type="number" name="phone" value="<%=st.getCphone()%>"></td>
		</tr>
		
		<tr>
		<% if(users.getUrole().equals("executive")||users.getUrole().equals("callcenterExecutive"))
		{%>
			<td><a href="CallCenterExecutiveHome.jsp">Home Page</a></td><td align="center">
			<input type="submit" name="sbmt" value="Update Details"></td>
			<%} %>
		</tr>
	</table>
	</form>