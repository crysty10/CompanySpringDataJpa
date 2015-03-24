<%--
  Created by IntelliJ IDEA.
  User: Cristian.Dumitru
  Date: 3/10/2015
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Employee</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style.css'/>"/>
</head>
<body>
<%--<%@ include file="util/header.jsp" %>--%>
<div class="formDiv">
    <h1>Update a Employee
        <small> --------> Change what field do you want!</small>
    </h1>
    <form:form method="POST" commandName="employee">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2" style="color:white;">
                <span>First name:</span>
            </div>
            <div class="col-md-2">
                <input type="text" name="firstname" value="<c:out value='${employee.firstname}'/>"/>
            </div>
            <div class="col-md-4">
                <form:errors path="firstname" cssClass="error"/>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2" style="color:white;">
                <span>Last name:</span>
            </div>
            <div class="col-md-2">
                <input type="text" name="lastname" value="<c:out value='${employee.lastname}'/>"/>
            </div>
            <div class="col-md-4">
                <form:errors path="lastname" cssClass="error"/>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2" style="color:white;">
                <span>Salary:</span>
            </div>
            <div class="col-md-2">
                <input type="text" name="salary" value="<c:out value='${employee.salary}'/>"/>
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
                    <form:option value="${employee.department.id}" label=""
                                 selected="selected">${employee.department.deptname}</form:option>
                    <c:forEach items="${departmentList}" var="department">
                        <form:option value="${department.id}">${department.deptname}</form:option>
                    </c:forEach>
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
                    <form:option value="${employee.cars}" label="" selected="selected">${employee.cars}</form:option>
                    <c:forEach items="${carList}" var="car">
                        <form:option value="${car.id}">${car.carName}</form:option>
                    </c:forEach>
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
                    <form:option value="${employee.addressList}" label=""
                                 selected="selected">${employee.addressList}</form:option>
                    <c:forEach items="${addressList}" var="address">
                        <form:option value="${address.id}">${address}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="col-md-4">
                <form:errors path="addressList" cssClass="error"/>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2">
                <button type="button" class="btn btn-primary"
                        onclick="window.location = '/Company/employees'">Back to employees
                </button>
            </div>
            <div class="col-md-2">
                <input type="submit" value="UPDATE"/>
            </div>
            <div class="col-md-4"></div>
        </div>
    </form:form>
</div>
<%@ include file="util/footer.jsp" %>
</body>
</html>
