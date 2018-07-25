<%@page import="CallCenter.bin.Users"%>
<%@page import="CallCenter.bin.Enquiry"%>
<%@page import="CallCenter.bin.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view Enquiry </title>
</head>
<%
	Users users = (Users)session.getAttribute("users");
	if(users == null)
		response.sendRedirect("login.jsp");
	Enquiry st = (Enquiry)session.getAttribute("er");
%>
<body bgcolor="silver">	
	<center><h1><font size="30">Enquiry Details</h1></center></font>
	<center>
		<%
			if(st != null){
		%>
		
			Customer id : <b><%=st.getCustomer().getCid()%></b><br>
			name : <b><%=st.getCustomer().getCname() %></b><br>
			email : <b><%=st.getCustomer().getCemail() %></b><br>
			Dob :<b><%=st.getCustomer().getDob() %></b><br>
			Phone : <b><%=st.getCustomer().getCphone() %></b><br> 
		
			Keyword ID : <b><%=st.getKeyword().getKid() %></b><br> 
			Enquiry Description : <b><%=st.getKeyword().getKdescription() %></b><br>
			Enquiry Solution : <b><%=st.getEsolution() %></b><br>
			Enquiry Status : <b><%=st.getEstatus() %></b><br>
			
			<a href="editenquiryDetails.jsp">Edit/Update Details</a>
		<%
			}else{
		%>
			<b>Sorry..! No Data Found..!</b>
		<%
			}
		%>
	</center>

</html>


</body>
