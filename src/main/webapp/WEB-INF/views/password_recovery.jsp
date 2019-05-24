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

    <title>Password recovery</title>
    <style>

    </style>
</head>
<body>
<jsp:include page="fragments/logged_user.jsp"/>
<div class="row">
    <div class="col-4"></div>
    <div class="col-4" align="center">
        <h1>Forgot your password?<br>
            3 simple ways to improve your memory:
            <ul>
                <li>exercise your brain playing Mastermind</li>
                <li>eat walnuts daily</li>
                <li>sleep well</li>
            </ul>
        </h1>

        I've used h1 tag just in case you're having problems with vision too.
        <br>
        <button onclick=window.location.href="/login">Go back to Login page</button>
        <br>
        (One day this page will generate standard password recovery email)
    </div>

    <div class="col-4"></div>
</div>
</body>
</html>