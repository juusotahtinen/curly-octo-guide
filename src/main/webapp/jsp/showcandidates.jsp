<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Candidates" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
<div class = "container">
		
	<h1>Ehdokasluettelo</h1>
	<hr/>
		
	<p>${NOTIFICATION}</p>
		
		
	
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>Sukunimi</th>
				<th>Etunimi</th>
				<th>Puolue</th>
				<th>Toiminnot</th>
			</tr>

			<c:forEach var="candidates" items="${requestScope.candidatesList}" >
			<tr>
					<td>${candidates.sukunimi}</td>
					<td>${candidates.etunimi}</td>
					<td>${candidates.puolue}</td>
					<td> 
					<a href = "${pageContext.request.contextPath}/ShowCandidates?action=EDIT&id=${candidates.ehdokas_id}">Edit</a> 
					| 
					<a href = "${pageContext.request.contextPath}/ShowCandidates?action=DELETE&id=${candidates.ehdokas_id}">Delete</a> 
					</td>
				</tr>
			</c:forEach>
		</table>
		
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>