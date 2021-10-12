<#macro loginTemplate>
<form action="/login" method ="post">
        Login:
        <input name="login" type="text" maxlength="40" required/>
        <br>
        Password:
        <input name="password" type="password" maxlength="30" required>
        <br>
        <input type="submit" value="Log in">
</form>
</#macro>