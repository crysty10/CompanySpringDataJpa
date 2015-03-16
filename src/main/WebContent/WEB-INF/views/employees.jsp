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
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value='/resources/style.css'/>">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
<h1>All the Company employees!
    <small>  -----------------------  You can update data as well!</small>
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
                <%--<input type="submit" name = "deleteEmployee" id = "deleteEmployee" onclick="return confirm('Are you sure you want to delete this item?');" value="Delete"/>--%>
                <%--<a href="<c:url value='/employees/${employee.id}'/>">Delete</a>--%>
                <%--<input type="submit" name="deleteEmployee" id="deleteEmployee" value="DELETE"/>--%>
                <%--<input type='button' onclick='confirmation(47)' value='Delete'>--%>
                    <a href="<c:url value='/employees/${employee.id}'/>">Delete</a>
        </div>
    </div>
</c:forEach>
<div class="row" style="text-align: center;">
    <div class="col-md-8"></div>
    <div class="col-md-2">
        <button type="button" class="btn btn-primary"
                onclick="window.location = '/Company'">Back to Company
        </button>
    </div>
</div>
<p><span style="color: red; font-size: 200%"><a href="<c:url value='/addEmployee'/>">Add</a> a new employee</span></p>
</body>
</html>
