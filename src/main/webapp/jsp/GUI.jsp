<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>  
 <%@ page import="data.Kysymykset" %>
 
   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

  <HEAD>
    <TITLE>Vaalikone</TITLE>
  </HEAD>

  <BODY>
  	<h1> VAALIKONE</h1>
  	<h2>Vastaa seuraaviin kysymyksiin niin saat tietää itsellesi parhaiten sopivan ehdokkaan</h2>
  	
  	<form NAME="vastaukset" ACTION="/vastaustenVertailu" METHOD="GET">
  		<% 
		ArrayList<Kysymykset> kysymykset = (ArrayList<Kysymykset>)request.getAttribute("kysymykset");

  		
  		for ( int i=0;i < kysymykset.size();i++){
  		
  		Kysymykset k=kysymykset.get(i);
  		out.println(k.getId() + ": " + k.getKysymys());
		%>
		<br>
		<br>
  		<input type = "radio" name = "radios<%out.println(i);%>" value = "r1"> Täysin eri mieltä
  		<input type = "radio" name = "radios<%out.println(i);%>" value = "r2"> Lähes eri mieltä
  		<input type = "radio" name = "radios<%out.println(i);%>" value = "r3"> En osaa sanoa
  		<input type = "radio" name = "radios<%out.println(i);%>" value = "r4"> Lähes samaa mieltä
  		<input type = "radio" name = "radios<%out.println(i);%>" value = "r5"> Täysin samaa mieltä
  		<br>
  		<br>
  		<hr>
  		<% 
  		
  		}
  		%>
  		<input type = "submit" value="lähetä" >

  		
  	</form>
  	
  	
    

  </BODY>
</HTML>