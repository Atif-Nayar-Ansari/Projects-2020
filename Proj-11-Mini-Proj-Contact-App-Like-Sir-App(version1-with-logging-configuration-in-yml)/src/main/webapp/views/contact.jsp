<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  
  <form:form action="save?sno=${cont.sno }" method="POST" modelAttribute="cont">
  							  <!--to update the existing object ${bindingobject.bindingVariablePK}-->
  <h1>CONTACT INFO</h1>
  <pre>                   
	
   
   <font color="green">${saveResult}</font>
   <font color="red">${notSaveResult}</font>
  Name  :<form:input path="name"/>
  Phone :<form:input path="phone"/>
  Email :<form:input path="email"/>
  <input type="reset" value="Reset"/>&nbsp;&nbsp;&nbsp;<input type="submit" value="Submit Contact"/>
  
  <a href="viewallcontact">view All Contacts</a>
  </pre>
  </form:form>	
