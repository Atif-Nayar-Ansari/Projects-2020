<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="show" method="GET">
<pre>
<a href="loadFirstPage">Add More</a>
<table border="1">
<tr>
    <th>SNO</th>
    <th>NAME</th>
    <th>PHONE</th>
    <th>EMAIL</th>
    <th>ACTION</th>
 </tr>
 
 <c:forEach var="obj" items="${list}">
 
 <tr>
    <td>${obj.sno}</td>
    <td>${obj.name}</td>
    <td>${obj.phone}</td>
    <td>${obj.email}</td>
    <td><a href="edit?sno=${obj.sno}">Update</a>&nbsp;&nbsp;&nbsp;<a href="delete?id=${obj.sno}">Delete</a></td>
</tr>       
  </c:forEach>     
</table>
${delete }
${notdelete }
</pre>
</form>
</body>
</html>