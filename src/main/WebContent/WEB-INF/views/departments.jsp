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
    <small>You can update data as well!</small>
</h1>
<c:forEach items="${departmentList}" var="dept">
    <%--<li id="dept_<c:out value='dept.id'/>">--%>
    <div class="row" style="text-align: center;">
        <div class="col-md-2">
            <c:out value="${dept.id}"/>
        </div>
        <div class="col-md-2">
            <c:out value="${dept.deptname}"/>
        </div>
        <div class="col-md-2">
            <%--<input type="button" value="UPDATE" onclick="history.go(-1);return true;"/>--%>
            <button type="button" class="btn btn-danger">UPDATE</button>
        </div>
    </div>
    <%--</li>--%>
</c:forEach>
<div class="row" style="text-align: center;">
    <div class="col-md-4"></div>
    <div class="col-md-2">
        <button type="button" class="btn btn-primary" onclick="history.go(-1);return true;">BACK</button>
    </div>
</div>
</body>
</html>
