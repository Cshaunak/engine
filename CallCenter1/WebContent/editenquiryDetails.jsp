<%@ page import="CallCenter.bin.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="CallCenter.bin.*" %>
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
	
	Enquiry er = (Enquiry)session.getAttribute("er");
%>
<body bgcolor="silver">
<center><font size="30">Edit/Update Enquiry</center></font>
	<form action="EditEnquiryDetails" method="POST">
	<center><h1>Customer Edit/Update Page</h1></center>
<table>
		<tr>
		<td>Enquiry ID </td><td><input type="text" name="eid" disabled=disabled value="<%=er.getEid()%>">
		<input type="hidden" name="eid" value="<%=er.getEid()%>"></td>
			<td>Enquiry Status </td><td><input type="text" name="estatus" value="<%=er.getEstatus()%>" ></td>
			<td>Enquiry Description </td><td><input type="text" name="edesc" value="<%=er.getEdesc()%>" ></td>
			<td>Enquiry Solution </td><td><input type="text" name="esolution" value="<%=er.getEsolution()%>" ></td>
			<td><input type="hidden" name="cid" value="<%=er.getCustomer().getCid()%>" ></td>
			<td><input type="hidden" name="kid" value="<%=er.getKeyword().getKid()%>" ></td>
			
		</tr>
		<tr>
			<td><a href="CallCenterExecutiveHome.jsp">Home Page</a></td><td align="center">
			<input type="submit" name="sbmt" value="Update Details"></td>
		</tr>
	</table>
	</form>
</body>
</html>