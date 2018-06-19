<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>Your Weight Log</title>
</head>

<c:if test="${not empty msgToUser}">
    <h3><c:out value="${msgToUser}"/></h3>
</c:if>

<table class="w3-table">
    <tr>
        <th>Id</th>
        <th>Date</th>
        <th>Weight</th>
    </tr>
<c:forEach items="${weightList}" var="weight">
    <tr>
        <td><c:out value="${weight.getId()}"/></td>
        <td><c:out value="${weight.getDate()}"/></td>
        <td><c:out value="${weight.getWeight()}"/></td>
    </tr>
</c:forEach>
</table>

<a href="add" >Add new weight entry</a>

</body>
</html>
