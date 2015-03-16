<%--
  Created by IntelliJ IDEA.
  User: Cristian.Dumitru
  Date: 3/9/2015
  Time: 1:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>CompanySpringDataJpa</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value='/resources/style.css'/>">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
<h1>Welcome to your Company project homepage
    <small>Developed by DCG and CFA!</small>
</h1>
<div class="row" style="text-align: center;">
    <div class="col-md-2">
        <a href="<c:url value='/employees' />">Show employees</a>
    </div>
    <div class="col-md-2">
        <a href="<c:url value='/departments' />">Show departments</a>
    </div>
    <div class="col-md-2">
        <a href="<c:url value='/cars' />">Show cars</a>
    </div>
    <div class="col-md-2">
        <a href="<c:url value='/addresss' />">Show addresses</a>
    </div>
    <div class="col-md-2">
    <a href="<c:url value='/audit' />">Show audit</a>
    </div>
</div>
</body>
</html>
