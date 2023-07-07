<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/WEB-INF/views/css/table_dark.css' %>
</style>
<html>
<head>
    <title>My team</title>
</head>
<body>
<%@ include file="header.jsp"%>
<h1 class="table_dark">Hello, mates</h1>
<table class="table_dark">
    <tr>
        <th>Redirect to</th>
    </tr>
    <tr><td><a href="${pageContext.request.contextPath}/manufacturers">Display all Manufacturers</a></td></tr>
    <tr><td><a href="${pageContext.request.contextPath}/manufacturers/create">Create new Manufacturer</a></td></tr>
    <tr><td><a href="${pageContext.request.contextPath}/drivers">Display all Drivers</a></td></tr>
    <tr><td><a href="${pageContext.request.contextPath}/drivers/create">Create new Driver</a></td></tr>
    <tr><td><a href="${pageContext.request.contextPath}/cars">Display all Cars</a></td></tr>
    <tr><td><a href="${pageContext.request.contextPath}/cars/my">Display my Cars</a></td></tr>
    <tr><td><a href="${pageContext.request.contextPath}/cars/create">Create new Car</a></td></tr>
    <tr><td><a href="${pageContext.request.contextPath}/cars/drivers/add">Add Driver to Car</a></td></tr>
</table>
</body>
</html>
