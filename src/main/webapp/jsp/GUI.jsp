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
  		<fieldset>
  		<% 
		ArrayList<Kysymykset> kysymykset = (ArrayList<Kysymykset>)request.getAttribute("kysymykset");
		
  		for ( int i=0;i < kysymykset.size();i++){
  		
  		Kysymykset k=kysymykset.get(i);
  		%>
  		<h3><% out.println(k.getId()+"/"+kysymykset.size()); %></h3>
  		<h4><% out.println(k.getKysymys());%></h4>
		
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