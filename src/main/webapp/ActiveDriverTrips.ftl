<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>

<@common.htmlTemplate pageName="DriverActiveTrips">
    <@navigation.loggedDriver/>
<#if car?has_content>
    <#if driverTrips??>
        <#if driverTrips?has_content>
            <#list driverTrips as t>
                Дата:${t.date}
                Время:${t.time}
                Цена:${(t.price)}
            </#list>
        </#if>
        <#else>
        У вас пока нет машины,чтобы совершать поездки:(
    </#if>
</#if>
</@common.htmlTemplate>
