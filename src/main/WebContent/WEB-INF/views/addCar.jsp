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
    <title>Add Car</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style.css'/>"/>
</head>
<body>
<%--<%@ include file="util/header.jsp" %>--%>

<div class="formDiv">
    <h1>Add page for Car!
        <small> Populate the inputs to save a new car!</small>
    </h1>
    <form:form method="POST" commandName="car" action="addCar" modelAttribute="car">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2" style="color: white;">
                Car's name:
            </div>
            <div class="col-md-2">
                <form:input path="carName"/>
            </div>
            <div class="col-md-4">
                <form:errors path="carName" cssClass="error"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2" style="color: white;">
                <span>Car's model:</span>
            </div>
            <div class="col-md-2">
                <form:input path="carModel"/>
            </div>
            <div class="col-md-4">
                <form:errors path="carModel" cssClass="error"/>
            </div>
        </div>
        <%--<div class="row">--%>
            <%--<div class="col-md-4"></div>--%>
            <%--<div class="col-md-2" style="color : white;">--%>
                <%--Employee :--%>
            <%--</div>--%>
            <%--<div class="col-md-2">--%>
                <%--<form:select path="employees" multiple="false" cssStyle="width: 180px;">--%>
                    <%--<form:option value="" label="" selected="selected">None</form:option>--%>
                    <%--<c:forEach items="${employeeList}" var="employee">--%>
                        <%--<form:option value="${employee.id}">${employee.firstname} ${employee.lastname}</form:option>--%>
                    <%--</c:forEach>--%>
                <%--</form:select>--%>
            <%--</div>--%>
            <%--<div class="col-md-4">--%>
                <%--<form:errors path="employees" cssClass="error"/>--%>
            <%--</div>--%>
        <%--</div>--%>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2">
            </div>
            <div class="col-md-2">
                <input type="submit" name="addCarButton" value="Register"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2">
            </div>
            <div class="col-md-2">
                <button type="button" class="btn btn-primary"
                        onclick="window.location = '/Company/cars'">Back to cars
                </button>
            </div>
        </div>
    </form:form>
</div>

<%@ include file="util/footer.jsp" %>
</body>
</html>
