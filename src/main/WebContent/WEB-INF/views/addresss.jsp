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
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style.css'/>"/>
</head>
<body>
<%@ include file="util/header.jsp" %>
<div style="text-align: center;">
    <h1>All the Company employees addresses!
        <small> You can update data as well!</small>
    </h1>
    <c:forEach items="${addressList}" var="address">
        <div class="row" style="text-align: center; color:white;">
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
            <div class="col-md-2">
                <c:out value="${address.locality}"/>
            </div>
            <div class="col-md-1">
                <c:out value="${address.country}"/>
            </div>
            <div class="col-md-1">
                <input style="color:black;" type="submit" value="Update"
                       onclick="window.location = '/Company/addresss/${address.id}'"/>
            </div>
            <div class="col-md-2" style="color:black;">
                <c:url var="deleteUrl" value="addresss"/>
                <form id="${addressFormId}" action="${deleteUrl}" method="POST">
                    <input id="address" name="address" type="hidden" value="${address.id}"/>
                    <input type="submit" value="Delete"
                           onClick="return confirm('Are you sure you want to delete this address?')"/>
                </form>
            </div>
        </div>
    </c:forEach>
    <div class="row" style="text-align: center;">
        <div class="col-md-10"></div>
        <div class="col-md-2">
            <button type="button" class="btn btn-primary"
                    onclick="window.location = '/Company'">Back to Company
            </button>
        </div>
    </div>
    <p>
        <span style="font-size: 200%"><a style="color:blue;"
                                         href="<c:url value='/addAddress'/>">Add</a> a new address</span>
    </p>
</div>
<%@ include file="util/footer.jsp" %>
</body>
</html>
