<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
function confirmDelete(){
	return confirm("Are you sure want to delete..")
}

</script>
<center>All Contacts</center>
<center><a href="loadFirstPage">+Add New Contact</a></center>
<center><table border="1">
  <tr>
    <th>SNO</th>
    <th>NAME</th>
    <th>EMAIL</th>
    <th>PHONE</th>
    <th>ACTION</th>
  </tr>
  <c:forEach items="${showAll}" var="ob">
  <tr>
    <td>${ob.sno }</td>
    <td>${ob.name}</td>
    <td>${ob.email}</td>
    <td>${ob.phone}</td>
    <td><a href="edit?sno=${ob.sno}">EDIT</a> <a href="delete?deleteThis=${ob.sno}" onclick="return confirmDelete()">DELETE</a></td>
  </tr>
    
  </c:forEach>
</table>
${deleted}
</center>






















