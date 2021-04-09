<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>  

 
   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

  <HEAD>
    <TITLE>Vaalikone</TITLE>
  </HEAD>

  <BODY>
  	
  	<p><% response.getWriter().println(request.getParameter("vastaus")); %>   </p>
  	
    

  </BODY>
</HTML>