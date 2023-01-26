<%@page import="java.util.List"%>
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
		<input type="button" value="Workers" onclick="window.location.href='http://localhost:8080/eStorage-Management-System/workers/main'">
		<br><br>
		<input type="button" value="Main Page" onclick="window.location.href='http://localhost:8080/eStorage-Management-System/'">
		<br><br>
		<h2>Employees working hours</h2>
		<br><br>
		
		<%
		estorage.main.controllers.WorkersController wController = new WorkersController();
		wController.viewHours();
		List<String> d = wController.whDates;
		List<String> ts = wController.whDates;
		List<String> tf = wController.whDates;
		List<Integer> iSum = wController.sumH;
		
		int sum = 0;
		
		for(int i=0; i<iSum.size(); i++){
			sum += iSum.get(i);
		}
		
		out.println("<h3>Summarised hours: " + sum + "</h3>");
		
		for (int i=d.size()-1; i>=0; i--){
			out.println("<table border=\"1\">");
			if(i==d.size()-1){
				out.println("<tr><th style=\"width: 200px\">Date</th><th style=\"width: 100px\">Starting Hour</th><th style=\"width: 100px\">Finishing Hour</th><th style=\"width: 100px\">Sum</th></tr>");
				out.println("<tr><td style=\"width: 200px\">" + d.get(i) 
				+ "</td><td style=\"width: 100px\">" + ts.get(i)
				+ "</td><td style=\"width: 100px\">" + tf.get(i)
				+ "</td><td style=\"width: 100px\">" + iSum.get(i)
				+ "</td></tr>");
			}else{
				out.println("<tr><td style=\"width: 200px\">" + d.get(i) 
				+ "</td><td style=\"width: 100px\">" + ts.get(i)
				+ "</td><td style=\"width: 100px\">" + tf.get(i)
				+ "</td><td style=\"width: 100px\">" + iSum.get(i)
				+ "</td></tr>");
			}
			out.println("</table>");
		}		
		%>
		
	</body>
</html>