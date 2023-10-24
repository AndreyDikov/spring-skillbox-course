<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!Doctype html>
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

  .form-input {
    font-size: 15px;
    width: 300px;
    border-radius: 10px;
    padding: 10px;
    border: 1px solid #ccc;
  }

  .error {
    color: red;
  }
</style>

<div class="content">
  <h2>Информация о сотруднике</h2>
  <br>

  <form:form action="saveEmployee" modelAttribute="employee">
    <form:hidden path="id"/>
    <form:input class="form-input"
                path="name"
                placeholder=" Имя"/>
    <div class="error">
      <form:errors path="name"/>
    </div>
    <br>

    <form:input class="form-input"
                path="surname"
                placeholder=" Фамилия"/>
    <div class="error">
      <form:errors path="surname"/>
    </div>
    <br>

    <form:input class="form-input"
                path="department"
                placeholder=" Департамент"/>
    <div class="error">
      <form:errors path="department"/>
    </div>
    <br>

    <form:input class="form-input"
                path="salary"
                placeholder=" Зарплата"/>
    <div class="error">
      <form:errors path="salary"/>
    </div>
    <br>

    <input type="submit" value="Сохранить">
  </form:form>
</div>

</body>
</html>
