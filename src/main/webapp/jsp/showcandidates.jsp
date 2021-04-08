<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Candidates" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Fish application</title>

		<link rel="stylesheet" type="text/css" href="mycssfilesomewhere.css">
		<script src="myscriptfile.js"></script>

	</head>
<body>
	<h2>Fish application</h2>
		<ol>
		<c:forEach var="fish" items="${requestScope.fishlist}" >
		<li>${fish.id}: ${fish.breed} <a href='/delete?id=${fish.id}'>delete</a> <a href='/readtoupdate?id=${fish.id}'>update</a>
		</c:forEach>
		</ol>

		<%
			ArrayList<Candidates> candidatesList=(ArrayList<Candidates>)request.getAttribute("candidatesList");

			for (int i=0;candidatesList!=null && i<candidatesList.size();i++){
			Candidates f=candidatesList.get(i);
			out.println(f.getEhdokas_id()+": "+f.getSukunimi()+"<a href='/delete?id="+f.getEhdokas_id()+"'>delete</a> <a href='/readtoupdate?id="+f.getEhdokas_id()+"'>update</a>");
			}
		%>





</body>
</html>