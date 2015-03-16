<%--
  Created by IntelliJ IDEA.
  User: Cristian.Dumitru
  Date: 3/10/2015
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add department</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <style>
        h1, h3, a, p, span, small {
            color : white;
        }
        body {
            background-image: url(http://cdn.hdwallpaperspics.com/uploads/2012/11/Apple-20Vector-20Desktop-20Ful-20HD-20Background1.jpg);
            text-color : white;
            background-size: 100%;
        }
    </style>
</head>
<body>

<form method="POST">

    <div class="row">
        <div class="col-md-2">
            <span>Department's name:</span>
        </div>
        <div class="col-md-2">
            <input type="text" name="deptname">
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
</form>

</body>
</html>
