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


</@common.htmlTemplate>