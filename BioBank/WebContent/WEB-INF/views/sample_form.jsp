<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sample Form</title>
</head>
<body>
<div align = "center">
<h1>Insert Sample to this collection</h1>
<form:form action="savesample" method="post" modelAttribute="sample">
	<table>
      <form:hidden path="id"/>
      <tr>
      <td>Collection ID:</td>
      <td><form:input path="collection_id"/></td>
      </tr>
      
      <tr>
      <td>Donor Count:</td>
      <td><form:input path="donor_count"/></td>
      </tr>
      
      <tr>
      <td>Material Type:</td>
      <td><form:input path="material_type"/></td>
      </tr>
      
      <tr>
      <td>Last Updated:</td>
      <td><form:input type="date" id="start" name="trip-start" value="2020-10-26" min="2000-01-01" path="last_updated"/></td>
      </tr> 
      <tr>
      	<td colspan="2" align="center"><input type="submit" value="Save" /></td>
      </tr>
     </table>
	</form:form>



</div>
</body>
</html>