<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello!" %>
</h1>
<br/>
<form action="hello-servlet" method="post">
    <input type="text" name="name">
    <input type="text" name="email">
    <input type="text" name="phone" >
    <input type="submit" value="Submit"/>
</form>
</body>
</html>