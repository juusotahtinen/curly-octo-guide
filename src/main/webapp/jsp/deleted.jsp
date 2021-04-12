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
   <div align="center">
	<center>
        <h1>Ehdokas poistettu</h1>
        <h2>
            <a href="/showcandidates">Näytä kaikki ehdokkaat</a>
        </h2>
        <h2>
        	<a href="/addcandidates">Lisää uusi ehdokas</a>
        </h2>
    </center>     
    </div>
</body>
</html>