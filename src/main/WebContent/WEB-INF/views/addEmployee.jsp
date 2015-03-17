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
    <title>Add Employee</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style.css'/>"/>
</head>
<body>
<%@ include file="util/header.jsp" %>
<center>
    <form method="POST">
        <div class="row">
            <div class="col-md-2">
                <span>First name:</span>
            </div>
            <div class="col-md-2">
                <input type="text" name="firstname">
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                <span>Last name:</span>
            </div>
            <div class="col-md-2">
                <input type="text" name="lastname">
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                <span>Salary:</span>
            </div>
            <div class="col-md-2">
                <input type="text" name="salary">
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
            </div>
            <div class="col-md-2">
                <input type="submit" name="addEmployeeButton" value="Register"/>
                <button type="button" class="btn btn-primary"
                        onclick="window.location = '/Company/employees'">Back to employees
                </button>
            </div>
        </div>
    </form>
</center>
<%@ include file="util/footer.jsp" %>
</body>
</html>
