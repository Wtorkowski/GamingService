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
    <title>Game</title>
    <style>

    </style>
</head>
<body>
<table>
    <tr>
        <td>
            Difficulty:
            <c:choose>
                <c:when test="${difficulty == 'easy'}">
                    EASY
                </c:when>
                <c:when test="${difficulty == 'medium'}">
                    MEDIUM
                </c:when>
                <c:when test="${difficulty == 'hard'}">
                    HARD
                </c:when>
            </c:choose>
        </td>
    </tr>
    <tr>
        <td><br></td>

    </tr>
    <tr>
        <td colspan="2">

        </td>
    </tr>
    <tr>
        <td><br></td>
    </tr>
    <tr>
        <td>
            After each attempt you will get feedback:<br>
            [X]- means that one of digits is in correct place<br>
            [O]- means that one of digits exists in the code, but in wrong position<br>
            [ ]- means that one of digits is not in combination<br>
        </td>
    </tr>
</table>
<table style="text-align: center">
    <tr>

        <th>
            Attempts
        </th>
        <th>
            Decription
        </th>
        <th>
            Feedback
        </th>
    </tr>
    <c:forEach items="${attemptsList}" var="attempt" varStatus="loop">
        <tr style="text-align: center">
            <td>
                    ${loop.count}
            </td>
            <td>
                    ${attempt.decriptionAttempt}
            </td>
            <td>
                    ${attempt.feedback}
            </td>
        </tr>
    </c:forEach>

    <tr>
        <form:form method="post" modelAttribute="decription" autocomplete="false">
            <td><form:errors path="decription"/></td>
            <td>
                <c:choose>
                    <c:when test="${difficulty == 'easy'}">
                        <form:input path="decription" pattern="[1-4]{4,4}" autofocus="autofocus" onfocus="this.value=''"/></c:when>
                    <c:when test="${difficulty == 'medium'}">
                        <form:input path="decription" pattern="[1-6]{4,4}" autofocus="autofocus" onfocus="this.value=''"/></c:when>
                    <c:when test="${difficulty == 'hard'}">
                        <form:input path="decription" pattern="[1-6]{5,5}" autofocus="autofocus" onfocus="this.value=''"/></c:when>
                </c:choose>
            </td>
            <td> <input type="submit" value="Submit"></td>
        </form:form>
    </tr>
    <tr>
        <td> </td>
        <td>
            <c:choose>
                <c:when test="${difficulty == 'easy'}">
                   Use 4 digits from 1 to 4.
                </c:when>
                <c:when test="${difficulty == 'medium'}">
                    Use 4 digits, from 1 to 6.
                </c:when>
                <c:when test="${difficulty == 'hard'}">
                    Use 5 digits, from 1 to 6.
                </c:when>
            </c:choose>
        </td>
    </tr>

    <%--TODO Delete {encrypted}--%>
    <tr>
        <td>${encrypted}</td>
    </tr>
</table>
<button onclick=window.location.href="/mastermind/home">Return to Mastermind menu</button>

</body>
</html>
