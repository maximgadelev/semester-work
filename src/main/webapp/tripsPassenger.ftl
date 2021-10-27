<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>
<@common.htmlTemplate pageName="DriverActiveTrips">
    <@navigation.loggedDriver/>
    <#if tripsPassengers??>
        <#if tripsPassengers?has_content>
            <#list tripsPassengers as p>
                Имя:${p.name}
                Фамилия:${p.surname}
            </#list>
            </#if>
            </#if>
</@common.htmlTemplate>