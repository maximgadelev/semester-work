<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>
<@common.htmlTemplate pageName="Main">
    <#if passenger?has_content>
        <@navigation.loggedPassenger/>
    </#if>
    <#if driver?has_content>
        <@navigation.loggedDriver/>
    </#if>
    Главная страница!
</@common.htmlTemplate>