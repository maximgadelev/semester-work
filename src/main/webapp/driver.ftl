<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>

<@common.htmlTemplate pageName="Driver">
    <@navigation.loggedDriver/>
    <#if driver?has_content>
        <H3>Профиль водителя</H3>
        <p>Имя: ${driver.name}</p>
        <p>Фамилия: ${driver.surname}</p>
        <p>Логин: ${driver.login}</p>
        <p>Рейтинг: ${driver.rating}</p>
        <p>Дата рождения:${driver.dateOfBirth}</p>
        <br>
    </#if>

    <#if car?has_content>
        <H3>Информация о вашей машине</H3>
        <p>Номер:${car.number}</p>
        <p>Марка:${car.brand}</p>
        <p>Модель:${car.model}</p>

<#else>
        <p>У вас пока нет машины</p>
    <br>
    <form action="/addCar">
        <button type="submit">Добавить машину</button>
        <br>
    </form>
    </#if>
    <#if trip?has_content>
        <H3>Ваша ближайшая поездка</H3>
        <p>Дата:${trip.date}<p>
        <p>Время:${trip.time}</p>
    <#else>
        <form action="/addTrip">
            <button type="submit">Добавить новую поездку</button>
            <br>
        </form>
    </#if>



</@common.htmlTemplate>