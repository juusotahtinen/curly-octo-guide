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
        <h1>Ehdokkaan tiedot</h1>

    </center>
<div class = "container">
		
	
	
		
		
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>Sukunimi</th>
				<th>Etunimi</th>
				<th>Puolue</th>
				<th>Ikä</th>
				<th>Ammatti</th>
				<th>Kotipaikkakunta</th>
			</tr>

			<c:forEach var="ehdokas" items="${requestScope.ehdokas}" >
				<tr>
					<td>${ehdokas.sukunimi}</td>
					<td>${ehdokas.etunimi}</td>
					<td>${ehdokas.puolue}</td>
					<td>${ehdokas.ika}</td>
					<td>${ehdokas.ammatti}</td>
					<td>${ehdokas.kotipaikkakunta}</td>
					<td> 

					</td>
				</tr>
			</c:forEach>
		</table>
		
</div>
<div class="myDiv">
  <h2>Miksi minut pitäisi valita eduskuntaan</h2>
  <c:forEach var="ehdokas" items="${requestScope.ehdokas}" >
				<tr>

					
					<td>${ehdokas.miksi_eduskuntaan}</td>
					<td> 

					</td>
				</tr>
			</c:forEach>
</div>
</body>
</html>