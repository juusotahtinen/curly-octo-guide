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
        <h1>Lisää ehdokas</h1>
        <h2>
            <a href="/showcandidates">Näytä kaikki ehdokkaat</a>
        </h2>
    </center>
<div align="center">
        <form action='/inserted' method='post'>
			Ehdokkaan sukunimi: <input type='text' name='sukunimi' value='${requestScope.added.sukunimi}'><br> 
			Ehdokkaan etunimi: <input type='text' name='etunimi' value='${requestScope.added.etunimi}'><br>
			Ehdokkaan puolue: <input type='text' name='puolue' value='${requestScope.added.puolue}'><br>
			<input type='submit' name='ok' value='Send'> 
		</form>
    </div>
</body>
</html>