<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="save?sno=${cont.sno}" method="POST" modelAttribute="cont">
<pre>
 ${saved}
 ${Notsaved}
 
 Name<form:input path="name"/>
 Phone<form:input path="phone"/>
 Email<form:input path="email"/>
 <input type="submit" value="Add Contact"> 
<pre>
<a href="show">Show All</a>
</form:form>
</body>
</html>