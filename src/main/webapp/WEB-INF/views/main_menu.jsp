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
    <div class="col-5"></div>
    <div class="col-2 lightBlue bottomLeftCornerRounded bottomRightCornerRounded" align="center">
        <h1 class="menu3dtext">Games</h1>
        <button class="btn btn-warning btn3d btn-block"
                onclick=window.location.href="/mastermind/home"><i class="fas fa-gamepad"></i> Mastermind
        </button>
        <br>
        <br>

        <h1 class="menu3dtext">Options</h1>
        <c:if test="${isAnyGameHistory==false}">
            <p style="color: dimgrey"><c:out value="Finish one game to unlock stats"/></p>
        </c:if>
        <button class="btn btn-info btn3d btn-block"
                <c:if test="${isAnyGameHistory==false}">disabled</c:if>
                onclick=window.location.href="/stats"><i class="fas fa-chart-bar"></i> Stats
        </button>
        <br>
        <button class="btn btn-info btn3d btn-block"
                onclick=window.location.href="/account_settings"><i class="fas fa-user-cog"></i> Account settings
        </button>
        <br>
        <button class="btn btn-info btn3d btn-block disabled" disabled onclick=window.location.href="/achievements">
            <i class="fas fa-trophy"></i> Achievements
        </button>
        <p style="color: dimgrey">(Achievements section is not yet available)</p>

        <br>
    </div>
    <div class="col-5"></div>
</div>
</body>
</html>
