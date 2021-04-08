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
		
		
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>Sukunimi</th>
				<th>Etunimi</th>
				<th>Puolue</th>
				<th>Toiminnot</th>
			</tr>

			<c:forEach var="listCandidates" items="${listCandidates}" >
			<tr>
					<td>${listCandidates.sukunimi}</td>
					<td>${listCandidates.etunimi}</td>
					<td>${listCandidates.puolue}</td>
					<td> 
					<a href = "${pageContext.request.contextPath}/ShowCandidates?action=EDIT&id=${listCandidates.ehdokas_id}">Muokkaa</a> 
					| 
					<a href = "${pageContext.request.contextPath}/ShowCandidates?action=DELETE&id=${listCandidates.ehdokas_id}">Poista</a> 
					</td>
				</tr>
			</c:forEach>
		</table>
		
</div>

</body>
</html>