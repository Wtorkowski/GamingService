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
    <title>Mastermind main menu</title>
</head>
<body>
<table>

    <tr>
        <td>

        </td>
    </tr>

    <tr>
        <td>
            After each attempt you will get feedback:<br>
            [X]- means that one of digits is in correct place<br>
            [O]- means that one of digits exists in the code, but in wrong position<br>
            [ ]- means that one of digits is not in combination<br>
        </td>
    </tr>

    <tr>
        <th colspan="3">Choose difficulty level to start a new game:</th>
    </tr>
    <tr>
        <td>
            <button onclick=window.location.href="/mastermind/game/easy">Easy</button>
        </td>
        <td>
            <button onclick=window.location.href="/mastermind/game/medium">Medium</button>
        </td>
        <td>
            <button onclick=window.location.href="/mastermind/game/hard">Hard</button>
        </td>
    </tr>
</table>
</body>
</html>
