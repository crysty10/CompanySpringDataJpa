<%--
  Created by IntelliJ IDEA.
  User: Cristian.Dumitru
  Date: 3/9/2015
  Time: 5:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<c:forEach items="${carList}" var="car">
  <li id="car_<c:out value='car.id'/>">
    <div class="carDiv">
      <span class="carName">
        <c:out value="${car.carName}"/>
      </span>
      <span class="carModel">
        <c:out value="${car.carModel}"/>
      </span>
    </div>
  </li>
</c:forEach>
</body>
</html>
