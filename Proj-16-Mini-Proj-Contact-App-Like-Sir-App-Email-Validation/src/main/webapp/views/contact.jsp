<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  
<html>
<head>
	<title>
	Email validation
	</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script><!--enable jquery -->
 <script type="text/javascript">

	$(document).ready(function(event){

		$("#email").blur(function(){
				$("#emailDuplicate").text("");// to clear the validation message 
				var emailId = $("#email").val();

				$.ajax({
						type: "GET",
						url: "validateEmail?email="+emailId,
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
</head>

<body>
 <form:form action="save?sno=${cont.sno }" method="POST" modelAttribute="cont">
   <h1>CONTACT INFO</h1>
   <pre>   
    <font color="green">${saveResult}</font>
    <font color="red">${notSaveResult}</font>
    <table>
    	<tr>
    		<td>Name :</td>
    		<td><form:input path="name"/></td>
    	</tr>
    	<tr>
    		<td>Email :</td>
    		<td><form:input path="email"/></td>
    		<td><font color="red"><span id="emailDuplicate"></span></font>
    	</tr>
    	<tr>
    		<td>Phone :</td>
    		<td><form:input path="phone"/></td>
    	</tr>
    </table>
    <input type="reset" value="Reset"/>&nbsp;&nbsp;&nbsp;<input type="submit" value="Submit Contact"/>
 	<a href="viewallcontact">view All Contacts</a>
   </pre>
 </form:form>
 </body>
 </html>
 
 
 
 
 
 
 
 
 
 
 