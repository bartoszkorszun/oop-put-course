<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>eStorageMS</title>
	</head>
	<body>
		<h2>Add Entry Package</h2>
		
		<form action="summary">
			
			Tracking number: <input type="text" name="trackingNumber">
			<br><br>
			Status: <input type="text" name="status">
			<br><br>
			Height: <input type="number" name="height">
			<br><br>
			Width: <input type="number" name="width">
			<br><br>
			Depth: <input type="number" name="depth">
			<br><br>
			Weight: <input type="number" name="weight">
			<br><br>
			Date of entry: <input type="date" name="entryDate">
			<br><br>
			Date of delivery: <input type="date" name="deliveryDate">
			<br><br>
			<input type="submit" value="Submit">
			
		</form>
	</body>
</html>