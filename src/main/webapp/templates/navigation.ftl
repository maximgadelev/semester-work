<#macro loggedPassenger>
    <a href="main.ftl">Main</a>
    <a href="passenger.ftl">Passenger Profile</a>
    <a href="/logout">Logout</a>
    <br>
</#macro>
<#macro loggedDriver>
    <a href="main.ftl">Main</a>
    <a href="/driver">Driver</a>
    <a href="/logout">Logout</a>
    <br>
</#macro>

<#macro unloggedUser>
    <a href="login.ftl">Login</a>
    <a href="registration.ftl">Registration</a>
    <br>
</#macro>
<#macro loggedUser>
    <a href="main.ftl">Main</a>
    <a href="/passenger">Passenger</a>
    <a href="/logout">Logout</a>
    <br>
</#macro>
