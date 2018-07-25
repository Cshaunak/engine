<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="CallCenter.bin.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>logout page</title>
</head>
<%
	Users users = (Users)session.getAttribute("users");
	if(users == null)
		response.sendRedirect("login.jsp");
	
%>
<body>
center><h1>Logout Page</h1></center>
	<form action="logout" method="POST">
	<table align="center" width="300" height="70">
		
		<tr>
	 
			 <input type="submit" action= name="sbmt" value="Logout"></td>
			
		</tr>
	</table>
	</form>

</body>
</html>