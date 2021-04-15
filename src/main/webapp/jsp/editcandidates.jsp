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
<link rel="stylesheet" href="css/style.css">
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
	
	
	footer{
	width: 100%;
	position: static;
  	left: 0;
  	bottom: 0;
	background: transparent;
	color: #000000;
	}
	
	footer.ins{
	width: 100%;
	position: absolute;
  	left: 0;
  	bottom: 0;
	background: transparent;
	color: #000000;
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
	width: 70%;
	background-color: rgb(255, 255, 255);
    border-radius: 10px;
    position: relative;
    box-shadow: rgb(0 0 0 / 19%) 0px 2px 4px 0px;
	padding: 50px;
    text-align: center;
    margin-bottom: 200px;
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
	
	a.class1:link, a.class1:visited {
 	 background-color: transparent;
 	 color: black;
  	padding: 14px 25px;
  	text-align: center;
  	text-decoration: none;
 	 display: inline-block;
 	 text-align: center;
	}

	a:hover, a:active {
  	background-color: rgba(124, 198, 198, 0.4);
  	text-align: center;
  	border-radius: 10px;
    box-shadow: rgb(0 0 0 / 19%) 0px 2px 4px 0px;
	}
	
	a.class1:hover, a.class1:active {
  	background-color: rgba(255, 255, 255, 0.4);
  	text-align: center;
  	border-radius: 10px;
    box-shadow: rgb(0 0 0 / 19%) 0px 2px 4px 0px;
	}
	
</style>
</head>

<body>
<header>
	<h1>Muokkaa ehdokkaan tietoja</h1>
	<h3><a href = "${pageContext.request.contextPath}/showcandidates">Takaisin ehdokkaisiin</a></h3>
</header>
<div class="startbox">
 <table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<form action='/editcandidates1' method='get'>
					<h2><input type='hidden' name='ehdokas_id' value=<%=request.getParameter("ehdokas_id") %>><br></h2> 
						<h2>Ehdokkaan uusi sukunimi: <input type='text' name='sukunimi'><br></h2> 
						<h2>Ehdokkaan uusi etunimi: <input type='text' name='etunimi'><br></h2> 
						<h2>Ehdokkaan uusi puolue: <input type='text' name='puolue' ><br></h2> 
					<input type='submit' name='ok' value='Päivitä tiedot'> 
    			</form>
    		</tr>
    	</table>
</div>
<footer class="ins">
	<h2>Vaalikone by TeamTeam3.0</h2>
</footer>
</body>
</html>