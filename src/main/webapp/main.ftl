<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>
<@common.htmlTemplate pageName="Main">
    <#if passenger?has_content>
        <@navigation.loggedPassenger/>
    </#if>
    <#if driver?has_content>
        <@navigation.loggedDriver/>
    </#if>
    You are login on site!It is main page
</@common.htmlTemplate>