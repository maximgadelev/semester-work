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
<form action="<%=request.getContextPath()%>/register" method="post">
    Login:
    <input name="login" type="text"/>
    <br>
    Password:
    <input name="password" type="password">
    <br>
    Name:
    <input name="name" type="text">
    <br>
   Surname:
    <input name="surname" type="text">
    <br>
    <input type="submit" value="register">
</form>
</body>
</html>
