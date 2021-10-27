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
                <form action="/driverActiveTrips" method="post">
                    <input type="hidden" name="tripId"
                           value='${t.id}'>
                    <input type="submit" value="Завершить данную поездку">
                </form>
            </#list>

<form action="/addTrip" method="get">
    <button type="submit">Добавить новую поездку</button>
    <br>
        </#if>
        <#else>
        У вас пока нет машины,чтобы совершать поездки:(
    </#if>
</#if>
</@common.htmlTemplate>
