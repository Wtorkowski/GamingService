<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <h3> Easy <input type="radio" name="difficulty" value="easy"></h3><br>
           <h3> Medium <input type="radio" name="difficulty" value="medium" checked></h3><br>
          <h3> Hard <input type="radio" name="difficulty" value="hard"></h3><br>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><br>
            <input type="submit" value="Start game">
        </form>
        <br>
        <br>
        <button onclick=window.location.href="/main_menu">Return to Main menu</button>
    </div>
    <div class="col-3"></div>
</div>
</body>
</html>
