<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>
<head>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<@common.htmlTemplate pageName="Main">
    <#if passenger?has_content>
        <@navigation.loggedUser/>
        <#else>
         <#if driver?has_content>
        <@navigation.loggedDriver/>
        <#else>
            <@navigation.unloggedUser/>
    </#if>
    </#if>
    <form action="/main" method="post">
        <input name="first" type="text" placeholder="Откуда" required>
       <button type="submit"><i class="fa fa-search"></i></button>
        <input name="second" type="text" placeholder="Куда" required>
        <input name ="date" type="text" placeholder="Дата" required>
        <input  name = "time" type="text" placeholder="Время" required>
        <input name ="places" type="number" placeholder="Количество мест" required>
        <div class = "radio">
            <p><input type="radio" name="check" id="price" value="price">Сначала самые дешевые поездки</p>
        </div>
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
        margin-top: 10px;
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