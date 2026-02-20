<%@page import="com.tyss.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to display Page</h1>

	<h2>Person Details</h2>
	<h4>Name : ${personName }</h4>
	<h4>Age : ${personAge }</h4>
	
	<hr>
	
	<h2>User Details</h2>
	<h4>Name : ${userData.name}</h4>
	<h4>Email : ${userData.email}</h4>
	<h4>Phone : ${userData.phone}</h4>
	<h4>Address : ${userData.address}</h4>
	<h4>Age : ${userData.age}</h4>
	<h4>Gender : ${userData.gender}</h4>
	
	<hr>
	
	<%
		User user =(User) request.getAttribute("userData");
	
		String pName =(String) request.getAttribute("personName");
		
		int pAge =(int) request.getAttribute("personAge");
	%>
	
	<h2>Person Name : <%=pName%></h2>
	<h2>Person Age : <%=pAge%></h2> 
	
	<h2>User Name : <%=user.getName() %></h2>
	<h2>User Email : <%=user.getEmail()%></h2>
	<h2>User Age : <%=user.getAge() %></h2>
		

</body>
</html>