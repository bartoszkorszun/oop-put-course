<%@page import="estorage.main.controllers.EquipmentController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>eStorageMS</title>
	</head>
	<body>
		
		<h2>Equipment</h2>
		
		<input type="button" value="New Equipment" onclick="window.location.href='http://localhost:8080/eStorage-Management-System/equipment/newEquipment'">
		<br><br>
		<input type="button" value="Main Page" onclick="window.location.href='http://localhost:8080/eStorage-Management-System/'">
		<br><br>
		
		<% 
		estorage.main.controllers.EquipmentController eController = new EquipmentController();
		eController.viewList();
		java.util.List<String> tLst = eController.types;
		java.util.List<String> aLst = eController.amount;
		java.util.List<Integer> ids = eController.ids;
		%>
		<%
		for (int i=tLst.size()-1; i>=0; i--){
			out.println("<table border=\"1\">");
			if(i==tLst.size()-1){
				out.println("<tr><th style=\"width: 200px\">Type</th><th style=\"width: 100px\">Amount</th></tr>");
				out.println("<tr><td style=\"width: 200px\">" + tLst.get(i) 
				+ "</td><td style=\"width: 100px\">" + aLst.get(i)
				+ "</td><td style=\"width: 100px\">" + "<a href=\"deleteEquipment/confirm/" + ids.get(i) + "\">Delete</a>"
				+ "</td></tr>");
			}else{
				out.println("<tr><td style=\"width: 200px\">" + tLst.get(i) 
				+ "</td><td style=\"width: 100px\">" + aLst.get(i)
				+ "</td><td style=\"width: 100px\">" + "<a href=\"deleteEquipment/confirm/" + ids.get(i) + "\">Delete</a>"
				+ "</td></tr>");
			}
			out.println("</table>");
		}
		%>
		
	</body>
</html>