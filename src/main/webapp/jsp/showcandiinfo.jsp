<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.Candidates" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<style>
h2 {
  text-align: center;
}
p {
  font-family: verdana;
  font-size: 20px;
}

.center_div {
  border: 1px solid gray;
  margin-left: auto;
  margin-right: auto;
  width: 90%;
  background-color: #d0f0f6;
  text-align: left;
  padding-top: 50px;
  padding-right: 30px;
  padding-bottom: 50px;
  padding-left: 80px;
}
h3{
 position: fixed;
 bottom: 0;
 width: 100%
 padding: 0px 10px 10px 0px;
}
a:link, a:visited {
  background-color: #B0E0E6;
  color: white;
  padding: 14px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: #87CEEB;
}






</style>
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
				</tr>
			</c:forEach>
		</table>
		
</div>
<div class="center_div">
  <h2 style="border: 2px solid DodgerBlue;">Miksi minut pitäisi valita eduskuntaan</h2>
  <c:forEach var="ehdokas" items="${requestScope.ehdokas}" >
				<tr>

					
					<p>- ${ehdokas.miksi_eduskuntaan}</p>
<h2 style="border: 2px solid DodgerBlue;">Mitä asioita haluan edistää</h2>
					<p>- ${ehdokas.mita_asioita_haluat_edistaa}</p>

					</td>
				</tr>
				
			</c:forEach>
</div>
<div id="header">
<h3><a href = "${pageContext.request.contextPath}/showcandidates">Takaisin ehdokkaisiin</a></h3>
</div>
</body>
</html>