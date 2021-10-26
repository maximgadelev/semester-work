<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>

<@common.htmlTemplate pageName="ActiveTrips">
    <@navigation.loggedUser/>
    <#if passengersTrips??>
        <#if passengersTrips?has_content>
            <#list passengersTrips as t>
                Дата:${t.date}
                Время:${t.time}
                Цена:${(t.price)}
            </#list>
        </#if>
    </#if>
</@common.htmlTemplate>