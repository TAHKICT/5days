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
<div align="left">
  <a href="/">Главная</a>
</div>

<div align="center">
  <h2>Добавить книгу</h2>
  <form:form method="post" action="/changeBook" commandName="book">
    <table>
      <tr>
        <td>Author</td>
        <td><form:input path="author"/></td>
      </tr>
      <tr>
        <td>Title</td>
        <td><form:input path="title"/></td>
      </tr>
      <tr>
        <td>Genre</td>
        <td><form:input path="genre"/></td>
      </tr>
      <tr>
        <td>Price</td>
        <td><form:input path="price"/></td>
      </tr>
      <tr>
        <td>Description</td>
        <td><form:input path="description"/></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit"
                               value="Save" /></td>
      </tr>
  </form:form>
  </table>

</body>
</html>
