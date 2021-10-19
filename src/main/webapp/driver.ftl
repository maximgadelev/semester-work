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
    </#if>

    <#if car?has_content>
        <p>Number of your car:${car.number}</p>
        <p>Brand of your car :${car.brand}</p>
        <p>Model of your car:${car.model}</p>
<#else>
        <p>You dont have car</p>
    <br>
    <form action="/addCar">
        <button type="submit">Add new car</button>
        <br>
    </form>
    </#if>

    <#if trip?has_content>
        <p>Your trip date:${trip.date}<p>
<#--        <#else>-->
<#--            <form action="/addTrip">-->
<#--            <button type="submit">Add new trip</button>-->
<#--            <br>-->
<#--            </form>-->
    </#if>
</@common.htmlTemplate>