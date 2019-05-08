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
    <title>Register</title>
    <style>

    </style>
</head>
<body>
<h1>Gaming Service Registration</h1>
<h2>Enter details:</h2>
<p>All fields are required</p>
<table>
    <%--@elvariable id="userRegistrationDto" type="com"--%>
    <form:form id="register" method="POST" modelAttribute="registrationForm">
        <tr>
            <td>
                <form:errors path="*" cssStyle="color: red"/>
            </td>
            <td></td>
        </tr>
        <tr>
            <td>Login:</td>
            <td>
                <form:input path="userName" pattern="[a-zA-Z0-9]{3,20}"/>
            </td>
        </tr>
        <tr>
            <td>
                <ul style="color: cadetblue">
                    <li>between 3 and 20 characters</li>
                    <li>only letters and numbers</li>
                </ul>
            </td>
            <td></td>
        </tr>
        <tr>
            <td>
                Password:
            </td>
            <td>
                <form:password path="password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,20}$"/>
            </td>
        </tr>
        <tr>
            <td>
                <ul style="color: cadetblue">
                    <li>between 6 and 20 characters</li>
                    <li>at least one uppercase letter</li>
                    <li>at least one lowercase letter</li>
                </ul>
            </td>
            <td></td>
        </tr>
        <tr>
            <td>Repeat password:</td>
            <td>
                <form:password path="repeatPassword" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,20}$"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Join now"></td>
        </tr>
    </form:form>
</table>
<br>
<button onclick=window.location.href="/">Return to login page</button>

</body>
</html>
