<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><html>
<html>
<head>
    <title></title>
</head>
<body>
<div align="left">
    <a href="/">Main page</a>
</div>
<div align="center">
    <h2>Перечень книг</h2>
    <table border="1px">
        <tr>
            <th>Author</th>
            <th>Title</th>
            <th>Genre</th>
            <th>Perice</th>
            <th>Publish date</th>
            <th>Description</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
        </tr>
        <c:if test="${!empty bookList}">
            <c:forEach items="${bookList}" var="book">
                <tr>
                    <td>${book.author}</td>
                    <td>${book.title}</td>
                    <td>${book.genre}</td>
                    <td>${book.price}</td>
                    <td>${book.publishDate}</td>
                    <td>${book.description}</td>
                    <td><a href="/book/${book.id}">edit</a></td>
                    <td><a href="/book/remove/${book.id}">remove</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>
</body>
</html>
