<%--
  Created by IntelliJ IDEA.
  User: Cristian.Dumitru
  Date: 3/11/2015
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Audit</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value='/resources/style.css'/>">
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
    <button type="button" class="btn btn-primary"
            onclick="window.location = '/Company'">Back to company
    </button>
</div>
</body>
</html>
