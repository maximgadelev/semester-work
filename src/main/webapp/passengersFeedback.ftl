<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>

<@common.htmlTemplate pageName="PassengersFeedback">
<@navigation.loggedUser/>

    <#if passengersFeedback??>
        <#if passengersFeedback?has_content>
            <#list passengersFeedback as p>
                Текст:${p.text}


                <#if drivers??>
                     <#if drivers?has_content>
                           <#list drivers as d>
              <#if p.driver_id=d.id>
                  От кого:${d.name}

              </#if>
                </#list>
                </#if>
                </#if>
            </#list>
        </#if>
    </#if>


</@common.htmlTemplate>