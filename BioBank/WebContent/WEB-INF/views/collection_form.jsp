<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Collection Form</title>
</head>
<body>
<div align="center">
	<h1>Insert/Edit a collection</h1>
	<form:form action="save" method="post" modelAttribute="collection">
	<table>
      <form:hidden path="id"/>
      <tr>
      <td>Disease Term:</td>
      <td><form:input path="disease_term"/></td>
      </tr>
      
      <tr>
      <td>Title:</td>
      <td><form:input path="title"/></td>
      </tr>
      
      <tr>
      	<td colspan="2" align="center"><input type="submit" value="Save" /></td>
      </tr>
     </table>
	</form:form>
	</div>
</body>
</html>