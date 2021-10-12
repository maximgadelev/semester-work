<#macro registrationTemplate>
    <form action="/registration" method="post">
        Login:
        <input name="login" type="text" autocomplete="off" minlength="6" maxlength="40" required/>
        <br>
        Password:
        <input name="password" type="password" autocomplete="off" minlength="6" maxlength="30" required>
        <br>
        Name:
        <input name="name" type="text" autocomplete="off" minlength="2" maxlength="30" pattern="^[A-Z].*" required>
        <br>
        Surname:
        <input name="surname" type="text" autocomplete="off" minlength="2" maxlength="30" pattern="^[A-Z].*" required>
        <br>
        Date of Birth:
        <input name ="dateOfBirth" type="text" autocomplete="off" minlength="10" maxlength="10" required>
        <br>
        <input type="submit" value="register">
    </form>
</#macro>