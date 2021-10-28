<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>
<@common.htmlTemplate pageName="DriversFeedback">
    <@navigation.loggedDriver/>


    <#if driversFeedback??>
        <#if driversFeedback?has_content>
            <#list driversFeedback as d>
                Текст:${d.text}

                <#if passengers??>
                    <#if passengers?has_content>
                        <#list passengers as p>
                            <#if p.id=d.passenger_id>
                                От кого:${p.name}
                            </#if>
                        </#list>
                    </#if>
                </#if>
            </#list>
        </#if>
    </#if>

</@common.htmlTemplate>