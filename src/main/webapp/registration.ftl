<#import "/templates/common.ftl" as common>
<#import "/templates/registration.ftl" as registration>
<#import "/templates/navigation.ftl" as navigation>

<@common.htmlTemplate pageName="Registration">
    <@navigation.unloggedUser/>
    <@registration.registrationTemplate/>
</@common.htmlTemplate>
<style>
    nav{
        width: 960px;
    }
    nav:before{
        content: '';
        display: block;
        height: 50px;
        width: 100%;
        background-color: rgb(81,186,215);
        position: absolute;
        left: 0;
        z-index: -1;
    }
    ul{
        margin: -10px;
        padding: -10px;
        list-style: none;
        height: 50px;
    }
    ul li{
        float: left;
    }
    ul li a{
        color: #fff;
        display: block;
        height: 50px;
        padding: 0 30px;
        text-transform: uppercase;
        text-decoration: none;
        line-height: 50px;
    }
    ul li a:hover{
        background: #ffdb06;
    }
</style>
