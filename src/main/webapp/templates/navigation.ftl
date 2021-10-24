<#ftl encoding='UTF-8'>
    <#macro loggedPassenger>
        <a href="main.ftl">Главная</a>
        <a href="passenger.ftl">Профиль</a>
        <a href="/logout">Выйти</a>
    </#macro>
    <#macro loggedDriver>
        <a href="main.ftl">Главная</a>
        <a href="/driver">Профиль водителя</a>
        <a href="/logout">Выйти</a>
    </#macro>



    <#macro unloggedUser>
        <nav>
            <ul>
       <li><a href="login.ftl">Логин</a></li>
                <li><a href="registration.ftl">Регистрация</a></li>
            </ul>
        </nav>
    </#macro>
    <#macro loggedUser>
        <a href="main.ftl">Главная</a>
        <a href="/passenger">Профиль Пассажира</a>
        <a href="/logout">Выйти</a>
        <br>
    </#macro>

<style>
    nav{
        width: 960px;
    }
    nav:before{
        content: '';
        display: block;
        height: 50px;
        width: 100%;
        background-color: rgb(81,186,215);
        position: absolute;
        left: 0;
        z-index: -1;
    }
    ul{
        margin: -10px;
        padding: -10px;
        list-style: none;
        height: 50px;
    }
    ul li{
        float: left;
    }
    ul li a{
        color: #fff;
        display: block;
        height: 50px;
        padding: 0 30px;
        text-transform: uppercase;
        text-decoration: none;
        line-height: 50px;
    }
    ul li a:hover{
        background: #ffdb06;
    }

