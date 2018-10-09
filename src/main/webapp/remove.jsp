<%--
  Created by IntelliJ IDEA.
  User: tomic
  Date: 10.06.18
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title></title>
</head>
<body>
<form method="post" action="/weight-servlet/remove" class="w3-container">
  <input type="hidden" name="weightToRemoveId" value="${weightId}"/>

  <h1>Are you sure?</h1>
  <input type="submit" value="YES Remove!" />
  <a href="/weight-servlet">NO</a>
</form>
</body>
</html>
