<#ftl encoding='UTF-8'>
<#import "/templates/common.ftl" as common>
<#import "/templates/navigation.ftl" as navigation>
<@common.htmlTemplate pageName="DriverEndTrips">
    <head>
<@navigation.loggedDriver/>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>
<#if car?has_content>
<#if driverEndTrips??>
<#if driverEndTrips?has_content>
<#list driverEndTrips as t>
  <div class="bg-white  mb-4 order-list shadow-sm">
                        <div class="gold-members p-4">
                            <div class="media">
                                <div class="media-body">
                                    <span class="float-right text-info">${t.path}<i
                                                class="icofont-check-circled text-success"></i></span>
                                    <h4 class="mb-2">
                                        <div class="text-black">Поездка</div>
                                    </h4>
                                    <p class="text-gray mb-1"><i class="icofont-location-arrow"></i>Дата:${t.date}
                                    </p>
                                    <p class="text-gray mb-3"><i class="icofont-list"></i>Время:${t.time}<i
                                                class="icofont-clock-time ml-2"></i></p>
                                    <hr>
                                    <div class="float-right">
                                        <form action="/tripsPassenger" method="get" >
                                            <input type="hidden" name="tripId"
                                                   value='${t.id}'>
                                            <input type="submit" class="btn btn-sm btn-primary" value="Посмотреть пассажиров">
                                        </form>
                                    </div>
                                    <p class="mb-0 text-black text-primary pt-2"><span
                                                class="text-black font-weight-bold">Цена </span>:${(t.price)}
                                    </p>
                                </div>
                            </div>
                        </div>
                       </div>
                    </#list>
                </#if>
            </#if>
    <#else>
        У вас пока нет машины,чтобы совершать поездки:(
        </#if>
    </@common.htmlTemplate>
<style>
    body {
        background: #eeeeee;
    }

    .order-list .btn {
        border-radius: 20px;
        min-width: 121px;
        font-size: 13px;
        padding: 7px 0 7px 0;
    }

    .osahan-account-page-left .nav-link.active i {
        background: #282c3f !important;
    }

    .h1, .h2, .h3, .h4, .h5, .h6, h1, h2, h3, h4, h5, h6 {
        color: #000000;
    }

    .shadow-sm {
        margin-top: 30px;
        width: 1000px;
        height: 250px;
    }

    a:hover {
        text-decoration: none;
    }
</style>