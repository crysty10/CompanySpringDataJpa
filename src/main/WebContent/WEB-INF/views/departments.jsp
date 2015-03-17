<%--
  Created by IntelliJ IDEA.
  User: Cristian.Dumitru
  Date: 3/9/2015
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Department</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style.css'/>"/>
</head>
<body>
<h1>All the Company departments!
    <small>You can update data as well!</small>
</h1>

<c:forEach items="${departmentList}" var="department">
    <div class="row" style="text-align: center; color:white;">
        <div class="col-md-2">
            <c:out value="${department.id}"/>
        </div>
        <div class="col-md-2">
            <c:out value="${department.deptname}"/>
        </div>
        <div class="col-md-2">
            <input style="color:black;" type="submit" value="Update"
                   onclick="window.location = '/Company/departments/${department.id}'"/>
        </div>
        <div class="col-md-2" style="color:black;">
            <c:url var="deleteUrl" value="/departments/deleteDepartment"/>
            <form id="${departmentFormId}" action="${deleteUrl}" method="POST">
                <input id="employee" name="employee" type="hidden" value="${employee.id}"/>
                <input type="submit" value="Delete" onClick="return confirm('sure?')"/>
            </form>
        </div>
    </div>
</c:forEach>
<div class="row" style="text-align: center;">
    <div class="col-md-6"></div>
    <div class="col-md-2">
        <button type="button" class="btn btn-primary"
                onclick="window.location = '/Company'">Back to Company
        </button>
    </div>
</div>
<p><span style="font-size: 200%"><a style="color:blue;" href="<c:url value='/addDepartment'/>">Add</a> a new department</span>
</p>
</body>
</html>
