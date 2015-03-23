<%--
  Created by IntelliJ IDEA.
  User: Cristian.Dumitru
  Date: 3/10/2015
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add department</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value='/resources/style.css'/>">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <style>
        .error {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>
<%--<%@ include file="util/header.jsp" %>--%>
<div style="text-align: center;">
    <form method="POST">
        <div class="row">
            <div class="col-md-2">
                <span>Department's name:</span>
            </div>
            <div class="col-md-2">
                <input type="text" name="deptname">
            </div>

            <form:form method="POST" modelAttribute="department">

            <div class="row">
                <div class="col-md-2">
                    <span>Department's name:</span>
                </div>
                <div class="row">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-2">
                        <input type="submit" name="addDepartmentButton" value="Register"/>
                        <button type="button" class="btn btn-primary"
                                onclick="window.location = '/Company/departments'">Back to departments
                        </button>
                    </div>
                </div>
    </form>
</div>
<%@ include file="util/footer.jsp" %>
<div class="col-md-2">
    <form:errors path="deptname" cssClass="error"/>
</div>
</div>

<div class="row">
    <div class="col-md-2">
    </div>
    <div class="col-md-2">
        <input type="submit" name="addDepartmentButton" value="Register"/>
        <button type="button" class="btn btn-primary"
                onclick="window.location = '/Company/departments'">Back to departments
        </button>
    </div>
</div>
</form:form>

</body>
</html>
