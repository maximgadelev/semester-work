<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<@common.htmlTemplate pageName="addFeedBackForDriver">
    <form action="/addFeedbackForDriver" method="post">
        <div id="txt1">Всего символов:<span>0</span></div>/100
            <textarea class="form-control" maxlength="100" name="feedback"  id="txt" placeholder="Отзыв" oninput="getTxt()"></textarea>
        <input name="rating" type="number" placeholder="Оцените поездку от 1 до 5">
        <input type="submit" value="Сохранить отзыв">
    </form>
    <script>
       function getTxt(){
           var txt=document.getElementById('txt').value;
           txt_len=txt.length;
           document.getElementById('txt1').lastChild.innerText=txt_len
       }
    </script>
</@common.htmlTemplate>