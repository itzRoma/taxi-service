<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/WEB-INF/views/css/table_dark.css' %>
</style>
<html>
<head>
    <title>Create car</title>
</head>
<body>
<%@ include file="../header.jsp"%>
<form method="post" id="car" style="display: none"
      action="${pageContext.request.contextPath}/cars/create"></form>
<h1 class="table_dark">Create car:</h1>
<table border="1" class="table_dark">
    <tr>
        <th>Model</th>
        <th>Manufacturer</th>
        <th>Action</th>
    </tr>
    <tr>
        <td>
            <input type="text" name="model" form="car" required>
        </td>
        <c:choose>
            <c:when test="${manufacturers.isEmpty()}">
                <td>NO MANUFACTURERS FOUND</td>
            </c:when>
            <c:otherwise>
                <td>
                    <select id="car_manufacturer" name="manufacturer_id" form="car">
                        <c:forEach var="manufacturer" items="${manufacturers}">
                            <option value="${manufacturer.id}">${manufacturer.name} (${manufacturer.country})</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <button type="submit" form="car">CREATE</button>
                </td>
            </c:otherwise>
        </c:choose>
    </tr>
</table>
</body>
</html>
