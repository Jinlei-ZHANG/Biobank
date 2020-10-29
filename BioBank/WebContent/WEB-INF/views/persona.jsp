<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align = "center">
    
<h1>Hello!</h1>
	<form:form action="savepersona" method="post" modelAttribute="PA">
	<table>
	  <tr>
	  <td>id : 2</td>
      </tr>
      <tr>
      <td>Name:</td>
      <td><form:input path="name"/></td>
      </tr>
      <tr>
      <td>Age:</td>
      <td><form:input path="age"/></td>
      </tr>
      <tr>
      <td>Gender:</td>
      <td><form:input path="gerder"/></td>
      </tr>
      <tr>
      <td>Occupation:</td>
      <td><form:input path="occupation"/></td>
      </tr>
      <tr>
      <td>Computer_Literacy:</td>
      <td><form:input path="computer_literacy"/></td>
      </tr>
      <tr>
      <td>Hobbies:</td>
      <td><form:input path="hobbies"/></td>
      </tr>
      <tr>
      <td>Bio:</td>
      <td><form:input path="bio"/></td>
      </tr>
      
      <tr>
      	<td colspan="2" align="center"><input type="submit" value="Save" /></td>
      </tr>
     </table>
	</form:form>
</div>



</body>
</html>