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
        <c:if test="${candidates != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${candidates == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                
            </caption>
                <c:if test="${candidates != null}">
                    <input type="hidden" name="ehdokas_id" value="<c:out value='${candidates.ehdokas_id}' />" />
                </c:if>           
            <tr>
                <th>Sukunimi: </th>
                <td>
                    <input type="text" name="sukunimi" size="45"
                            value="<c:out value='${candidates.sukunimi}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Etunimi: </th>
                <td>
                    <input type="text" name="etunimi" size="45"
                            value="<c:out value='${candidates.etunimi}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Puolue: </th>
                <td>
                    <input type="text" name="puolue" size="5"
                            value="<c:out value='${candidates.puolue}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Tallenna" />
                </td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>