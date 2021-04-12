<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
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
            <a href="/addcandidates">Lisää uusi ehdokas</a>
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

			<c:forEach var="showToUpdate" items="${showToUpdate}" >
				<tr>
					<td>${showToUpdate.sukunimi}</td>
					<td>${showToUpdate.etunimi}</td>
					<td>${showToUpdate.puolue}</td>
				</tr>
			</c:forEach>
		</table>
		
</div>

</body>
</html>