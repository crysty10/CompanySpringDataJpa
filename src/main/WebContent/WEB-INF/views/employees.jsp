<%--
  Created by IntelliJ IDEA.
  User: Cristian.Dumitru
  Date: 3/9/2015
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
    <link rel="stylesheet"
        type="text/css"
        href="<c:url value='/resources/style.css'/>">
</head>
<body>
<c:forEach items="${employeeList}" var="employee">
  <li id="employee_<c:out value='employee.id'/>">
    <div class="employeeDiv">
      <span class="employeeFirstname">
        <c:out value="${employee.firstname}"/>
      </span>
      <span class="employeeLastname">
        <c:out value="${employee.lastname}"/>
      </span>
      <span class="employeeSalary">
        <c:out value="${employee.salary}"/>
      </span>
    </div>
  </li>
</c:forEach>
</body>
</html>
