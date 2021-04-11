<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>  
 <%@ page import="data.Kysymykset" %>
 
   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">
  <HEAD>
    <TITLE>Vaalikone</TITLE>
  </HEAD>

  <BODY>
  <div class="container">

  	<center><h1> VAALIKONE</h1></center>
  	<h2>Vastaa seuraaviin kysymyksiin niin saat tietää itsellesi parhaiten sopivan ehdokkaan</h2>




  <div class="row">
  <div class="col-sm-12">
  	<form NAME="vastaukset" ACTION="/vastaustenVertailu" METHOD="POST">
  		<% 
		ArrayList<Kysymykset> kysymykset = (ArrayList<Kysymykset>)request.getAttribute("kysymykset");
		
  		for ( int i=0;i < kysymykset.size();i++){
  		
  		Kysymykset k=kysymykset.get(i);
  		%>
  		<h3><% out.println(k.getId() + ": " + k.getKysymys());%></h3>
  		<div class="row">
  		<div class="col-sm-2">
		<label>Täysin eri mieltä </label> 
  		<input id="option1" type = "radio" name = "radios<%=i%>" value = "1">
  		</div>
  		<div class="col-sm-2">
  		<label>Täysin eri mieltä </label> 
  		<input id="option2" type = "radio" name = "radios<%=i%>" value = "2">
  		</div>
  		<div class="col-sm-2">
  		<label>Täysin eri mieltä </label> 
  		<input id="oprion3" type = "radio" name = "radios<%=i%>" value = "3">
  		</div>
  		<div class="col-sm-2">
  		<label>Täysin eri mieltä </label> 
  		<input id="option4" type = "radio" name = "radios<%=i%>" value = "4"> 
  		</div>
  		<div class="col-sm-2">
  		<label>Täysin eri mieltä </label> 
  		<input id="option5" type = "radio" name = "radios<%=i%>" value = "5"> 
  		</div>

  		<br>
  		<br>
  		</div>
  		<% 
  		
  		}

  		%>
  		
  		<input type = "submit" value="lähetä" >

  	</form>
  	</div>
  	</div>
  	</div>
    
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>  

  </BODY>
</HTML>