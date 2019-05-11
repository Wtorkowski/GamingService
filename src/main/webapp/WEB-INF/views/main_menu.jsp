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
    <title>Main Menu</title>
    <style>

    </style>
</head>
<body>
<jsp:include page="fragments/logged_user.jsp"/>
<div class="row">
    <div class="col-4"></div>
    <div class="col-4" align="center">
        <h1>Games</h1>
        <button onclick=window.location.href="/mastermind/home">Mastermind</button>
        <br>
        <br>
        <br>

        <h3>Options</h3>
        <c:if test="${isAnyGameHistory==false}">
            <p style="color: dimgrey"><c:out value="Finish one game to unlock stats"/></p>
        </c:if>
        <button
                <c:if test="${isAnyGameHistory==false}">disabled</c:if>
                onclick=window.location.href="/stats">Stats
        </button>
        <br>
        <br>
        <button onclick=window.location.href="/achievements">Achievements</button>
        <br>
        <br>
        <button onclick=window.location.href="/account_settings">Account settings</button>
        <br>
    </div>
    <div class="col-4"></div>
</div>
</body>
</html>
