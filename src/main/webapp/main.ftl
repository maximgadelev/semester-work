<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<@common.htmlTemplate pageName="Main">
    <#if passenger?has_content>
        <@navigation.loggedUser/>
    </#if>
    <#if driver?has_content>
        <@navigation.loggedDriver/>
    </#if>



    <form action="/main" method="post">
        <input name="first" type="text" placeholder="Откуда">
       <button type="submit"><i class="fa fa-search"></i></button>
        <input name="second" type="text" placeholder="Куда">
        <input name ="date" type="text" placeholder="Дата">
        <input  name = "time" type="text" placeholder="Время">
        <input name ="places" type="number" placeholder="Количество мест">
    </form>
    Главная страница!
</@common.htmlTemplate>



<style>
    body{
        background: url(https://i.pinimg.com/originals/85/9c/37/859c37db7f07c21508649e3c31ff8490.gif);
        background-attachment: fixed;
        background-position: right;
        background-repeat: no-repeat;
        background-size: 100%;
    }
    nav{
        width:100%;
    }
    nav:before{
        content: '';
        display: block;
        height: 50px;
        width: 100%;
        background: rgb(81,186,215);
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
        background:  #ffdb06;
    }
    form {
        text-align: center;
        width: 300px;
        height: 500px;
        border-radius: 10px;
        background:rgb(81,186,215);
        opacity: 0.9;
        margin-top: 5%;
        margin-right: 50%;
    }
    input {
        width: 200px;
        margin: 5px;
        height: 50px;
        padding-left: 10px;
        border: 2px solid #7BA7AB;
        border-radius: 10px;
        outline: none;
        background: white;
        color: #9E9C9C;
    }

    button {
        position: absolute;
        margin-right: 50%;
        margin-top: 10%;
        width: 150px;
        height: 30px;
        border: none;
        background:rgb(81,186,215);
        border-radius: 0 5px 5px 0;
        cursor: pointer;
    }
</style>