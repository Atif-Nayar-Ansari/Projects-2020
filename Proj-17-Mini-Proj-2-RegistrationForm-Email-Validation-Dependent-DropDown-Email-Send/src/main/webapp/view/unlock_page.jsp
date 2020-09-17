<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

   <form:form action="/finalLogin?email=${emailId}" method="POST"  modelAttribute="xx">
	<table>
		<tr>
			<th>Email ID:</th>
			<td>${emailId}</td>
			<%-- <form:label path="emailId"></form:label> --%>
		</tr>
		<tr>
		    <td>Temp Password:</td>
		    <td><form:input path="tempPass"/></td>
		    <td><font color="red">${invalid}</font></td>
		</tr>
		<tr>
		    <td>New Password:</td>
		    <td><form:input path="newPass"/></td>
		</tr>
		<tr>
		    <td>Confirm Password:</td>
		    <td><form:input path="confirmPass"/></td>
		    <td><font color="red">${same}</font></td>
		</tr>
		
		
		<tr>
		    <td><input type="submit" value="Create Account" id="btn1"></td>
		</tr>
	</table>
	</form:form>
</body>
</html>