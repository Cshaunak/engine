<%@page import="CallCenter.bin.Users"%>
<%@page import="CallCenter.bin.Enquiry"%>
<%@page import="CallCenter.bin.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pending Enquiry </title>
</head>
<%
	Users users = (Users)session.getAttribute("users");
	if(users == null){
		response.sendRedirect("login.jsp");
	}else {
	List<Enquiry> elist = (List<Enquiry>)request.getAttribute("elist");
	
%>
<body bgcolor="silver">	
	<center><h1><font size="30">Enquiry Pendiing Details</h1></center></font>
	
	<%try{
		System.out.println("Inside try");					
		if(!elist.isEmpty()){
				System.out.println("Inside if");
										for(Enquiry e : elist){
								%>
			Enquiry ID : <b><%=e.getEid()%></b><br> 
			Enquiry Description : <b><%=e.getEdesc()%></b><br>
			Enquiry Solution : <b><%=e.getEsolution() %></b><br>
			Enquiry Status : <b><%=e.getEstatus() %></b><br>
			
								<%
										}
									}
								%>

<td><a href="AdminHome.jsp">Home Page</a></td><td align="center">
<%} 

catch(Exception e)
{
	System.out.println(e);
}
}
%>
</html>


</body>
