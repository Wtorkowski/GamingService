<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bart
  Date: 17.02.19
  Time: 09:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="fragments/header-link.jsp"/>
    <title>Stats</title>
    <style>

    </style>
</head>
<body>
<jsp:include page="fragments/logged_user.jsp"/>
<div class="row">
    <div class="col-4"></div>
    <div class="col-4" align="center">
        <c:if test="${isAnyGameFinished==false}">Finish at least one game to check your stats.</c:if>
        <c:if test="${isAnyGameFinished==true}">
            <h2>Your Mastermind statistics:</h2>
            <table>
                <tr>
                    <td><c:out value="Total number of games finished:"/></td>
                    <td> ${statistics.gamesTotal}</td>
                </tr>
                <tr>
                    <td><c:out value="Total time played:"/></td>
                    <td> ${statistics.durationTotal}</td>
                </tr>
                <tr>
                    <td><c:out value="Average attempts per game:"/></td>
                    <td> ${statistics.averageAttempts}</td>
                </tr>
                <tr>
                    <td><c:out value="Average game duration (to whole seconds):"/></td>
                    <td> ${statistics.averageDuration}</td>
                </tr>
                <c:forEach items="${statistics.topScores}" var="gh">
                    <tr>
                        <th colspan="2"><c:out value="Top score for ${gh.difficulty} difficulty:"/></th>
                    </tr>
                    <tr>
                        <td><c:out value="Number of attempts:"/></td>
                        <td>${gh.attempts}</td>
                    </tr>
                    <tr>
                        <td><c:out value="Duration:"/></td>
                        <td>${gh.duration}</td>
                    </tr>
                    <tr>
                        <td><c:out value="Finished on:"/></td>
                        <td>${gh.updated}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <br>
        <br>
        <button onclick=window.location.href="/main_menu">Return to Main menu</button>
    </div>
    <div class="col-4"></div>
</div>


</body>
</html>
