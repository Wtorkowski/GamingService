<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bart
  Date: 17.04.19
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="fragments/header-link.jsp"/>
    <title>Registered</title>
</head>
<body>
<jsp:include page="fragments/logged_user.jsp"/>
<div class="row">
    <div class="col-4"></div>
    <div class="col-4">
        <c:out value="${registered_user_name} you are successfully registered."/>
        <button onclick=window.location.href="/login">Sign in</button>
    </div>
    <div class="col-4"></div>
</div>
</body>
</html>
