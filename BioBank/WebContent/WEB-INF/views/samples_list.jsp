<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Samples</title>
</head>
<body>
<div align="center">

<h1>Samples</h1>
<a href="newsample">Add Samples to this collection</a>

	<table border="1" bordercolor="black" >
	<tr>
	<th>No</th>
	<th>Collection_Id</th>
	<th>Donor_Count</th>
	<th>Material_Type</th>
	<th>Last_Updated</th>
	<th>Actions</th>
	</tr>
	<c:forEach items="${Samples}" var="sample" varStatus="status"> 
	<tr>
		<td>${status.index+1}</td>
		<td>${sample.collection_id}</td>
		<td>${sample.donor_count}</td>
    	<td>${sample.material_type}</td>
    	<td>${sample.last_updated}</td>
    	<td>
	   		<a href="editsample?id=${sample.id}">Edit</a>
	   		 &nbsp; &nbsp; &nbsp;
	   		<a href="deletesample?id=${sample.id}">Delete</a>
	   </td>
    	
	</tr>
	</c:forEach>
	</table>

</div>
</body>
</html>