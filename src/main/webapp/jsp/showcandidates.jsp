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
<style>
	body{
	height: 100%;
	background-image: linear-gradient(rgba(124, 198, 198, 0.9), rgba(124, 198, 198, 0.47), rgba(124, 198, 198, 0));
	background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
	}

	header{
	width: 100%;
	margin: auto;
	background: transparent;
	color: #000000;
	padding: 70px;
	}
	
	article{
	width: 100%;
	margin: auto;
	background: transparent;
	color: #000000;
	}
	
	footer{
	width: 100%;
	position: static;
  	left: 0;
  	bottom: 0;
	background: transparent;
	color: #000000;
	}
	
	img {
    display: block;
    margin-left: auto;
    margin-right: auto;
   

	}
	
	h1 {
	 font-family: Roboto, sans-serif;
 	 text-align: center;
 	 font-size: 30px;
	}
	
	h2 {
	 font-family: Roboto, sans-serif;
 	 text-align: center;
 	 font-size: 16px;
	}
	
	h3{
	 font-family: Roboto, sans-serif;
 	 text-align: center;
 	 font-size: 24px;
	}
	
	p {
  	font-family: verdana;
 	 font-size: 20px;
	}
	
	.startbox{
	margin: auto;
	width: 90%;
	background-color: rgb(255, 255, 255);
    border-radius: 10px;
    position: relative;
    box-shadow: rgb(0 0 0 / 19%) 0px 2px 4px 0px;
	padding: 50px;
    text-align: center;
    margin-bottom: 200px;
	}
	
	.adminbox{
	margin: auto;
	width: 50%;
    border: 3px solid black;
	height:30%;
	padding:10px;
	background: rgba(124, 198, 198, 0.47);
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
	
	a:link, a:visited {
 	 background-color: transparent;
 	 color: black;
  	padding: 14px 25px;
  	text-align: center;
  	text-decoration: none;
 	 display: inline-block;
 	 text-align: center;
	}

	a:hover, a:active {
  	background-color: rgb(255, 255, 255, 0.3);
  	text-align: center;
  	border-radius: 10px;
    box-shadow: rgb(0 0 0 / 19%) 0px 2px 4px 0px;
	}

</style>

</head>
<body>
	<header>
        <h1>Ehdokasluettelo</h1>
        <h2>
            <a href="/addcandidates">Lisää uusi ehdokas </a>
        </h2>
    </header>
<div class="startbox">
		
	
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
<footer>
	<h2>Vaalikone by TeamTeam3.0</h2>
</footer> 

</body>
</html>