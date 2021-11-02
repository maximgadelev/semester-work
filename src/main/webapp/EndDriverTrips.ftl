<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>
<@common.htmlTemplate pageName="DriverEndTrips">
    <head>
<@navigation.loggedDriver/>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>
<#if car?has_content>
<#if driverEndTrips??>
<#if driverEndTrips?has_content>
<#list driverEndTrips as t>
    Дата:${t.date}
    Время:${t.time}
    Цена:${(t.price)}
    <form action ="/tripsPassenger" method="get">
        <input type="hidden" name="tripId"
               value='${t.id}'>
        <input type="submit" value="Посмотреть пассажиров">
    </form>
</#list>
    </#if>
    </#if>
    </#if>
    </@common.htmlTemplate>
<style>
</style>
