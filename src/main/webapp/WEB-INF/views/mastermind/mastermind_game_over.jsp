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
    <jsp:include page="../fragments/header-link.jsp"/>

    <title>Mastermind game over</title>
</head>
<body>
<jsp:include page="../fragments/logged_user.jsp"/>
<div class="row">
    <div class="col-1"></div>
    <div class="col-10" align="center">

        <h1>Congratulations ${username} !</h1>

        <c:out value="The correct combination is: ${finishedGame.encrypted}."/><br>
        <c:out value="You have guessed the combination after: ${finishedGame.attempts} attempts in: ${finishedGame.duration}."/><br>
        <br>
        <br>
       <h2> <c:out value="Top 10 scores for difficulty level: ${finishedGame.difficulty}"/></h2>
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
                    <td> ${el.user.username}</td>
                    <td>${el.attempts}</td>
                    <td>${el.duration}&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;${el.updated}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <button class="btn btn-warning btn3d" onclick=window.location.href="/mastermind/home">Play again</button>
        <br>
        <br>
        <button class="btn btn-info btn3d" onclick=window.location.href="/main_menu">Return to Main menu</button>
    </div>
    <div class="col-1"></div>
</div>
</body>
</html>
