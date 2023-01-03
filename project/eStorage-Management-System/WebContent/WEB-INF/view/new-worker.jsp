<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>eStorageMS</title>
	</head>
	<body>
		<h2>Add new worker form</h2>
		
		<form action="employeeProfile">
			
			First name: <input type="text" name="firstName">
			<br><br>
			Last name: <input type="text" name="lastName"> 
			<br><br>
			Birth date: <input type="date" name="birthDate">
			<br><br>
			Login: <input type="text" name="login">
			<br><br>
			Password: <input type="text" name="password">
			<br><br>
			Position <input type="text" name="position">
			<br><br>
			Admin <input type="checkbox" name="admin">
			<br><br>
			<input type="submit" value="Submit">
		
		</form>
	</body>
</html>