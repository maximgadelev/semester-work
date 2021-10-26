<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>

<@common.htmlTemplate pageName="Passenger">
<@navigation.loggedUser/>
    <#if passenger?has_content>
        <h3>You are passenger!Welcome!</h3>
        <p>Имя: ${passenger.name}</p>
        <p>Фамилия: ${passenger.surname}</p>
        <p>Логин: ${passenger.login}</p>
        <p>Ваш рейтинг: ${passenger.rating}</p>
        <p>Дата рождения:${passenger.dateOfBirth}</p>


        <#if passenger.profileImage?has_content>
            <p>Ваше фото</p>
            <img src="${passenger.profileImage}" alt="Profile photo">
        </#if>

        <form action="/upload" method="post" enctype="multipart/form-data">
            Change profile photo:
            <input type="file" name="file"> <input type="submit" value="upload">
        </form>


    </#if>
    <style>
        nav{
            width: 960px;
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
    </style>


</@common.htmlTemplate>