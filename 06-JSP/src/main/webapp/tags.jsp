<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP tags</h1>
	<hr>
	
	<%
	
		List<String> list = new ArrayList<String>();
	
	%>

	<!-- Declaration Tag -->

	<%!
	int a = 10;

	public String getMessage() {
		return "How are you ?";
	}
	%>
	
	<!-- Expression Tag -->
	<h1>a : <%=a %></h1>
	
	<h1>Greet : <%= "Good afternoon" %></h1>

	<h1>Msg : <%=getMessage()%></h1>
	
	
	<!-- Scriptlet Tag -->
	<%
	
		int b = 10;
	
		out.print("this is print of jspWriter");
	%>

</body>
</html>