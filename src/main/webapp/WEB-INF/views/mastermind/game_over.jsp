<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bart
  Date: 28.04.19
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mastermind game over</title>
</head>
<body>
<h1>Congratulation ${finishedGame.user.userName} !</h1>

<c:out value="The correct combination was:${finishedGame.encrypted}."/><br>
<c:out value="You have guessed the combination after ${finishedGame.attempts} attempts in ${finishedGame.duration}."/>


<table style="text-align: center">
    <tr>
        <th>Position</th>
        <th>Name</th>
        <th>Attempts</th>
        <th>Duration</th>
        <th>When</th>

    </tr>
    <c:forEach items="${topScores}" var="el" varStatus="status">
        <tr<c:if test="${el.user == finishedGame.user && el.updated == finishedGame.updated}">
            style="background-color: deepskyblue" </c:if>>
            <td>${status.count}</td>
            <td> ${el.user.userName}</td>
            <td>${el.attempts}</td>
            <td>${el.duration}</td>
            <td>${el.updated}</td>
        </tr>
    </c:forEach>
</table>

<button onclick=window.location.href="/mastermind/home">Return to Mastermind menu</button>
</body>
</html>
