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
        <br>
        <form action="/addCar" method="get">
        <input type="submit" value="Add new car">
        <br>
        </form>
    </#if>

    <#if car?has_content>
        <p>Number of your car:${car.number}</p>
        <p>Brand of your car :${car.brand}</p>
<#else>
        <p>You dont have car</p>
    </#if>
</@common.htmlTemplate>