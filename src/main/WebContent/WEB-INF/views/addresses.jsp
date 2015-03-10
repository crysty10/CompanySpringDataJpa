<%--
  Created by IntelliJ IDEA.
  User: Cristian.Dumitru
  Date: 3/9/2015
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Addresses</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
<h1>All the Company employees addresses!
    <small>You can update data as well!</small>
</h1>
<c:forEach items="${addressList}" var="address">
    <div class="row" style="text-align: center;">
        <div class="col-md-1">
            <c:out value="${address.id}"/>
        </div>
        <div class="col-md-2">
            <c:out value="${address.street}"/>
        </div>
        <div class="col-md-1">
            <c:out value="${address.street_nr}"/>
        </div>
        <div class="col-md-1">
            <c:out value="${address.building}"/>
        </div>
        <div class="col-md-1">
            <c:out value="${address.floor}"/>
        </div>
        <div class="col-md-1">
            <c:out value="${address.apartment}"/>
        </div>
        <div class="col-md-2">
            <c:out value="${address.locality}"/>
        </div>
        <div class="col-md-1">
            <c:out value="${address.country}"/>
        </div>
        <div class="col-md-2">
            <button type="button" class="btn btn-danger">UPDATE</button>
        </div>
    </div>
</c:forEach>
<div class="row" style="text-align: center;">
    <div class="col-md-10"></div>
    <div class="col-md-2">
        <button type="button" class="btn btn-primary" onclick="">BACK</button>
    </div>
</div>
</body>
</html>
