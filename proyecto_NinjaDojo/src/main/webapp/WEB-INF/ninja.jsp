<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New Ninja</title>
		<link rel="stylesheet" href="/css/ninja.css"/>
	</head>
	<body>
		<h1>
			New Ninja
		</h1>
		<div class="registro">
			<form:form method="POST" action="/ninjas/new" modelAttribute="ninja">
				<div>
					<form:label path="dojo" for="dojo">
						Dojo:
					</form:label>
					<form:select path="dojo" name="dojo" id="dojo" >
						<c:forEach var="dojo" items="${dojos}">
							<option value="${dojo.getId()}"> <c:out value="${dojo.getNombre() }"/></option>
						</c:forEach>
					</form:select>
					<form:errors path="dojo"/>
				</div>
				<div>
					<form:label path="nombre" for="nombre">
						First Name:
					</form:label>
					<form:input path="nombre" type="text" name="nombre" id="nombre" />
					<form:errors path="nombre"/>
				</div>
				<div>
					<form:label path="apellido" for="apellido">
						Last Name:
					</form:label>
					<form:input path="apellido" type="text" name="apellido" id="apellido" />
					<form:errors path="apellido"/>
				</div>
				<div>
					<form:label path="edad" for="edad">
						Age:
					</form:label>
					<form:input path="edad" type="number" name="edad" id="edad" min="18" value="null" />
					<form:errors path="edad"/>
				</div>
				<button type="submit">
					Create
				</button>
		</form:form>
		</div>
	</body>
</html>