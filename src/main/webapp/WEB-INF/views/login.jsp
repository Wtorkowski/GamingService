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
    <title>Home</title>
    <style>

    </style>
</head>
<body>

<h1>Gaming Service</h1>

<c:if test="${not empty errorMessage}">
    <div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessage}</div>
</c:if>

<form name='login' action="/login" method='POST'>
    <table>
        <tr>
            <td>Username:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password'/></td>
        </tr>
        <tr>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <td colspan='2'><input name="submit" type="submit" value="Sign in"/></td>
        </tr>
    </table>

</form>

Not registered yet?
<button onclick=window.location.href="register">Join now</button>

</table>
</body>
</html>
