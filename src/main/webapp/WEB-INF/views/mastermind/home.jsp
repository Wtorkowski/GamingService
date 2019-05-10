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
    <title>Mastermind main menu</title>
</head>
<body>

After each attempt you will get feedback:<br>
[X]- means that one of digits is in correct place<br>
[O]- means that one of digits exists in the code, but in wrong position<br>
[_]- means that one of digits is not in combination<br>

<table style="text-align: center">
    <tr>
        <th colspan="3">Choose difficulty</th>
    </tr>
    <form action="/mastermind/home" method="POST">
        <tr>
            <td>Easy</td>
            <td>Medium</td>
            <td>Hard</td>
        </tr>
        <tr>
            <td>
                <label>
                    <input type="radio" name="difficulty" value="easy">
                </label>
            </td>
            <td>
                <label>
                    <input type="radio" name="difficulty" value="medium" checked>
                </label>
            </td>
            <td>
                <label>
                    <input type="radio" name="difficulty" value="hard">
                </label>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" value="Start game">
            </td>
        </tr>
    </form>
</table>
<br>
<br>
<br>
<button onclick=window.location.href="/main_menu">Return to Main menu</button>

</body>
</html>
