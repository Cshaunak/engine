<%@ page import="CallCenter.bin.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	Users users = (Users)session.getAttribute("users");
	if(users == null)
		response.sendRedirect("login.jsp");

%>
<body bgcolor="33ff61">
<center><font size="30">View Enquiry</center></font>
	<form action="EnquiryDetailServlet" method="POST">
	<table align="center" width="300" height="70">
		<tr>
			<td>Enquiry ID :</td><td><input type="number" name="eid" ></td>
		</tr>
		<tr>
			<td><a href="CallCenterExecutiveHome.jsp">Home Page</a></td><td align="center">
			<input type="submit" name="sbmt" value="View Enquiry"></td>
		</tr>
	</table>
	</form>
</body>
</html>