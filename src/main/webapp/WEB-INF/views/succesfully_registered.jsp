<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Registered</title>
    <style>

    </style>
</head>
<body>
<h1>${userRegistrationDto.login} registered successfully!</h1>
<br>
<br>
<button onclick=window.location.href="/">Return to login page</button>

</body>
</html>
