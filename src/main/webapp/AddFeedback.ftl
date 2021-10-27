<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<@common.htmlTemplate pageName="DriverActiveTrips">
    <form action="/addFeedback" method="post">
        <input name="feedback" type="text" placeholder="Отзыв">
        <input type="submit" value="Сохранить отзыв">
    </form>
</@common.htmlTemplate>