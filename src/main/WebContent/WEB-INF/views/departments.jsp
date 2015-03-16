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
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value='/resources/style.css'/>">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
<h1>All the Company departments!
    <small>                 You can update data as well!</small>
</h1>

<c:forEach items="${departmentList}" var="department">
    <div class="row" style="text-align: center;">
        <div class="col-md-2">
            <c:out value="${department.id}"/>
        </div>
        <div class="col-md-2">
            <c:out value="${department.deptname}"/>
        </div>
        <div class="col-md-2">
            <a href="<c:url value='/departments/${department.id}' />">Update</a>
        </div>
        <div class="col-md-2">
                <a href="<c:url value='/departments/${department.id}'/>">Delete</a>
        </div>
    </div>
</c:forEach>
<div class="row" style="text-align: center;">
    <div class="col-md-4"></div>
    <button type="button" class="btn btn-primary"
            onclick="window.location = '/Company'">Back to Company
    </button>
</div>
<p><span style="color: red; font-size: 200%"><a href="<c:url value='/addDepartment'/>">Add</a> a new department</span></p>
</body>
</html>
