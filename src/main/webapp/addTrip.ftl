<#import "/templates/common.ftl" as common>
<@common.htmlTemplate pageName="AddCar">
    <form action="/addTrip" method ="post">
       Date:
        <input name="date" type="text" maxlength="20" required/>
        <br>
         Price:
        <input name="price" type="number"  maxlength="6" required>
        <br>
        Path:
        <input name="path" type="text" required>
        <br>
         Time:
        <input name="time" type="text" maxlength="30" required>
        <br>
        <input type="submit" value="Add new trip">
    </form>
</@common.htmlTemplate>
