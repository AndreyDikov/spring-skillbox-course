<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<body>

<style>
    body{
        font-family: Arial;
    }

    .content {
        max-width: 500px;
        margin: auto;
    }

    .table {
        width: 100%;
        border: none;
        margin-bottom: 20px;
    }
    .table thead th {
        font-weight: bold;
        text-align: left;
        border: none;
        padding: 10px 15px;
        background: #d8d8d8;
        font-size: 14px;
    }
    .table thead tr th:first-child {
        border-radius: 8px 0 0 8px;
    }
    .table thead tr th:last-child {
        border-radius: 0 8px 8px 0;
    }
    .table tbody td {
        text-align: left;
        border: none;
        padding: 10px 15px;
        font-size: 14px;
        vertical-align: top;
    }
    .table tbody tr:nth-child(even){
        background: #f3f3f3;
    }
    .table tbody tr td:first-child {
        border-radius: 8px 0 0 8px;
    }
    .table tbody tr td:last-child {
        border-radius: 0 8px 8px 0;
    }

    .button {
        float:left;
        margin-right:5px;
    }
</style>

<div class="content">
    <h2>Реестр сотрудников</h2>
    <br>

    <table class="table">
        <thead>
            <tr>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Департамент</th>
                <th>Зарплата</th>
                <th colspan="2">Операции</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="employee" items="${allEmployees}">
                <c:url var="updateButton" value="/updateInfo">
                    <c:param name="id" value="${employee.id}"/>
                </c:url>

                <c:url var="deleteButton" value="/deleteEmployee">
                    <c:param name="id" value="${employee.id}"/>
                </c:url>

                <tr>
                    <td>${employee.name}</td>
                    <td>${employee.surname}</td>
                    <td>${employee.department}</td>
                    <td>${employee.salary}</td>
                    <td>
                        <input class="button"
                               type="button"
                               value="Редактировать"
                               onclick="window.location.href='${updateButton}'"/>
                    </td>
                    <td>
                        <input class="button"
                               type="button"
                               value="Удалить"
                               onclick="window.location.href='${deleteButton}'"/>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <br>

    <input type="button"
           value="Добавить сотрудника"
           onclick="window.location.href='addNewEmployee'"/>
</div>

</body>
</html>
