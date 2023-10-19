<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    .error, .obligatory-field {
        color: red;
    }
</style>

<div class="content">
    <h3>Добро пожаловать, работник! Расскажите нам о себе:</h3>
    <span class="obligatory-field">*</span> - обязательное поле
    <br><br>

    <form:form action="showDetails" modelAttribute="employee">
        <form:input path="name"/> Имя<span class="obligatory-field">*</span>
        <div class="error">
            <form:errors path="name"/>
        </div>
        <br>

        <form:input path="surname"/> Фамилия<span class="obligatory-field">*</span>
        <div class="error">
            <form:errors path="surname"/>
        </div>
        <br>

        <form:input path="salary"/> Зарплата<span class="obligatory-field">*</span>
        <div class="error">
            <form:errors path="salary"/>
        </div>
        <br>

        <form:select path="department">
            <form:options items="${employee.departments}"/>
        </form:select> Департамент<span class="obligatory-field">*</span>
        <br><br>

        Пол:
        <form:radiobuttons path="sex" items="${employee.genders}"/>
        <br><br>

        Знания и навыки:<br>
        <ul>
            <c:forEach var="skill" items="${employee.skillsAsList}">
                <form:checkbox path="skills" value="${skill}"/>${skill}<br>
            </c:forEach>
        </ul>

        <form:input path="phoneNumber"/> Номер телефона<span class="obligatory-field">*</span>
        <div class="error">
            <form:errors path="phoneNumber"/>
        </div>
        <br>

        <form:input path="email"/> E-mail<span class="obligatory-field">*</span>
        <div class="error">
            <form:errors path="email"/>
        </div>
        <br>

        <input type="submit" value="ок">
    </form:form>
</div>
</body>

</html>