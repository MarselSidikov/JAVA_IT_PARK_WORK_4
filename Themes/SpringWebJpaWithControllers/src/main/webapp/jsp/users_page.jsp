<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<html>
<head>
    <title>Пользователи</title>
    <meta charset="UTF-8"/>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Citizen</th>
        <th>Age</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.citizen}</td>
            <td>${user.age}</td>
            <td><a href="/users/for_delete?id=${user.id}">Удалить</a></td>
        </tr>
    </c:forEach>
</table>

<form action="/users" method="post">
    <input type="text" placeholder="Имя" name="name">
    <input type="text" placeholder="Гражданство" name="citizen">
    <input type="text" placeholder="Возраст" name="age">
    <input type="submit">
</form>

</body>
</html>
