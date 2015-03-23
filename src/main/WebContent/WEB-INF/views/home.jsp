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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style.css'/>"/>
</head>
<body>
<%@ include file="util/header.jsp" %>
<div style="text-align: center;">
    <h1>Choose an action from the menu</h1>

    <div class="row" style="text-align: center;">
        <div class="col-md-1"></div>
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
        <div class="col-md-1"></div>
    </div>
    <br/><br/>

    <div class="row">
        <div class="col-md-12">
            <img src="<c:url value='/resources/logo1.jpg'/>" alt="CompanyLogo"/>
        </div>
    </div>
</div>
<%@ include file="util/footer.jsp" %>
</body>
</html>
