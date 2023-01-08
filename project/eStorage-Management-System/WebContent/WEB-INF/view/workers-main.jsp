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
		<input type="button" value="Main Page" onclick="window.location.href='http://localhost:8080/eStorage-Management-System/'">
		<br><br>
		
		<% 
		estorage.main.controllers.WorkersController wController = new WorkersController();
		wController.viewList();
		java.util.List<String> nLst = wController.employeesNames;
		java.util.List<String> dLst = wController.employeesDates;
		java.util.List<String> pLst = wController.employeesPositions;
		%>
		<%
		for (int i=nLst.size()-1; i>=0; i--){
			out.println("<table border=\"1\">");
			if(i==nLst.size()-1){
				out.println("<tr><th style=\"width: 200px\">Full name</th><th style=\"width: 100px\">Birth date</th><th style=\"width: 100px\">Position</th></tr>");
				out.println("<tr><td style=\"width: 200px\">" + nLst.get(i) 
				+ "</td><td style=\"width: 100px\">" + dLst.get(i)
				+ "</td><td style=\"width: 100px\">" + pLst.get(i)
				+ "</td></tr>");
			}else{
				out.println("<tr><td style=\"width: 200px\">" + nLst.get(i) 
				+ "</td><td style=\"width: 100px\">" + dLst.get(i)
				+ "</td><td style=\"width: 100px\">" + pLst.get(i)
				+ "</td></tr>");
			}
			out.println("</table>");
		}
		%>
	</body>
</html>