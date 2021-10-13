<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>

<@common.htmlTemplate pageName="Driver">
    <@navigation.loggedDriver/>
    <#if driver?has_content>
        <H3>You are driver!Welcome!</H3>
        <p>Firstname: ${driver.name}</p>
        <p>Surname: ${driver.surname}</p>
        <p>Login: ${driver.login}</p>
        <p>Rating: ${driver.rating}</p>
        <p>Date of Birth:${driver.dateOfBirth}</p>
    </#if>

</@common.htmlTemplate>