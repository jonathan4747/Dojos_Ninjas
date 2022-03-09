<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New Dojo</title>
		<link rel="stylesheet" href="/css/dojo.css"/>
	</head>
	<body>
		<h1>
			New Dojo
		</h1>
		<form:form method="POST" action="/dojos/new" modelAttribute="dojo">
			<div>
				<form:label path="nombre" for="nombre">
					Name:
				</form:label>
				<form:input path="nombre" type="text" name="nombre" id="nombre" />
				<form:errors path="nombre"/>
			</div>
			<button type="submit">
				Create
			</button>
			
		</form:form>
		
	
	</body>
</html>