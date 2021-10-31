<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<@common.htmlTemplate pageName="DriverActiveTrips">
    <form action="/addFeedbackForPassenger" method="post">
        <input name="feedback" type="text" placeholder="Отзыв">
        <input name="rating" type="number" placeholder="Оцените поездку от 1 до 5">
        <input type="submit" value="Сохранить отзыв">
    </form>
</@common.htmlTemplate>