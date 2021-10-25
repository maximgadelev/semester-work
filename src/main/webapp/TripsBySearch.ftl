<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>

<@common.htmlTemplate pageName="TripsBySearch">
    <@navigation.loggedUser/>
<#if trips??>
    <#if trips?has_content>
<#list trips as t>
    Дата:${t.date}
    Время:${t.time}
    Цена:${t.price}
    Свободных мест:${t.freePlaces}

</#list>!
        </#if>
</#if>
</@common.htmlTemplate>