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
</head>
<body>
<h1>Welcome to your Company project homepage!</h1>
<a href="<c:url value='/employees' />">Employees</a> |
<a href="<c:url value='/departments' />">Departments</a> |
<a href="<c:url value='/cars' />">Cars</a> |
<a href="<c:url value='/addresses' />">Address</a> |
<a href="<c:url value='/audit' />">Audit</a>
</body>
</html>