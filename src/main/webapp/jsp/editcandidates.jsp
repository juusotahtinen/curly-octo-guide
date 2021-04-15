<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.Candidates" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>muokkaa kandeja</title>
</head>
<body>
<h3><a href = "${pageContext.request.contextPath}/showcandidates">Takaisin ehdokkaisiin</a></h3>

<h2>Muokkaa KANDIiDAAttirejja</h2>
<form action='/editcandidates1' method='get'>
Candidates ehdokas_id: <input type='text' name='ehdokas_id' value=<%=request.getParameter("ehdokas_id") %>><br> 
Candidates sukunimi: <input type='text' name='sukunimi' ><br> 
Candidates etunimi: <input type='text' name='etunimi' ><br> 
Candidates puolue: <input type='text' name='puolue' ><br> 

<input type='submit' name='ok' value='Send'> 
</form>
</body>
</html>