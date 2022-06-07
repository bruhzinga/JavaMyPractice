<%@ page import="model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        form {
            display: inline-block;
            margin-right: 70px;
        }
        table {
            border: 1px solid black;
            border-collapse: collapse;
            min-width: 300px;
            background: #92eeff;
            text-align: center;
        }
    </style>
</head>
<body>
<table border="1">
    <tr>
        <th>Name</th><th>Email</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.name}</td>
            <td>${user.email}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
