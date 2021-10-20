
<#ftl encoding='UTF-8'>
<#macro loginTemplate>
        <head>
<form action="/login" method ="post">
        Логин:
        <input name="login" type="text" maxlength="40" required/>
        <br>
        Пароль:
        <input name="password" type="password" maxlength="30" required>
        <br>
        <input type="submit" value="Войти">
</form>
<style>
        body{
            background-image: url("/static/img/family-carpool-vector-illustration.jpg");
            background-size: 100%;
        }

</style>
</#macro>