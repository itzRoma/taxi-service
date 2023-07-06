<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="table_dark" style="display: flex; justify-content: space-evenly; align-items: center; font-size: 15px">
    <h3><a href="${pageContext.request.contextPath}/index">Home</a></h3>
    <c:choose>
        <c:when test="${sessionScope.driverId == null}">
            <h3><a href="${pageContext.request.contextPath}/login">Login</a></h3>
            <h3><a href="${pageContext.request.contextPath}/drivers/add">Create an account</a></h3>
        </c:when>
        <c:otherwise>
            <h3><a href="${pageContext.request.contextPath}/logout">Logout</a></h3>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
