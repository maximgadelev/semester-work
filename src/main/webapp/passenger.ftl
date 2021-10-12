<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>

<@common.htmlTemplate pageName="Passenger">
<@navigation.loggedUser/>
    <#if passenger?has_content>
        <p>Firstname: ${passenger.name}</p>
        <p>Surname: ${passenger.surname}</p>
        <p>Login: ${passenger.login}</p>
        <p>Rating: ${passenger.rating}</p>
        <p>Date of Birth:${passenger.dateOfBirth}</p>
    </#if>

</@common.htmlTemplate>