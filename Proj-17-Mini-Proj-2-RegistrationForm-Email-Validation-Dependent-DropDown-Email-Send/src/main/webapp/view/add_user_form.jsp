<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

<!--to inspect click ctrl+shift+i when u r in browser to check the ajax-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script><!--needed for ajax-->
<script type="text/javascript" >
$(document).ready(function(event){ 
	//for the State dropdown
	 $("#countryId").change(function(){
		 $("#stateId").find("option").remove();//to clear
		 $("<option>").val("").text("-select-").appendTo("#stateId");//to clear

		 $("#cityId").find("option").remove();//to clear
		 $("<option>").val("").text("-select-").appendTo("#cityId");//to clear

		var countryId = $("#countryId").val();
		$.ajax({

				type: "GET",
				url : "getStates?cid="+countryId,
				success: function(data){

							$.each(data, function(key, value){
								$("<option>").val(key).text(value).appendTo("#stateId");
							});
				}
		  }); 
	});
     //for the city dropdown
	$("#stateId").change(function(){
		 $("#cityId").find("option").remove();
		 $("<option>").val("").text("-select-").appendTo("#cityId");
		  var stateId = $("#stateId").val();
		$.ajax({

				type: "GET",
				url : "getCities?sid="+stateId,
				success: function(data){

							$.each(data, function(key, value){
								$("<option>").val(key).text(value).appendTo("#cityId");
							});
				}
		  }); 
		});	
	//for the email validation
	$("#email").blur(function(event){
		$("#emailDuplicate").text("");
		var emailId = $("#email").val();

		$.ajax({
			type: "GET",
			url: "emailValidation?email="+emailId,
			success: function(zz){

				if(zz=="DUPLICATE"){
					$("#emailDuplicate").text("Email already existed..");
					$("#email").focus();
					}
				}	
		  });
	  });
  });
</script>

<title>User Registration From</title>
</head>
<body>

	<h1>Registration Page</h1>

	<form:form action="saveAll" method="post" modelAttribute="userAcc">
		<table>
			<tr>
				<th>First Name:</th>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<th>Last Name:</th>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><form:input path="email" /></td>
				<td><font color="red"><span id="emailDuplicate"></span></font></td>
			</tr>
			<tr>
				<th>Mobile:</th>
				<td><form:input path="mobile" /></td>
			</tr>
			<tr>
				<th>DOB:</th>
				<td><form:input type="text" path="dob"/></td>
			</tr>
			<tr>
				<th>Gender:</th>
				<td>Male:<form:radiobutton path="gender" value="M" id="gen"/> 
				    Female:<form:radiobutton path="gender" value="F" id="gen"/> 
				</td>
			</tr>


			<!--for country-->
			<tr>
				<th>Country:</th>
				<td>
				 <form:select path="countryId">
				    	<form:option value=" ">-select-</form:option> 
				    	<form:options items="${countryMap}"></form:options> 
				 </form:select>
				</td>     
			</tr>	
			
			<!--for states-->
			<tr>
				<th>State:</th>
				<td>
				 <form:select path="stateId">
				    	<form:option value="">-select-</form:option> 
				 </form:select>
				</td> 
			</tr>	
			
			<!--for cities-->
			<tr>
				<th>Cities:</th>
				<td>
				 <form:select path="cityId">
				    	<form:option value="">-select-</form:option> 
				 </form:select>
				</td> 
			</tr>	



			<tr>
				<th></th>
				<td><input type="submit" value="Reset">&nbsp;<input type="submit" value="Save"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>