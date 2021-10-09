<%--
  Created by IntelliJ IDEA.
  User: Максим
  Date: 07.10.2021
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/registration" method="post">
    Login:
    <input name="login" type="text" autocomplete="off" minlength="6" maxlength="40" required/>
    <br>
    Password:
    <input name="password" type="password" autocomplete="off" minlength="6" maxlength="30" required>
    <br>
    Name:
    <input name="name" type="text" autocomplete="off" minlength="2" maxlength="30" required>
    <br>
   Surname:
    <input name="surname" type="text" autocomplete="off" minlength="2" maxlength="30" required>
    <br>
    <input type="submit" value="register">
</form>
</body>
</html>
