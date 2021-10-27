<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>
<@common.htmlTemplate pageName="DriverEndTrips">
<@navigation.loggedDriver/>
<#if car?has_content>
<#if driverEndTrips??>
<#if driverEndTrips?has_content>
<#list driverEndTrips as t>
    Дата:${t.date}
    Время:${t.time}
    Цена:${(t.price)}
</#list>
    </#if>
    </#if>
    </#if>
    </@common.htmlTemplate>
