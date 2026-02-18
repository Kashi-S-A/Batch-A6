<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Register Here</h1>
	<form action="register" method="post">
		Name : <input type="text" name="un" placeholder="Enter name" required><br>
		Email : <input type="email" name="ue" placeholder="Enter Email" required><br>
		Password : <input type="password" name="pwd" placeholder="Enter Pwd" required><br>
		<input type="submit" value="Register">
		
	</form>
</body>
</html>