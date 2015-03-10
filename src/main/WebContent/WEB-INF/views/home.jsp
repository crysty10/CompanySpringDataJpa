<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
    <title>Company</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />" >
    <style>
        body {
            background-image: url(http://rexohome.com/wp-content/uploads/2011/04/The-Architecture-Design-of-Blaas-General-Partnership-570x405.jpg);
            background-size: auto;
            font-family: sans-serif;
            color: white;
        }
    </style>
</head>
<body>
<h1>Welcome to Company</h1>
<a href="<c:url value="/employees" />">Show all employees</a>
<a href="<c:url value="/departments" />">Show all departments</a>
<a href="<c:url value="/cars" />">Show all cars</a>
<a href="<c:url value="/address" />">Show all addresses</a>
</body>
</html>
