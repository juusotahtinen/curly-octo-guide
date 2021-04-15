<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>  
 <%@ page import="data.Kysymykset" %>
 
   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
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
	
	.questionbox{
	margin: auto;
	width: 70%;
	background-color: rgba(124, 198, 198, 0.2);
    border-radius: 10px;
    position: relative;
    box-shadow: rgb(0 0 0 / 19%) 0px 2px 4px 0px;
	padding: 20px;
    text-align: center;
    margin-bottom: 20px;
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
  <HEAD>
    <TITLE>Vaalikone</TITLE>
  </HEAD>

  <BODY>
  <header>
  	<h1> VAALIKONE</h1>
  	<h2>Vastaa seuraaviin kysymyksiin niin saat tietää itsellesi parhaiten sopivan ehdokkaan</h2>
  </header>




<div class="startbox">
  <div class="col-sm-12">
  	<form NAME="vastaukset" ACTION="/vastaustenVertailu" METHOD="POST">
  		<fieldset>
  		<% 
		ArrayList<Kysymykset> kysymykset = (ArrayList<Kysymykset>)request.getAttribute("kysymykset");
		
  		for ( int i=0;i < kysymykset.size();i++){
  		
  		Kysymykset k=kysymykset.get(i);
  		%>
  	<div class="questionbox">
  		<h3><% out.println(k.getId()+"/"+kysymykset.size()); %></h3>
  		<h4><% out.println(k.getKysymys());%></h4>
	</div>	
		<div class="row justify-content-md-center">
		<div class="col-md-2">
  		<label> Täysin eri mieltä</label>
  		</div>
  		<div class="col-md-2">
  		<label>En osaa sanoa</label>
  		</div>
  		<div class="col-md-2">
  		<label>Täysin samaa mieltä</label>
  		</div>
  		</div>
  		<div class="row justify-content-md-center">
		<div class="col-sm-1">
  		<input class="form-check-input" type = "radio" name = "radios<%=i%>" value = "1">
  		</div>
  		<div class="col-sm-1">
  		<input class="form-check-input" type = "radio" name = "radios<%=i%>" value = "2">
  		</div>
  		<div class="col-sm-1">
  		<input class="form-check-input" type = "radio" name = "radios<%=i%>" value = "3">
  		</div>
  		<div class="col-sm-1">
  		<input class="form-check-input" type = "radio" name = "radios<%=i%>" value = "4"> 
  		</div>
  		<div class="col-sm-1">
  		<input class="form-check-input" type = "radio" name = "radios<%=i%>" value = "5"> 
  		</div>

  		<br>
  		<br>


		</div>
  		<% 
		 
		
  		}

  		%>
  		<br>
  		<input type = "submit" value="Lähetä vastauksesi" >
	</fieldset>	
  	</form>
	</div>
	</div>
  	</div>
    


  </BODY>
</HTML>