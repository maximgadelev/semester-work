<html lang="en">
<#include "base.ftl">
<#macro title>Passengers</#macro>

<#macro content>
    Hello,
    <#if passengers??>
        <#if passengers?has_content>
            <#list passengers as p>
                ${p.name} ${p.surname} Your passenger rating is :
            </#list>!
        </#if>
    </#if>
</#macro>
</html>