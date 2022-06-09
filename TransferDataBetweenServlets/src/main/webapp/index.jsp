<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Onya
  Date: 23.06.2020
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <form action="set" method="get">
        <input type="submit" value="set">
    </form>
    <form action="get" method="post">
        <input type="submit" value="get">
    </form>

    <form action="setAttribute" method="get">
        <input type="submit" value="getAttribute">
    </form>




   <c:if test="${str != null}">
       <c:out value = "${str}"/>
   </c:if>
</body>
</html>
