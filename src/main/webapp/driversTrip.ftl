<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>
<@common.htmlTemplate pageName="driversTrip">

    <@navigation.loggedUser/>
    <#if tripDriver?has_content>
        <#if driverCar?has_content>
        Ваш водитель:${tripDriver.name}
        Машина:${driverCar.brand} ${driverCar.model} ${driverCar.number}
        </#if>
        <form action="/addFeedbackForDriver" method="get">
            <input type="hidden" name="driverId" value='${tripDriver.id}'>
            <input type="submit" name="Написать отзыв">
        </form>
    </#if>
</@common.htmlTemplate>