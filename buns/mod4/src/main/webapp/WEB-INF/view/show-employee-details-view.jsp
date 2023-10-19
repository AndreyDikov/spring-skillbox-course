<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>

<body>
<style>
    .content {
        max-width: 500px;
        margin: auto;
    }
</style>

<div class="content">
    <h2>Личный кабинет работника</h2>
    <br><br>

    Имя: ${employee.name}
    <br><br>
    Фамилия: ${employee.surname}
    <br><br>
    Зарплата: ${employee.salary}
    <br><br>
    Департамент: ${employee.department}
    <br><br>
    Пол: ${employee.sex}
    <br><br>
    Знания и навыки:
    <ul>
        <c:forEach var="skill" items="${employee.skills}">
            <li>${skill}</li>
        </c:forEach>
    </ul>
    Номер телефона: ${employee.phoneNumber}
    <br><br>
    E-mail: ${employee.email}
</div>
</body>

</html>