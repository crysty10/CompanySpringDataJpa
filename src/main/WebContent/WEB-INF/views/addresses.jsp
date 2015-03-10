<%--
  Created by IntelliJ IDEA.
  User: Cristian.Dumitru
  Date: 3/9/2015
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<c:forEach items="${addressList}" var="address">
  <li id="address_<c:out value='address.id'/>">
    <div class="addressDiv">
      <span class="addressStreet">
        <c:out value="${address.street}"/>
      </span>
      <span class="addressStreetNr">
        <c:out value="${address.street_nr}"/>
      </span>
      <span class="addressBuilding">
        <c:out value="${address.building}"/>
      </span>
      <span class="addressFloor">
        <c:out value="${address.floor}"/>
      </span>
      <span class="addressAp">
        <c:out value="${address.apartment}"/>
      </span>
      <span class="addressLocality">
        <c:out value="${address.locality}"/>
      </span>
      <span class="addressCountry">
        <c:out value="${address.country}"/>
      </span>
    </div>
  </li>
</c:forEach>
</body>
</html>
