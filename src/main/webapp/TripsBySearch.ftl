<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>

<@common.htmlTemplate pageName="TripsBySearch">
    <#if passenger?has_content>
    <@navigation.loggedUser/>
<#if trips??>
    <#if trips?has_content>
<#list trips as t>
    Дата:${t.date}
    Время:${t.time}
    Цена:${(t.price)*places}
    Желамое количество мест:${places}
    Свободных мест:${t.freePlaces}

    <form action="/tripsBySearch" method="post">
     <input type="hidden" name="tripId"
     value='${t.id}'>
        <input type="submit" value="Бронировать">
    </form>
</#list>!
        </#if>
</#if>

        <#else>
        <@navigation.unloggedUser/>
            <#if trips??>
                <#if trips?has_content>
                    <#list trips as t>
                        Дата:${t.date}
                        Время:${t.time}
                        Цена:${(t.price)*places}
                        Желамое количество мест:${places}
                        Свободных мест:${t.freePlaces}

                            <input type="submit" id="myBtn" type="submit" value="Бронировать" onclick="onClick()"></input>
                            <div id="myModal" class="modal">
                                <div class="modal-content">
                                    <span class="close" onclick="onClick2()">&times;</span>
                                    <p>Чтобы забронировать поездку,небходимо войти в ваш профиль!</p>
                                </div>
                            </div>
                    </#list>!
                </#if>
            </#if>
            </#if>
<script>
       var modal=document.getElementById('myModal');
       var btn = document.getElementById('myBtn');
       var span = document.getElementsByClassName('close')[0];

   window.onclick = function (event){
           if(event.target==modal){
               modal.style.display="none";
           }
   }
   function onClick(){
           modal.style.display="block"
   }
   function onClick2(){
           modal.style.display="none";
   }
</script>
<style>
    .modal{
        display: none;
        position: fixed;
        z-index: 1;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
        background-color: aliceblue;
    }
    .modal-content{
        background-color: #fefefe;
        margin: 15% auto;
        padding: 20px;
        border: 1px solid #888;
        width: 80%;
    }
    .close{
        color: #aaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
    }
</style>
</@common.htmlTemplate>