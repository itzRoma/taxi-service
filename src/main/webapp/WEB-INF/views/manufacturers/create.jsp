<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/WEB-INF/views/css/table_dark.css' %>
</style>
<html>
<head>
    <title>Create manufacturer</title>
</head>
<body>
<%@ include file="../header.jsp"%>
<form method="post" id="manufacturer" style="display: none"
      action="${pageContext.request.contextPath}/manufacturers/create"></form>
<h1 class="table_dark">Create manufacturer:</h1>
<table border="1" class="table_dark">
    <tr>
        <th>Name</th>
        <th>Country</th>
        <th>Action</th>
    </tr>
    <tr>
        <td>
            <input type="text" name="name" form="manufacturer" required>
        </td>
        <td>
            <input type="text" name="country" form="manufacturer" required>
        </td>
        <td>
            <button type="submit" form="manufacturer">CREATE</button>
        </td>
    </tr>
</table>
</body>
</html>
