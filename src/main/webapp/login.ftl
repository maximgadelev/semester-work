<#import "/templates/common.ftl" as common>
<#import "/templates/login.ftl" as login>
<#import "/templates/navigation.ftl" as navigation>

<@common.htmlTemplate pageName="Login">

    <@navigation.unloggedUser/>
    <@login.loginTemplate/>
</@common.htmlTemplate>


