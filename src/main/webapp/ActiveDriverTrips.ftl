<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>
<@common.htmlTemplate pageName="DriverActiveTrips">
    <@navigation.loggedDriver/>
<#if car?has_content>
    <#if driverActiveTrips??>
        <#if driverActiveTrips?has_content>
            <#list driverActiveTrips as t>
                Дата:${t.date}
                Время:${t.time}
                Цена:${(t.price)}
                Путь:${(t.path)}
                <form action="/driverActiveTrips" method="post">
                    <input type="hidden" name="tripId"
                           value='${t.id}'>
                    <input type="submit" value="Завершить данную поездку">
                </form>
                <form action ="/tripsPassenger" method="get">
                    <input type="hidden" name="tripId"
                    value='${t.id}'>
                    <input type="submit" value="Посмотреть пассажиров">
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
