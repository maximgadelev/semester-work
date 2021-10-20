<#ftl encoding='UTF-8'>
<#macro loggedPassenger>
    <a href="main.ftl">Главная</a>
    <a href="passenger.ftl">Профиль</a>
    <a href="/logout">Выйти</a>
    <br>
</#macro>
<#macro loggedDriver>
    <a href="main.ftl">Главная</a>
    <a href="/driver">Профиль</a>
    <a href="/logout">Выйти</a>
    <br>
</#macro>

<#macro unloggedUser>
    <a href="login.ftl">Логин</a>
    <a href="registration.ftl">Регистрация</a>
    <br>
</#macro>
<#macro loggedUser>
    <a href="main.ftl">Главная</a>
    <a href="/passenger">Профиль</a>
    <a href="/logout">Выйти</a>
    <br>
</#macro>
