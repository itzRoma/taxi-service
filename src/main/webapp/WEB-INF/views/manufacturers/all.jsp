<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/WEB-INF/views/css/table_dark.css' %>
</style>
<html>
<head>
    <title>All manufacturers</title>
</head>
<body>
<%@ include file="../header.jsp"%>
<h1 class="table_dark">All manufacturers:</h1>
<table border="1" class="table_dark">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Country</th>
        <th>Action</th>
    </tr>
    <c:forEach var="manufacturer" items="${manufacturers}">
        <tr>
            <td>
                <c:out value="${manufacturer.id}"/>
            </td>
            <td>
                <c:out value="${manufacturer.name}"/>
            </td>
            <td>
                <c:out value="${manufacturer.country}"/>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/manufacturers/delete?id=${manufacturer.id}"
                      method="post" style="margin: 0">
                    <button type="submit">DELETE</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
