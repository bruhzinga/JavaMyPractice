<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.06.2020
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${resultArr}" var="item">
    ${item}<br>
</c:forEach>
<form action="result.jsp">
    <input type="submit" value="Назад">
</form>
</body>
</html>
