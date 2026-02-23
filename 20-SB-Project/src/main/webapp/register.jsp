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
		Name : <input type="text" name="name" placeholder="Enter name" required><br>
		Email : <input type="email" name="email" placeholder="Enter Email" required><br>
		Password : <input type="password" name="password" placeholder="Enter Pwd" required><br>
		age	: <input type="number" name="age" placeholder="Enter Age" required><br>
		address  : <input type="text" name="address" placeholder="Enter Add" required><br>
		phone : <input type="number" name="phone" placeholder="Enter Phone" required><br>
		gender : <input type="text" name="gender" placeholder="Enter gender" required><br>
		<input type="submit" value="Register">
	</form>
</body>
</html>