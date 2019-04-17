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
    <title>Home</title>
    <style>

    </style>
</head>
<body>

<h1>Gaming Service</h1>

<table style="text-align: center">
    <tr>
        <td>
            <button onclick=window.location.href="login">Sign in</button>
        </td>
    </tr>
    <tr>
        <td></td>
    </tr>
    <tr>
        <td>
            Not registered yet?
            <button onclick=window.location.href="register">Join now</button>
        </td>
    </tr>


</table>
</body>
</html>
