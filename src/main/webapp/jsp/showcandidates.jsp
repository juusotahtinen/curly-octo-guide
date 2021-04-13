<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.Candidates" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vaalikone</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">


</head>
<body>
	<center>
        <h1>Ehdokasluettelo</h1>
        <h2>
            <a href="/addcandidates">Lisää uusi ehdokas </a>
        </h2>
    </center>
<div class = "container">
		
	
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
					<a href = "${pageContext.request.contextPath}/showcandiinfo1?ehdokas_id=${listCandidates.ehdokas_id}">Näytä tiedot</a>
					| 
 					<a href = "${pageContext.request.contextPath}/deletecandiinfo1?ehdokas_id=${listCandidates.ehdokas_id}">Poista</a> 
					</td>
				</tr>
			</c:forEach>
		</table>
		
</div>

</body>
</html>