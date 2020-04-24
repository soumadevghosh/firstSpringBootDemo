<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Alien</title>
</head>
<body>
Inserting name and Id
	<form action="addAlien" method="post">
		Enter ID: <input type="text" name ="aid"></input>
		Enter Name: <input type="text" name ="aname"></input>
		<input type="submit" value="Submit">
	</form>
	<hr><br>
	<form action="getAlienById" method="get">
		Enter ID: <input type="text" name="aid"/><br>
		<input type="submit" value="Get By Id"/>	
	</form>
	<form action="getAlienByName" method="get">
		Enter Name: <input type="text" name="aname"/><br>
		<input type="submit" value="Get By Name"/>	
	</form>
	
	<hr><br>
	<form action="getAllAliens" method="get">
		<input type="submit" value="Show All"/>
	</form>
</body>
</html>