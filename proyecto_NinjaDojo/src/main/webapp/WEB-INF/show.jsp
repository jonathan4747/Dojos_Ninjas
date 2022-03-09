<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Dojo page</title>
		<link rel="stylesheet" href="/css/show.css"/>
	</head>
	<body>
		<h1><c:out value="${nombre}"/> Ninjas</h1>
		<div class="tabla">
			<table>
				<thead>
					<tr>
			            <th>First Name</th>
			            <th>Last Name</th>
			            <th>Age</th>
			        </tr>
				</thead>
				
				<tbody>
					<c:forEach  var="objetos" items="${reglones}">	
						<tr>
							<c:forEach  var="lista" items="${objetos}">
								
									<th> <c:out value="${lista}"/></th>
									
							</c:forEach>
						</tr>						
					</c:forEach>
				</tbody>
			</table>
		</div>			
	</body>
</html>