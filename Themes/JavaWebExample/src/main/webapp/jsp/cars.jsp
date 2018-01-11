<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Машины</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Модель</th>
        <th>Владельцы</th>
    </tr>
    <c:forEach items="${cars}" var="car">
        <tr>
            <td>${car.id}</td>
            <td>${car.model}</td>
            <td>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Citizen</th>
                        <th>Age</th>
                    </tr>
                    <c:forEach items="${car.owners}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.citizen}</td>
                            <td>${user.age}</td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
