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
    <title>Main Menu</title>
    <style>

    </style>
</head>
<body>

<table style="text-align: center">
    <h1>Main Menu</h1>
    <tr>
        <td colspan="3"><br></td>
    </tr>
    <tr>
        <th colspan="3">Choose difficulty level to start game:</th>
    </tr>
    <tr>
        <td>
            <button onclick=window.location.href="/game/easy">Easy</button>
        </td>
        <td>
            <button onclick=window.location.href="/game/medium">Medium</button>
        </td>
        <td>
            <button onclick=window.location.href="/game/hard">Hard</button>
        </td>
    </tr>
    <tr>
        <td colspan="3"><br></td>
    </tr>
    <tr>
        <td colspan="3">
            <button onclick=window.location.href="/stats">Stats</button>
        </td>
    </tr>
    <tr>
        <td colspan="3">
            <button onclick=window.location.href="/achievements">Achievements</button>
        </td>
    </tr>
    <tr>
        <td colspan="3">
            <button onclick=window.location.href="/account_settings">Account settings</button>
        </td>
    </tr>
    <tr>
        <td colspan="3">
            <button onclick=window.location.href="/logout">Logout</button>
        </td>
    </tr>
</table>


</body>
</html>
