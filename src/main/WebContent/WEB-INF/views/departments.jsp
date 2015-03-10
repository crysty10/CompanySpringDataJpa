<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <style>
            body {
                background-image: url(http://www.ahisd.net/images/departments%20wordle1.jpg);
                background-size: 100%;
                font-family: sans-serif;
                color: black;
            }
        </style>
    </head>
    <body>

    <c:forEach items="${departmentsList}" var="dept" >

        <li id="dept_<c:out value= 'dept.id' />" >

            <div class="Department's name"> <c:out value="${dept.deptname}" /></div>

        </li>
    </c:forEach>

    <form>
        <input Type="button" value="Back home" onClick="history.go(-1);return true;">
    </form>
    </body>

</html>



