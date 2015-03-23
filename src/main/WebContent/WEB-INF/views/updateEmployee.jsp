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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style.css'/>"/>
</head>
<body>
<%--<%@ include file="util/header.jsp" %>--%>
<div style="text-align: center;">
    <h1>Update a Employee
        <small>  -------->  Change what field do you want!</small>
    </h1>
    <form method="POST">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2" style="color:white;">
                <span>First name:</span>
            </div>
            <div class="col-md-2">
                <input type="text" name="firstname" value="<c:out value='${employee.firstname}'/>"/>
            </div>
            <div class="col-md-4"></div>
        </div>

        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2" style="color:white;">
                <span>Last name:</span>
            </div>
            <div class="col-md-2">
                <input type="text" name="lastname" value="<c:out value='${employee.lastname}'/>"/>
            </div>
            <div class="col-md-4"></div>
        </div>

        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2" style="color:white;">
                <span>Salary:</span>
            </div>
            <div class="col-md-2">
                <input type="text" name="salary" value="<c:out value='${employee.salary}'/>"/>
            </div>
            <div class="col-md-4"></div>
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
    </form>
</div>
<%@ include file="util/footer.jsp" %>
</body>
</html>
