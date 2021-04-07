<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
  
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone</title>




</head>
<body>
    <center>
        <h1>Hallitse ehdokkaita</h1>
        <h2>
            <a href="/new">Lisää uusi ehdokas</a>


             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista ehdokkaista</h2></caption>
            <tr>
                <th>ID</th>
                <th>Sukunimi</th>
                <th>Etunimi</th>
                <th>Puolue</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="candidate" items="${candidatelist}">
                <tr>
                    <td><c:out value="${candidate.id}" /></td>
                    <td><c:out value="${candidate.lastname}" /></td>
                    <td><c:out value="${candidate.firstname}" /></td>
                    <td><c:out value="${candidate.party}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${candidate.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${candidate.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>