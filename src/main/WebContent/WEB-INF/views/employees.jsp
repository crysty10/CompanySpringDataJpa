<%--
  Created by IntelliJ IDEA.
  User: Cristian.Dumitru
  Date: 3/9/2015
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
<h1>All the Company employees!
    <small>You can update data as well!</small>
</h1>
<c:forEach items="${employeeList}" var="employee">
    <div class="row" style="text-align: center;">
        <div class="col-md-2">
            <c:out value="${employee.id}"/>
        </div>
        <div class="col-md-2">
            <c:out value="${employee.firstname}"/>
        </div>
        <div class="col-md-2">
            <c:out value="${employee.lastname}"/>
        </div>
        <div class="col-md-2">
            <c:out value="${employee.salary}"/>
        </div>
        <div class="col-md-2">
            <a href="<c:url value='/employees/${employee.id}' />">Update</a>
        </div>

        <div class="col-md-2">
            <input type="submit" value="DELETE" name="deleteEmployee"/>
        </div>
    </div>
</c:forEach>
<div class="row" style="text-align: center;">
    <div class="col-md-4">
        <p>You can <a href="<c:url value='/addEmployee'/>">add</a> a new employee!</p>
    </div>
</div>
<div class="row" style="text-align: center;">
    <div class="col-md-8"></div>
    <div class="col-md-2">
        <input type="submit" name="backEmployee" value="back" onclick="<c:url value="/home"/>"/>
    </div>
</div>
</body>
</html>
