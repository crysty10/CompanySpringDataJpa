<%--
  Created by IntelliJ IDEA.
  User: Cristian.Dumitru
  Date: 3/10/2015
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Address</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style.css'/>"/>
</head>
<body>
<%@ include file="util/header.jsp" %>

<div class="formDiv">
    <h1>Add page for Address!
        <small> Populate the inputs to save a new address!</small>
    </h1>
    <form:form method="POST" commandName="address" action="addAddress" modelAttribute="address">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2" style="color: white;">
                Street:
            </div>
            <div class="col-md-2">
                <form:input path="street"/>
            </div>
            <div class="col-md-4">
                <form:errors path="street" cssClass="error"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2" style="color: white;">
                Street nr.:
            </div>
            <div class="col-md-2">
                <form:input path="street_nr"/>
            </div>
            <div class="col-md-4">
                <form:errors path="street_nr" cssClass="error"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2" style="color: white;">
                Building:
            </div>
            <div class="col-md-2">
                <form:input path="building"/>
            </div>
            <div class="col-md-4">
                <form:errors path="building" cssClass="error"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2" style="color: white;">
                Floor:
            </div>
            <div class="col-md-2">
                <form:input path="floor"/>
            </div>
            <div class="col-md-4">
                <form:errors path="floor" cssClass="error"/>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2" style="color: white;">
                Apartment:
            </div>
            <div class="col-md-2">
                <form:input path="apartment"/>
            </div>
            <div class="col-md-4">
                <form:errors path="apartment" cssClass="error"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2" style="color: white;">
                Locality:
            </div>
            <div class="col-md-2">
                <form:input path="locality"/>
            </div>
            <div class="col-md-4">
                <form:errors path="locality" cssClass="error"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2" style="color: white;">
                Country:
            </div>
            <div class="col-md-2">
                <form:input path="country"/>
            </div>
            <div class="col-md-4">
                <form:errors path="street" cssClass="error"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2">
            </div>
            <div class="col-md-2">
                <input type="submit" name="addAddressButton" value="Register"/>

            </div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2">
            </div>
            <div class="col-md-2">
                <button type="button" class="btn btn-primary"
                        onclick="window.location = '/Company/addresss'">Back to addresses
                </button>
            </div>
        </div>
    </form:form>
</div>

<%@ include file="util/footer.jsp" %>
</body>
</html>
