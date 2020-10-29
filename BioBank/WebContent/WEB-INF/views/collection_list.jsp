<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Collection Manager</title>
</head>
<body>
	<div align="center">

		<h1>Collections</h1>
		<h3>
			<a href="new">New Collection</a>
		</h3>
		<table border="1" bordercolor="white" bgcolor="pink">
			<tr>
				<th>No</th>
				<th>Disease Term</th>
				<th>Title</th>
				<th>Samples</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${listCollection}" var="collection"
				varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${collection.disease_term}</td>
					<td>${collection.title}</td>
					<td><a href="samples?id=${collection.id}">Samples</a></td>
					<td><a href="edit?id=${collection.id}">Edit</a> &nbsp; &nbsp;
						&nbsp; <a href="delete?id=${collection.id}">Delete</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>