<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
</head>
<body>
<div align="center">
  <c:if test="${bookExisting == true}">
    <p><h2><a href="/books">Список книг</a></h2></p>
  </c:if>
  <p><h2><a href="/book/new">Добавить книгу</a></h2></p>
</div>
</body>
</html>
