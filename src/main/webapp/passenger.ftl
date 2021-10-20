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
    </#if>

    <body>
    <p><input type="file" name="photo" multiple accept="image/*,image/jpeg">
        <img src="/static/img/family-carpool-vector-illustration.jpg" width="300" height="300">
        <input type="submit" value="Отправить"></p>
    </body>

</@common.htmlTemplate>