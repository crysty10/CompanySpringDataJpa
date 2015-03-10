<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <style>
            body {
                background-size: 100%;
                background: url(http://businessgross.com/wp-content/uploads/2013/05/Employee.png) no-repeat;

                font-family: sans-serif;
                color: black;
            }
        </style>
    </head>
    <body>

    <c:forEach items="${employeesList}" var="emp" >

        <li id="emp_<c:out value= 'emp.id' />" >

            <div class="Employee's name">
                (<c:out value="${emp.firstname}" />,<c:out value="${emp.lastname}" />)
            </div>
        </li>
    </c:forEach>

    <form>
        <input Type="button" value="Back home" onClick="history.go(-1);return true;">
    </form>
    </body>
</html>



