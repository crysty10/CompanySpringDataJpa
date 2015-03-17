<%--
  Created by IntelliJ IDEA.
  User: Cristian.Dumitru
  Date: 3/10/2015
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .error {
            color: #ff0000;
        }
    </style>
    <title>Add Employee</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value='/resources/style.css'/>">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>

<form:form method="POST" commandName="employee" action="addEmployee">

    <table>
        <tr>
            <td>First name :</td>
            <td><form:input path="firstname"/></td>
            <td><form:errors path="firstname" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Last name :</td>
            <td><form:input path="lastname"/></td>
            <td><form:errors path="lastname" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Salary :</td>
            <td><form:input path="salary"/></td>
            <td><form:errors path="salary" cssClass="error"/></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" name="addEmployeeButton" value="Register"/></td>
        </tr>
        <tr>
            <td colspan="3">
                <button type="button" class="btn btn-primary"
                        onclick="window.location = '/Company/employees'">Back to employees
                </button>
            </td>

        </tr>
    </table>
</form:form>

<%--<form method="POST" modelAttribute="employee">--%>

<%--<form:errors path="*" cssClass="error" element="div" />--%>
<%--<form:label path="firstname">First name:</form:label>--%>
<%--<form:input path="firstname" id="firstname" />--%>
<%--<form:errors path="firstname" />--%>
<%--<form:label path="lastname">Last name:</form:label>--%>
<%--<form:input path="lastname" id="lastname" />--%>
<%--<form:errors path="lastname" />--%>
<%--<form:label path="salary">Salary:</form:label>--%>
<%--<form:input path="salary" id="salary" />--%>
<%--<form:errors path="salary" />--%>


<%--<div class="row">--%>
<%--<div class="col-md-2">--%>
<%--<span>First name:</span>--%>
<%--</div>--%>
<%--<div class="col-md-2">--%>
<%--<input type="text" name="firstname">--%>
<%--</div>--%>
<%--</div>--%>
<%--<div class="row">--%>
<%--<div class="col-md-2">--%>
<%--<span>Last name:</span>--%>
<%--</div>--%>
<%--<div class="col-md-2">--%>
<%--<input type="text" name="lastname">--%>
<%--</div>--%>
<%--</div>--%>
<%--<div class="row">--%>
<%--<div class="col-md-2">--%>
<%--<span>Salary:</span>--%>
<%--</div>--%>
<%--<div class="col-md-2">--%>
<%--<input type="text" name="salary">--%>
<%--</div>--%>
<%--</div>--%>
<%--<div class="row">--%>
<%--<div class="col-md-2">--%>
<%--</div>--%>
<%--<div class="col-md-2">--%>
<%--<input type="submit" name="addEmployeeButton" value="Register"/>--%>
<%--<button type="button" class="btn btn-primary"--%>
<%--onclick="window.location = '/Company/employees'">Back to employees--%>
<%--</button>--%>
<%--</div>--%>
<%--</div>--%>


<%--</form>--%>

</body>
</html>
