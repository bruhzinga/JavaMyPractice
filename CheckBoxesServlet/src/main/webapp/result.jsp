<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.06.2020
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result jsp</title>
</head>
<body>
<form action="go" method="get">
    <c:forEach items="${Candidates}" var="item">
        <input type="checkbox" name="checkboxes" value="${item}">${item}<br>
    </c:forEach>
    <input type="submit" value="Go">
</form>
</body>
</html>
