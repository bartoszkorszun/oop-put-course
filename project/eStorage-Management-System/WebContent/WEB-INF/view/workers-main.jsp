<%@page import="estorage.main.controllers.WorkersController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>eStorageMS</title>
	</head>
	<body>
	
		<h2>Workers</h2>
		
		<input type="button" value="Add worker" onclick="window.location.href='http://localhost:8080/eStorage-Management-System/workers/addNewWorker'">
		<br><br>
		
		<% 
		estorage.main.controllers.WorkersController wc = new WorkersController();
		wc.viewList();
		java.util.List<String> lst = wc.employees;
		for (int i=lst.size()-1; i>=0; i--)
			out.println(lst.get(i) + "<br>");
		%>
		
	</body>
</html>