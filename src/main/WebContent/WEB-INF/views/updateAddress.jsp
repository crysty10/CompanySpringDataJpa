<%--
  Created by IntelliJ IDEA.
  User: Cristian.Dumitru
  Date: 3/10/2015
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Employee</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <style>
        h1, h3, a, p, span, small {
            color : white;
        }
        body {
            background-image: url(http://cdn.hdwallpaperspics.com/uploads/2012/11/Apple-20Vector-20Desktop-20Ful-20HD-20Background1.jpg);
            text-color : white;
            background-size: 100%;
        }
    </style>
</head>
<body>
<form method="POST">
    <div class="row">
        <div class="col-md-2">
            <span>Street:</span>
        </div>
        <div class="col-md-2">
            <c:out value="${address.street}"/>
        </div>
        <div class="col-md-2">
            <input type="text" name="street">
        </div>
    </div>
    <div class="row">
        <div class="col-md-2">
            <span>Street nr.:</span>
        </div>
        <div class="col-md-2">
            <c:out value="${address.street_nr}"/>
        </div>
        <div class="col-md-2">
            <input type="text" name="street_nr">
        </div>
    </div>
    <div class="row">
        <div class="col-md-2">
            <span>Building:</span>
        </div>
        <div class="col-md-2">
            <c:out value="${address.building}"/>
        </div>
        <div class="col-md-2">
            <input type="text" name="building">
        </div>
    </div>
    <div class="row">
        <div class="col-md-2">
            <span>Floor:</span>
        </div>
        <div class="col-md-2">
            <c:out value="${address.floor}"/>
        </div>
        <div class="col-md-2">
            <input type="text" name="floor">
        </div>
    </div>
    <div class="row">
        <div class="col-md-2">
            <span>Locality:</span>
        </div>
        <div class="col-md-2">
            <c:out value="${address.locality}"/>
        </div>
        <div class="col-md-2">
            <input type="text" name="locality">
        </div>
    </div>
    <div class="row">
        <div class="col-md-2">
            <span>Country:</span>
        </div>
        <div class="col-md-2">
            <c:out value="${address.country}"/>
        </div>
        <div class="col-md-2">
            <input type="text" name="country">
        </div>
    </div>

    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-2">
            <button type="button" class="btn btn-primary"
                    onclick="window.location = '/Company/addresss'">Back to employees
            </button>
        </div>
        <div class="col-md-2">
            <input type="submit" value="UPDATE"/>
        </div>
    </div>
</form>

</body>
</html>
