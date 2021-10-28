<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<@common.htmlTemplate pageName="addFeedBackForDriver">
    <form action="/addFeedbackForDriver" method="post">
        <input name="feedback" type="text" placeholder="Отзыв">
        <input type="submit" value="Сохранить отзыв">
    </form>
</@common.htmlTemplate>