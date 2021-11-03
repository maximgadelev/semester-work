<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<@common.htmlTemplate pageName="addFeedBackForDriver">
    <form action="/addFeedbackForDriver" method="post">
        <div id="txt1">Всего символов:<span>0</span></div>
        /100
        <textarea class="form-control" maxlength="100" name="feedback" id="txt" placeholder="Отзыв"
                  oninput="getTxt()"></textarea>
        <input name="rating" type="number" placeholder="Оцените поездку от 1 до 5">
        <input type="submit" value="Сохранить отзыв">
    </form>


    <script>
        function getTxt() {
            var txt = document.getElementById('txt').value;
            txt_len = txt.length;
            document.getElementById('txt1').lastChild.innerText = txt_len
        }
    </script>

</@common.htmlTemplate>


<style>

    textarea {
        background: gray;
    }

    label,
    textarea {
        font-size: .8rem;
        letter-spacing: 1px;
    }

    textarea {
        padding: 10px;
        max-width: 100%;
        line-height: 1.5;
        border-radius: 5px;
        border: 1px solid #ccc;
        box-shadow: 1px 1px 1px #999;
    }

    label {
        display: block;
        margin-bottom: 10px;
    }

</style>