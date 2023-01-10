<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>eStorageMS</title>
	</head>
	<body>
		
		<h2>Working Hours</h2>
		
		<form action="submitHours">
		
			<input type="date" name="date">
			<br><br>
			<input type="time" name="startingHour">
			<br><br>
			<input type="time" name="finishingHour">
			<br><br>
			<input type="submit" value="Submit">
		
		</form>
		
	</body>
</html>