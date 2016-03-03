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
  <a href="/">Main page</a>
</div>

<div align="center">
  <h2>Добавить книгу</h2>
  <form:form method="post" action="addBook" commandName="book">
    <table>
      <tr>
        <td>Автор</td>
        <td><form:input path="author"/></td>
      </tr>
      <tr>
        <td>Название</td>
        <td><form:input path="title"/></td>
      </tr>
      <tr>
        <td>Жанр</td>
        <td><form:input path="genre"/></td>
      </tr>
      <tr>
        <td>Цена</td>
        <td><form:input path="price"/></td>
      </tr>
      <tr>
        <td>Описание</td>
        <td><form:input path="description"/></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit"
                               value="Сохранить" /></td>
      </tr>
  </form:form>
    </table>

</div>
</body>
</html>
