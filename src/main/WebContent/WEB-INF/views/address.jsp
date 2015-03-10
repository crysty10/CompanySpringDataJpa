<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <style>
            body {
                background: url(http://s3.germany.travel/media/content/gut_zu_wissen_1/bundeslaender/nordrhein_westfalen/header_NRW_Aggertalsperre-im-Bergischen-Land-Naturarena-Bergisches-Land-GmbH.jpg) no-repeat;
                background-size: 100%;
                font-family: sans-serif;
                color: black;
            }
        </style>
    </head>
    <body>

    <c:forEach items="${addressesList}" var="addr" >

      <li id="addr_<c:out value= 'addr.id' />" >

        <div> Address : Street's name:  <c:out value="${addr.street}" />, Street's nr:  <c:out value="${addr.street_nr}" />, Building:  <c:out value="${addr.building}" />, Apartment: <c:out value="${addr.apartment}" />, Locality: <c:out value="${addr.locality}" />, Country: <c:out value="${addr.country}" /> </div>

      </li>
    </c:forEach>

    <form>
        <input Type="button" value="Back home" onClick="history.go(-1);return true;">
    </form>
    </body>
</html>



