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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <style>
        h1, a, p, h1 > small {
            color: white;
        }
        body {
            background-image: url(http://cdn.hdwallpaperspics.com/uploads/2012/11/Apple-20Vector-20Desktop-20Ful-20HD-20Background1.jpg);
            background-size: 100%;
        }
    </style>
</head>
<body>
<h1>Audit
    <small>used to see all the changes made to every entities from database!</small>
</h1>
<c:forEach items="${auditList}" var="audit">
    <div class="row" style="text-align: center; color:white;">
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
        <button type="button" class="btn btn-primary"
                onclick="window.location = '/Company'">Back to company
        </button>
    </div>
</div>
</body>
</html>
