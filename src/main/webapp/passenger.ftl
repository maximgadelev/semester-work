<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>

<@common.htmlTemplate pageName="Passenger">
<@navigation.loggedUser/>
    <#if passenger?has_content>
        <h3>You are passenger!Welcome!</h3>
        <p>Firstname: ${passenger.name}</p>
        <p>Surname: ${passenger.surname}</p>
        <p>Login: ${passenger.login}</p>
        <p>Rating: ${passenger.rating}</p>
        <p>Date of Birth:${passenger.dateOfBirth}</p>
    </#if>
    <body>
    <p><input type="file" name="photo" multiple accept="image/*,image/jpeg">
        <img src="" width="300" height="300">
        <input type="submit" value="Отправить"></p>
    </body>

</@common.htmlTemplate>