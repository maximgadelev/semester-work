<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>

<@common.htmlTemplate pageName="EndTrips">
    <head>
    <@navigation.loggedUser/>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>
    <#if passengersEndTrips??>
        <#if passengersEndTrips?has_content>
            <#list passengersEndTrips as t>
                Дата:${t.date}
                Время:${t.time}
                Цена:${(t.price)}
                Путь:${(t.path)}
                <form action="/driversTrip" method="get">
                    <input type="hidden" name="id_trip"
                           value='${t.id}'>
                    <input type="submit" value="Узнать водителя">
                </form>
            </#list>
        </#if>
    </#if>
</@common.htmlTemplate>
