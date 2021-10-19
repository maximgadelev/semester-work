<#import "/templates/common.ftl" as common>
<@common.htmlTemplate pageName="AddCar">
    <form action="/addCar" method ="post">
            Brand:
            <input name="brand" type="text" maxlength="20" required/>
            <br>
            Number:
            <input name="number" type="text" minlength="6" maxlength="6" required>
            <br>
            Number of Places:
            <input name="numberOfPlaces" type="number" minlength="1" maxlength="10" required>
            <br>
            Model:
            <input name="model" type="text" maxlength="30" required>
            <br>
            <input type="submit" value="Add new car">
        </form>
    </@common.htmlTemplate>
