<%--
  Created by IntelliJ IDEA.
  User: Cristian.Dumitru
  Date: 3/11/2015
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Audit</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
<h1>Audit
    <small>all the changes made to entities!</small>
</h1>
<c:forEach items="${auditList}" var="audit">
    <div class="row" style="text-align: center;">
        <div class="col-md-2">
            <c:out value="${audit.id}"/>
        </div>
        <div class="col-md-2">
            <c:out value="${audit.objectId}"/>
        </div>
        <div class="col-md-2">
            <c:out value="${audit.objectType}"/>
        </div>
        <div class="col-md-2">
            <c:out value="${audit.action}"/>
        </div>
    </div>
</c:forEach>

<div class="row" style="text-align: center;">
    <div class="col-md-6"></div>
    <div class="col-md-2">
        <button type="button" class="btn btn-primary" onclick="history.go(-1).init();return true;">BACK</button>
    </div>
</div>
</body>
</html>
