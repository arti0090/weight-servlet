<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="https://cdn.anychart.com/releases/v8/js/anychart-base.min.js"></script>
    <script src="https://cdn.anychart.com/releases/v8/js/anychart-exports.min.js"></script>
    <script src="https://cdn.anychart.com/releases/v8/js/anychart-vml.min.js"></script>
    <link rel="stylesheet" href="https://cdn.anychart.com/releases/v8/css/anychart-ui.min.css" />
    <link rel="stylesheet" href="https://cdn.anychart.com/releases/v8/fonts/css/anychart.min.css"/>
    <title>Your Weight Log</title>
</head>

<c:if test="${not empty msgToUser}">
    <h3><c:out value="${msgToUser}"/></h3>
</c:if>

<table class="w3-table">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Weight</th>
    </tr>
<c:forEach items="${weightList}" var="weight">
    <tr>
        <td><c:out value="${weight.getId()}"/></td>
        <td><c:out value="${weight.getName()}"/></td>
        <td><c:out value="${weight.getWeight()}"/></td>
    </tr>
</c:forEach>
    <tr>
        <td colspan="6">
            <div id="container"></div>
            <script>
                anychart.onDocumentLoad(function() {
                    var data = anychart.data.set(${chartData});
                    var chart = anychart.line(data);
                    var seriesData1 = data.mapAs({x: 0, value: 1});
                    var series1 = chart.line(seriesData1);
                    series1.markers(true);
                    series1.labels(true);

                    //series1.labels().background.enabled(true);
                    //series1.labels().background.fill("#ffd642 0.8");

                    chart.title("${chartTitle}");
                    chart.container("container");
                    chart.draw();
                });
            </script>
        </td>
    </tr>
</table>

<a href="add" >Add new weight entry</a>

</body>
</html>
