<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="http://code.jquery.com/jquery-2.2.4.js" type="text/javascript">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker({
      changeMonth: true,
      changeYear: true,
	maxDate: 0
    });
  } );
  </script>
  
  <script>
function showStates(str) {
  var xhttp;  
  if (str == "") {
    document.getElementById("txtHint").innerHTML = "";
    return;
  }
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("demo").innerHTML = this.responseText;
    }
  };
  xhttp.open("GET", "localhost:8082/getAllStateDetails?countryId="+str, true);
  xhttp.send();
}
</script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Registration Page</h1>

	<form:form action="/activepage" method="post" modelAttribute="loadForm">
		<table>
			<tr>
				<th>User-Name:</th>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<th>User-LastName:</th>
				<td><form:input path="userLastName" /></td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><form:input path="userEmail" /></td>
			</tr>
			<tr>
				<th>Mobile:</th>
				<td><form:input path="userPhonenumber" /></td>
			</tr>
			<tr>
				<th>Date-Of-Birth:</th>
				<td><input type="text" id="datepicker"></td>
			</tr>
			<tr>
				<th>Gender:</th>
				<td>Male:<form:radiobutton path="Gender" value="Male" id="gender"/> 
				Female:<form:radiobutton path="Gender" value="female" id="gender"/> </td>
			</tr>
			<tr>
				<th>Country:</th>
				<td><select name="countrys" id="countrys" onchange="showStates(this.value)">
				<option value="">Select country</option>
					<option value="4">india</option>
					
				</select></td>
			</tr>
			<tr>
				<th>State:</th>
				<td><select name="states" id="states" onchange="showStates(this.value)">
				<option value="">Select State</option>
				<p id="demo"></p>
				</select></td>
			</tr>
			<tr>
				<th>City:</th>
				<td><select name="citys" id="citys" onchange="showCitys(this.value)">
				<option value="">Select a City</option>
				</select></td>
			</tr>
			
			<tr>
				<th></th>
				<td><input type="submit" value="Reset">&nbsp;<input type="submit" value="save"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>