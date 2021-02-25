<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style>
label
{
font-family: Verdana;
font-weight: bold;
}
</style>
<meta charset="ISO-8859-1">
<title>Add notes</title>

<%@include file="all_js_css.jsp"%>
</head>
<body>

	<div class="container text-center">
		<%@include file="navbar.jsp"%>
		<br>
		<h1>Please fill your detail</h1>

		<br>

		<form:form action="save" method="post" modelAttribute="listofrecords">
			<form:input type="text" path="id" cssClass="form-control" />
			<label for="title">Note Title</label>
			<form:input type="text" path="title" placeholder="enter text here" cssClass="form-control" />
	
	<div class="form-group">
		<label for="content">Note Content</label>
		<form:textarea id="content" path="content"
			placeholder="Enter the content" style="height: 200px;" cssClass="form-control"></form:textarea>
	</div>
	<div class="continer text-center">
		<button type="submit" class="btn btn-primary">Submit</button>

	</div>
	</form:form>
	</div>
	
</body>
</html>