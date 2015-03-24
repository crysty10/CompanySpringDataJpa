<%--
  Created by IntelliJ IDEA.
  User: Cristian.Dumitru
  Date: 3/10/2015
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Department</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style.css'/>"/>
</head>
<body>
<%--<%@ include file="util/header.jsp" %>--%>
<div class="formDiv">
    <h1>Update a Department
        <small> --------> Change what field do you want!</small>
    </h1>
    <form:form method="POST" commandName="department" modelAttribute="department">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2">
                <span>Department's name:</span>
            </div>
            <div class="col-md-2">
                <input type="text" name="deptname" value="<c:out value='${department.deptname}'/>">
            </div>
            <div class="col-md-4">
                <form:errors path="deptname" cssClass="error"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2">
                <button type="button" class="btn btn-primary"
                        onclick="window.location = '/Company/departments'">Back to departments
                </button>
            </div>
            <div class="col-md-2">
                <input type="submit" value="UPDATE"/>
            </div>
            <div class="col-md-4"></div>
        </div>
    </form:form>
</div>
<%@ include file="util/footer.jsp" %>
</body>
</html>
