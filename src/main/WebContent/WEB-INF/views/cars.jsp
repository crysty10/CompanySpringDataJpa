<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <style>
            body {
                background: url(http://betterparts.org/images/audi-a7-01.jpg) no-repeat;
                background-size: contain;
                font-family: sans-serif;
                color: white;
            }
        </style>
    </head>
    <body>

    <c:forEach items="${carsList}" var="car" >


        <li id="car_<c:out value= 'car.id' />" >

            <div> Car's name:  <c:out value="${car.carName}" />, Car's model: <c:out value="${car.carModel}" /> </div>

        </li>
    </c:forEach>
    <form>
        <input Type="button" value="Back home" onClick="history.go(-1);return true;">
    </form>
    </body>
</html>



