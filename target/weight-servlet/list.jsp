<%--suppress ALL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="https://cdn.anychart.com/releases/v8/js/anychart-base.min.js"></script>
    <script src="https://cdn.anychart.com/releases/v8/js/anychart-exports.min.js"></script>
    <script src="https://cdn.anychart.com/releases/v8/js/anychart-vml.min.js"></script>
    <link rel="stylesheet" href="https://cdn.anychart.com/releases/v8/css/anychart-ui.min.css" />
    <link rel="stylesheet" href="https://cdn.anychart.com/releases/v8/fonts/css/anychart.min.css"/>
    <script src="jquery-3.3.1.min.js"></script>
    <script> $(".clickable tr").click(function(){
        location.assign("/details.jsp");
    });</script>
    <title>Your Weight Log v.2</title>
</head>

<c:if test="${not empty msgToUser}">
    <h3><c:out value="${msgToUser}"/></h3>
</c:if>

<!-- table of weights -->
<table class="table table-hover">
    <tr>
        <th>Id</th>
        <th>Date</th>
        <th>Weight</th>
        <th>Details</th>
        <th>Remove</th>
    </tr>
<c:forEach items="${weightList}" var="weight">
    <tr class="clickable-row" >
        <td><c:out value="${weight.getId()}"/></td>
        <td><c:out value="${weight.getDate()}"/></td>
        <td><c:out value="${weight.getName()}"/></td>
        <td><c:out value="${weight.getWeight()}"/></td>
        <td><a href="details?weightId=${weight.getId()}" >See details</a> </td>
        <td><a href="remove?weightId=${weight.getId()}" >Remove</a> </td>
    </tr>
</c:forEach>
    <tr>
        <td colspan="6">

        </td>
    </tr>
</table>

<!-- chart container -->
<div id="container" style="height: 70%"></div>
<script>
    anychart.onDocumentLoad(function() {
        var data = anychart.data.set(${chartData}).mapAs({x: "Value", value: 2});
        var chart = anychart.line();
        var series = chart.line(data);
        series.markers(true);
        series.labels(true);
        series.normal().stroke("#0066cc", 3);

        chart.background().enabled(true);
        chart.background().fill("#ffab00");

        //series1.labels().background.enabled(true);
        //series1.labels().background.fill("#ffd642 0.8");

        chart.title("${chartTitle}");
        chart.container("container");
        chart.draw();
    });
</script>

<!-- add value button -->
<a href="add" >Add new weight entry</a>




<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

</body>
</html>
