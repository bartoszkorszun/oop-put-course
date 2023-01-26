<%@page import="estorage.main.controllers.PackagesController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>eStorageMS</title>
	</head>
	<body>
	
		<h2>Packages</h2>
		
		<input type="button" value="New Package" onclick="window.location.href='http://localhost:8080/eStorage-Management-System/packages/entryPackage'">
		<br><br>
		<input type="button" value="Main Page" onclick="window.location.href='http://localhost:8080/eStorage-Management-System/'">
		<br><br>
		
		<% 
		estorage.main.controllers.PackagesController pController = new PackagesController();
		pController.viewList();
		java.util.List<String> tnLst = pController.trackingNumbers;
		java.util.List<String> sLst = pController.statuses;
		java.util.List<String> hLst = pController.heights;
		java.util.List<String> wiLst = pController.widths;
		java.util.List<String> dLst = pController.depths;
		java.util.List<String> weLst = pController.weights;
		java.util.List<String> doeLst = pController.datesOfEntry;
		java.util.List<String> dodLst = pController.datesOfDelivery;
		java.util.List<Integer> ids = pController.ids;
		%>
		<%
		for (int i=tnLst.size()-1; i>=0; i--){
			out.println("<table border=\"1\">");
			if(i==tnLst.size()-1){
				out.println("<tr><th style=\"width: 100px\">Tracking number</th><th style=\"width: 100px\">Status</th><th style=\"width: 100px\">Height</th><th style=\"width: 100px\">Width</th><th style=\"width: 100px\">Depth</th><th style=\"width: 100px\">Weight</th><th style=\"width: 100px\">Entry date</th><th style=\"width: 100px\">Delivery date</th></tr>");
				out.println("<tr><td style=\"width: 100px\">" + tnLst.get(i) 
				+ "</td><td style=\"width: 100px\">" + sLst.get(i)
				+ "</td><td style=\"width: 100px\">" + hLst.get(i)
				+ "</td><td style=\"width: 100px\">" + wiLst.get(i)
				+ "</td><td style=\"width: 100px\">" + dLst.get(i)
				+ "</td><td style=\"width: 100px\">" + weLst.get(i)
				+ "</td><td style=\"width: 100px\">" + doeLst.get(i)
				+ "</td><td style=\"width: 100px\">" + dodLst.get(i)
				+ "</td><td style=\"width: 100px\">" + "<a href=\"deletePackage/confirm/" + ids.get(i) + "\">Delete</a>"
				+ "</td></tr>");
			}else{
				out.println("<tr><td style=\"width: 100px\">" + tnLst.get(i) 
				+ "</td><td style=\"width: 100px\">" + sLst.get(i)
				+ "</td><td style=\"width: 100px\">" + hLst.get(i)
				+ "</td><td style=\"width: 100px\">" + wiLst.get(i)
				+ "</td><td style=\"width: 100px\">" + dLst.get(i)
				+ "</td><td style=\"width: 100px\">" + weLst.get(i)
				+ "</td><td style=\"width: 100px\">" + doeLst.get(i)
				+ "</td><td style=\"width: 100px\">" + dodLst.get(i)
				+ "</td><td style=\"width: 100px\">" + "<a href=\"deletePackage/confirm/" + ids.get(i) + "\">Delete</a>"
				+ "</td></tr>");
			}
			out.println("</table>");
		}
		%>
		
	</body>
</html>