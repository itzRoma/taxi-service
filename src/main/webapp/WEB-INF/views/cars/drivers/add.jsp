<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/WEB-INF/views/css/table_dark.css' %>
</style>
<html>
<head>
    <title>Add driver to car</title>
</head>
<body>
<%@ include file="../../header.jsp"%>
<form method="post" id="car" style="display: none"
      action="${pageContext.request.contextPath}/cars/drivers/add"></form>
<h1 class="table_dark">
    Add driver to car:
    <span style="color: red">${errorMessage}</span>
</h1>
<table border="1" class="table_dark">
    <tr>
        <th>Car</th>
        <th>Driver</th>
        <th>Action</th>
    </tr>
    <tr>
        <c:choose>
            <c:when test="${cars.isEmpty()}">
                <td>NO CARS FOUND</td>
            </c:when>
            <c:otherwise>
                <td>
                    <select name="car_id" form="car">
                        <c:forEach var="car" items="${cars}">
                            <option value="${car.id}">${car.model} (${car.manufacturer.name})</option>
                        </c:forEach>
                    </select>
                </td>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${drivers.isEmpty()}">
                <td>NO DRIVERS FOUND</td>
            </c:when>
            <c:otherwise>
                <td>
                    <select id="all_drivers" name="driver_id" form="car">
                        <c:forEach var="driver" items="${drivers}">
                            <option value="${driver.id}">${driver.name} (${driver.licenseNumber})</option>
                        </c:forEach>
                    </select>
                </td>
            </c:otherwise>
        </c:choose>
        <c:if test="${!cars.isEmpty() && !drivers.isEmpty()}">
            <td>
                <button type="submit" form="car">ADD</button>
            </td>
        </c:if>
    </tr>
</table>
</body>
</html>
