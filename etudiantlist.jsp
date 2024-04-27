<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <table>
  <tr>
    <th>Nom</th>
    <th>Prénom</th>
    <th>Date de naisssance</th>
    <th>Email</th>
    <th>Télépone</th>
  </tr>
   <c:forEach items="${etudiants}" var="e">
      <tr>
        <td>
          <c:out value="${e.getNom()}"/>
        </td>
        <td>
          <c:out value="${e.getPrenom()}"/>
        </td>
        <td>
          <c:out value="${e.getDateNaissance()}"/>
        </td>
        <td>
          <c:out value="${e.getEmail()}"/>
        </td>
        <td>
          <c:out value="${e.getTelephone()}"/>
        </td>
      </tr>
   </c:forEach>
 </table>
</body>
</html>