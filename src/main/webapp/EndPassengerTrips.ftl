<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>

<@common.htmlTemplate pageName="EndTrips">
    <@navigation.loggedUser/>
    <#if passengersEndTrips??>
        <#if passengersEndTrips?has_content>
            <#list passengersEndTrips as t>
                Дата:${t.date}
                Время:${t.time}
                Цена:${(t.price)}
            </#list>
        </#if>
    </#if>
</@common.htmlTemplate>