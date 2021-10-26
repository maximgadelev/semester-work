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
    Цена:${(t.price)*places}
    Желамое количество мест:${places}
    Свободных мест:${t.freePlaces}

    <form action="/tripsBySearch" method="post">
     <input type="hidden" name="tripId"
     value='${t.id}'>
        <input type="submit" value="Бронировать">
    </form>
</#list>!
        </#if>
</#if>
</@common.htmlTemplate>