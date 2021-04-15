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
	
	.addbox{
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
      <h1>Syötä ehdokkaan tiedot</h1>
        <h2>
            <a href='/showcandidates' class="class1">Listaa kaikki ehdokkaat</a>
        </h2>
</header>

<div class="addbox">

  <div class="container">
    <div class="row">
     
      <div class="col-lg-12" align="center">
        <div class="card shadow-sm">
          
     
          <div class="card-body pt-0"><form action='/inserted' method='post'>
            <table class="table table-bordered">
              <tr align="center">
                <th align="center" width="50%" height="30px">Sukunimi</th>
                <td width="2%">:</td>
                <td align="center">
				<input type='text' name='sukunimi' value='${requestScope.added.sukunimi}'><br></td>
			 </tr>
           </table>
          </div>
          
          <div class="card-body pt-0">
            <table class="table table-bordered">
              <tr align="center">
                <th align="center" width="50%" height="30px">Etunimi</th>
                <td width="2%">:</td>
                <td align="center">
				<input type='text' name='etunimi' value='${requestScope.added.etunimi}'><br></td>
			</tr>
           </table>
          </div>
          
          <div class="card-body pt-0">
            <table class="table table-bordered">
              <tr align="center">
                <th align="center" width="50%" height="30px">Puolue</th>
                <td width="2%">:</td>
                <td align="center">
				<input type='text' name='puolue' value='${requestScope.added.puolue}'><br></td>
			</tr>
           </table>
          </div>
          
          <div class="card-body pt-0">
            <table class="table table-bordered">
              <tr align="center">
                <th align="center" width="50%" height="30px">Kotipaikkakunta</th>
                <td width="2%">:</td>
                <td align="center">
				<input type='text' name='kotipaikkakunta' value='${requestScope.added.kotipaikkakunta}'><br></td>
			</tr>
           </table>
          </div>
          
          <div class="card-body pt-0">
            <table class="table table-bordered">
              <tr align="center">
                <th align="center" width="50%" height="30px">Ikä</th>
                <td width="2%">:</td>
                <td align="center">
				<input type='text' name='ika' value='${requestScope.added.ika}'><br></td>
			</tr>
           </table>
          </div>
          
          <div class="card-body pt-0">
            <table class="table table-bordered">
              <tr align="center">
                <th align="center" width="50%" height="30px">Miksi haluat eduskuntaan</th>
                <td width="2%">:</td>
                <td align="center">
				<textarea rows="10" cols="40" input type='text' name='miksi_eduskuntaan' value='${requestScope.added.miksi_eduskuntaan}'></textarea>
			</tr>
           </table>
          </div>
          
          <div class="card-body pt-0">
            <table class="table table-bordered">
              <tr align="center">
                <th align="center" width="50%" height="30px">Mitä asioita haluat edistää</th>
                <td width="2%">:</td>
                <td align="center" height="300px">
                <textarea rows="10" cols="40" input type='text' name='mita_asioita_haluat_edistaa' value='${requestScope.added.mita_asioita_haluat_edistaa}'></textarea>	
			</tr>
           </table>
          </div>
          
          <div class="card-body pt-0">
            <table class="table table-bordered">
              <tr align="center">
                <th align="center" width="50%" height="30px">Ammatti</th>
                <td width="2%">:</td>
                <td align="center">
				<input type='text' name='ammatti' value='${requestScope.added.ammatti}'><br></td>
			</tr>
           </table>
          </div>
          
          <div class="card-body pt-0">
            <table class="table table-bordered">
              <tr align="center">


                <td align="center">
				<input type='submit' name='ok' value='Send'> 
			</tr>
           </table>
          </div>
         </tr>
           </table>
          </div>
        </div> 
         </form>
    </div>
    </div>
    </div>
<footer>
	<h2>Vaalikone by TeamTeam3.0</h2>
</footer>              
              
   
</body>
</html>