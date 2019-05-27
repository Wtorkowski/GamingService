<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bart
  Date: 30.04.19
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../fragments/header-link.jsp"/>
    <title>Mastermind main menu</title>
</head>
<body>
<jsp:include page="../fragments/logged_user.jsp"/>

<div class="row">
    <div class="col-3"></div>
    <div class="col-6">
        <div>
            <c:out value="Mastermind is a code-breaking game. Computer encrypts a combination of digits, player’s task is to decrypt the combination using generated feedback. Check the image below to get an idea of how feedback works."/>
        </div>
        <br>
        <div style="height:220px;width: 760px ">
            <img id="mastermind_img" src="/img/solution.png" alt="mastermind_solution">
        </div>
    </div>
    <div class="col-4"></div>
</div>
</div>
<div class="row">
    <div class="col-4"></div>
    <div class="col-4" align="center">
        <h2>Choose a difficulty level</h2>
        <form action="/mastermind/home" method="POST">
            <div class="btn-group" data-toggle="buttons">
                <label class="btn btn-info btn3d">
                    <input type="radio" name="difficulty" id="option2" value="easy" > Easy
                </label>&nbsp;
                <label class="btn btn-info btn3d active">
                    <input type="radio" name="difficulty" id="option1" value="medium" checked> Medium
                </label>&nbsp;
                <label class="btn btn-info btn3d">
                    <input type="radio" name="difficulty" id="option3" value="hard"> Hard
                </label>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>
            <br>
            <input class="btn btn-warning btn3d" type="submit" value="Start game">
        </form>
        <br>
        <br>
        <button class="btn btn-info btn3d" onclick=window.location.href="/main_menu">Return to Main menu</button>
    </div>
    <div class="col-3"></div>
</div>
</body>
</html>
