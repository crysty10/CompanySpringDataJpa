<%--
  Created by IntelliJ IDEA.
  User: Cristian.Dumitru
  Date: 3/9/2015
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Department</title>
    <link rel="stylesheet"
        type="text/css"
        href="<c:url value='/resources/style.css'/>">
</head>
<body>
<c:forEach items="${departmentList}" var="dept">
  <li id="dept_<c:out value='dept.id'/>">
    <div class="deptDiv">
      <span class="deptName">
        <c:out value="${dept.deptname}"/>
      </span>
    </div>
  </li>
</c:forEach>
</body>
</html>
