<#import "/templates/common.ftl" as common>
<#import "/templates/registration.ftl" as registration>
<#import "/templates/navigation.ftl" as navigation>

<@common.htmlTemplate pageName="Registration">
    <@navigation.unloggedUser/>
    <@registration.registrationTemplate/>
</@common.htmlTemplate>
