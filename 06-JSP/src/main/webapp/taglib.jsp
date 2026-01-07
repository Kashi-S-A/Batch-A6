<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<body>
	<h1>Custom Tags</h1>

	<!-- JSTL -->
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<!-- Creating a variable -->
	<c:set var="a" value="100"></c:set>

	<!-- print the variable -->
	<h2>
		<c:out value="${a}"></c:out>
	</h2>

	<c:choose>
		<c:when test="${a==100}">
			<h1 style="color: red">Yes a contains 100</h1>
		</c:when>
		<c:when test="${a>100}">
			<h1>Yes a is greater than 100</h1>
		</c:when>
		<c:otherwise>
			<h1>a is less than 100</h1>
		</c:otherwise>
	</c:choose>

	<hr>

	<c:remove var="a" />

	<h2>
		<c:out value="${a}"></c:out>
	</h2>

	<%-- <c:redirect url="https://www.instagram.com/"></c:redirect> --%>

	<c:import url="https://www.instagram.com/"></c:import>

</body>
</html>