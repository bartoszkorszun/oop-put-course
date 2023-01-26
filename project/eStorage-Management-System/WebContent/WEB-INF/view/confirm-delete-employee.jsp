<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>eStorageMS</title>
	</head>
	<body>
		<h3>Do you really want to delete this employee?</h3>
		<input type="button" value="Yes" onclick="window.location.href='http://localhost:8080/eStorage-Management-System/workers/deleteEmployee/${ deid }'"/>
		<input type="button" value="No" onclick="window.location.href='http://localhost:8080/eStorage-Management-System/workers/main'"/>
	</body>
</html>