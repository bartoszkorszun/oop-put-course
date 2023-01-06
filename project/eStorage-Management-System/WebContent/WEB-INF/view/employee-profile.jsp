<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>eStorageMS</title>
	</head>
	<body>
		
		<h2>Employee's profile</h2>
		
		Employee:
		<br><br>
		Full Name:
		${ firstName }
		${ lastName }
		<br><br>
		Birth Date:
		${ birthDate }
		<br><br>
		Position:
		${ position }
		
		<br><br>
		<form action="main">
			<input type="submit" value="Confirm">
		</form>
		
	</body>
</html>