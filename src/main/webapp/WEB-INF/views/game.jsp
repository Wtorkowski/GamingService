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
<%@ page session="true" %>

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
            <c:choose>
                <c:when test="${difficulty == 'easy'}">
                    Decrypt hidden combination of 4 digits, use digits from 1 to 4.
                </c:when>
                <c:when test="${difficulty == 'medium'}">
                    Decrypt hidden combination of 4 digits, use digits from 1 to 6.
                </c:when>
                <c:when test="${difficulty == 'hard'}">
                    Decrypt hidden combination of 5 digits, use digits from 1 to 6.
                </c:when>
            </c:choose>
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
<table>
    <tr>

        <th>
            Attempt #
        </th>
        <th colspan="2">
            Decription
        </th>
        <th colspan="2">
            Feedback
        </th>
    </tr>
    <c:forEach items="${attemptsList}" var="attempt" varStatus="loop">
        <tr>
            <td>
                    ${loop.count}
            </td>
            <td colspan="2">
                    ${attempt.decription}
            </td>
            <td colspan="2">
                    ${attempt.feedback}
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td></td>
        <td colspan="2">
            <form:form method="post" modelAttribute=""
        </td>
    </tr>
</table>


</body>
</html>
