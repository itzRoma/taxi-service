<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/WEB-INF/views/css/table_dark.css' %>
</style>
<html>
<head>
    <title>Create driver</title>
</head>
<body>
<%@ include file="../header.jsp"%>
<form method="post" id="driver" style="display: none"
      action="${pageContext.request.contextPath}/drivers/create"></form>
<h1 class="table_dark">
    Create driver:
    <span style="color: red">${errorMessage}</span>
</h1>
<table border="1" class="table_dark">
    <tr>
        <th>Name</th>
        <th>License number</th>
        <th>Login</th>
        <th>Password</th>
        <th>Action</th>
    </tr>
    <tr>
        <td>
            <input type="text" name="name" form="driver" required>
        </td>
        <td>
            <input type="text" name="license_number" form="driver" required>
        </td>
        <td>
            <input type="text" name="login" form="driver" required>
        </td>
        <td>
            <input type="password" name="password" form="driver" required>
        </td>
        <td>
            <button type="submit" form="driver">CREATE</button>
        </td>
    </tr>
</table>
</body>
</html>
