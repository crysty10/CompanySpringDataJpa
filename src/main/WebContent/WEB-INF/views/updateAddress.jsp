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
    <title>Update Employee</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style.css'/>"/>
</head>
<body>
<%--<%@ include file="util/header.jsp" %>--%>
<center>
    <form method="POST" commandName="address">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2">
                <span>Street:</span>
            </div>
            <div class="col-md-2">
                <input type="text" name="street" value="<c:out value='${address.street}'/>"/>
            </div>
            <div class="col-md-4"></div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2">
                <span>Street nr.:</span>
            </div>
            <div class="col-md-2">
                <input type="text" name="street_nr" value="<c:out value='${address.street_nr}'/>"/>
            </div>
            <div class="col-md-4"></div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2">
                <span>Building:</span>
            </div>
            <div class="col-md-2">
                <input type="text" name="building" value="<c:out value='${address.building}'/>"/>
            </div>
            <div class="col-md-4"></div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2">
                <span>Floor:</span>
            </div>
            <div class="col-md-2">
                <input type="text" name="floor" value="<c:out value='${address.floor}'/>"/>
            </div>
            <div class="col-md-4"></div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2">
                <span>Locality:</span>
            </div>
            <div class="col-md-2">
                <input type="text" name="locality" value="<c:out value='${address.locality}'/>"/>
            </div>
            <div class="col-md-4"></div>
        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2">
                <span>Country:</span>
            </div>
            <div class="col-md-2">
                <input type="text" name="country" value="<c:out value='${address.country}'/>"/>
            </div>
            <div class="col-md-4"></div>
        </div>

        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-2">
                <button type="button" class="btn btn-primary"
                        onclick="window.location = '/Company/addresss'">Back to employees
                </button>
            </div>
            <div class="col-md-2">
                <input type="submit" value="UPDATE"/>
            </div>
            <div class="col-md-4"></div>
        </div>
    </form>
</center>
<%@ include file="util/footer.jsp" %>
</body>
</html>
