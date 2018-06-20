<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="logger.weight.service.WeightService" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>Add new weight entry</title>
</head>
<body>

  <h1>Add new weight entry</h1>

  <form method="post" action="/weight-servlet/" class="w3-container">
    <label>Weight note</label>
    <input type="text" name="weightName" class="w3-input" />

    <label>Your Weight</label>
    <input type="number" name="weight" step="0.1" class="w3-input"/>

    <label>Description of weight</label>
    <textarea name="weightDescription" rows="4" cols="50" class="w3-input"></textarea>

    <input type="date" name="date" pattern="dd-MM-YYYY">

    <input type="submit" value="Add weight record " class="w3-btn"/>
    <a href="/weight-servlet" class="w3-btn w3-blue-grey">Back to list</a>
  </form>
</body>
</html>
