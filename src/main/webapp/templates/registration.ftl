<#ftl encoding='UTF-8'>
<#macro registrationTemplate>
    <head>
    <form action="/registration" method="post">

        Логин:
        <input name="login" type="text" autocomplete="off" minlength="6" maxlength="40" required/>
        <br>
        Пароль:
        <input name="password" type="password" autocomplete="off" minlength="6" maxlength="30" required>
        <br>
        Имя:
        <input name="name" type="text" autocomplete="off" minlength="2" maxlength="30" pattern="^[А-Я].*" required>
        <br>
        Фамилия:
        <input name="surname" type="text" autocomplete="off" minlength="2" maxlength="30" pattern="^[А-Я].*" required>
        <br>
        Дата рождения:
        <input name ="dateOfBirth" type="text" autocomplete="off" minlength="10" maxlength="10" pattern="^(?:0[1-9]|[12]\d|3[01])([\/.-])(?:0[1-9]|1[012])\1(?:19|20)\d\d$" required>
        <br>
        <br>
        <p><input type="radio" name="check" id="passenger" value="passenger">Вы пассажир</p>
        <p><input type="radio" name="check" id="driver" value="driver">Вы водитель</p>
        <input type="submit" value="Зарегестрироваться">
    </form>
        <style>
            body{
                background-image: url("/static/img/family-carpool-vector-illustration.jpg");
                background-size: 100%;
            }

        </style>
    </head>
</#macro>