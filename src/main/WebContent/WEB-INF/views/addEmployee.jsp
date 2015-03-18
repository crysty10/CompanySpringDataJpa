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
    <title>Add Employee</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style.css'/>"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>

<body>
<%@ include file="util/header.jsp" %>
<div class="formDiv">
    <h1>Add page for Employee!
        <small> Populate the inputs to save a new employee!</small>
    </h1>

    <form:form method="POST" commandName="employee" action="addEmployee" modelAttribute="employee">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2" style="color : white;">
                First name :
            </div>
            <div class="col-md-2">
                <form:input path="firstname"/>
            </div>
            <div class="col-md-4">
                <form:errors path="firstname" cssClass="error"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2" style="color : white;">
                Last name :
            </div>
            <div class="col-md-2">
                <form:input path="lastname"/>
            </div>
            <div class="col-md-4">
                <form:errors path="lastname" cssClass="error"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2" style="color : white;">
                Salary :
            </div>
            <div class="col-md-2">
                <form:input path="salary"/>
            </div>
            <div class="col-md-4">
                <form:errors path="salary" cssClass="error"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2" style="color : white;">
                Department :
            </div>
            <div class="col-md-2">
                <form:select path="department" multiple="false" cssStyle="width: 180px;">
                    <form:option value="" label=""/>
                    <form:options items="${departmentList}"/>
                </form:select>
            </div>
            <div class="col-md-4">
                <form:errors path="department" cssClass="error"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2" style="color : white;">
                Car :
            </div>
            <div class="col-md-2">
                <form:select path="cars" multiple="false" cssStyle="width: 180px;">
                    <form:option value="" label=""/>
                    <form:options items="${carList}"/>
                </form:select>
            </div>
            <div class="col-md-4">
                <form:errors path="cars" cssClass="error"/>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2" style="color : white;">
                Address :
            </div>
            <div class="col-md-2">
                <form:select path="addressList" multiple="false" cssStyle="width: 180px;">
                    <form:option value="" label=""/>
                    <form:options items="${addressList}"/>
                </form:select>
            </div>
            <div class="col-md-4">
                <form:errors path="addressList" cssClass="error"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2">
            </div>
            <div class="col-md-2">
                <input type="submit" name="addEmployeeButton" value="Register"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2">
            </div>
            <div class="col-md-2">
                <button type="button" class="btn btn-primary"
                        onclick="window.location = '/Company/employees'">Back to employees
                </button>
            </div>
        </div>
    </form:form>
</div>

<%@ include file="util/footer.jsp" %>
</body>
</html>
