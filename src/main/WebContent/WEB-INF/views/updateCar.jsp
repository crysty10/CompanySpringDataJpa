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
    <title>Update Car</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style.css'/>"/>
</head>
<body>
<%--<%@ include file="util/header.jsp" %>--%>
<div class="formDiv">
    <form:form method="POST" commandName="car">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2">
                <span>Car's name:</span>
            </div>
            <div class="col-md-2">
                <input type="text" name="carName" value="<c:out value='${car.carName}'/>">
            </div>
            <div class="col-md-4"></div>
        </div>

        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2">
                <span>Car's model:</span>
            </div>
            <div class="col-md-2">
                <input type="text" name="carModel" value="<c:out value='${car.carModel}'/>">
            </div>
            <div class="col-md-4"></div>
        </div>

        <%--<div class="row">--%>
            <%--<div class="col-md-4"></div>--%>
            <%--<div class="col-md-2" style="color : white;">--%>
                <%--Employee :--%>
            <%--</div>--%>
            <%--<div class="col-md-2">--%>
                <%--<form:select path="employees" multiple="false" cssStyle="width: 180px;">--%>
                    <%--<form:option value="${employee.id}" label=""--%>
                                 <%--selected="selected">${employee.firstname} ${employee.lastname}</form:option>--%>
                    <%--<c:forEach items="${employeeList}" var="employee">--%>
                        <%--<form:option value="${employee.id}">${employee.firsrtname} ${employee.lastname}</form:option>--%>
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
                <button type="button" class="btn btn-primary"
                        onclick="window.location = '/Company/cars'">Back to cars
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
