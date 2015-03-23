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
    <title>Employees</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style.css'/>"/>
</head>
<body>
<%--<%@ include file="util/header.jsp" %>--%>
<div style="text-align: center;">
    <h1>All the Company employees!
        <small>  ------->  You can update data as well!</small>
    </h1>
    <c:forEach items="${employeeList}" var="employee">
        <div class="row" style="text-align: center; color:white;">
            <div class="col-md-1">
                <c:out value="${employee.id}"/>
            </div>
            <div class="col-md-2">
                <c:out value="${employee.firstname}"/>
            </div>
            <div class="col-md-2">
                <c:out value="${employee.lastname}"/>
            </div>
            <div class="col-md-1">
                <c:out value="${employee.salary}"/>
            </div>
            <div class="col-md-2">
                <c:out value="${employee.department}"/>
            </div>
            <div class="col-md-2">
                <input style="color:black;" type="submit" value="Update"
                       onclick="window.location = '/Company/employees/${employee.id}'"/>
            </div>
            <div class="col-md-2" style="color:black;">
                <c:url var="deleteUrl" value="employees"/>
                <form id="${employeeFormId}" action="${deleteUrl}" method="POST">
                    <input id="employee" name="employee" type="hidden" value="${employee.id}"/>
                    <input type="submit" value="Delete"
                           onClick="return confirm('Are you sure you want to delete this employee?')"/>
                </form>
            </div>
        </div>
    </c:forEach>
    <div class="row" style="text-align: center;">
        <div class="col-md-10"></div>
        <div class="col-md-2">
            <button type="button" class="btn btn-primary"
                    onclick="window.location = '/Company'">Back to Company
            </button>
        </div>
    </div>
    <p><span style="font-size: 200%"><a style="color:blue;"
                                        href="<c:url value='/addEmployee'/>">Add</a> a new employee</span></p>
</div>
<%@ include file="util/footer.jsp" %>
</body>
</html>
