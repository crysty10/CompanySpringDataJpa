<%--
  Created by IntelliJ IDEA.
  User: Cristian.Dumitru
  Date: 3/10/2015
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Address</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value='/resources/style.css'/>">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>

<form method="POST">

    <div class="row">
        <div class="col-md-2">
            <span>Street:</span>
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
            <input type="text" name="street_nr">
        </div>
    </div>
    <div class="row">
        <div class="col-md-2">
            <span>Building:</span>
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
            <input type="text" name="floor">
        </div>
    </div>
    <div class="row">
    <div class="col-md-2">
        <span>Locality:</span>
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
        <input type="text" name="country">
    </div>
    </div>
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-2">
            <input type="submit" name="addAddressButton" value="Register"/>
            <button type="button" class="btn btn-primary"
                    onclick="window.location = '/Company/addresss'">Back to addresses
            </button>
        </div>
    </div>
</form>
</body>
</html>