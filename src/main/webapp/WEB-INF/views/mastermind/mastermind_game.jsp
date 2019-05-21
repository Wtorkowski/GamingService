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
    <jsp:include page="../fragments/header-link.jsp"/>

    <title>Game</title>
    <style>

    </style>
</head>
<body>
<jsp:include page="../fragments/logged_user.jsp"/>

<div class="row">
    <div class="col-3"></div>
    <div class="col-6">
        <div style="height:220px;width: 760px ">
            <img id="mastermind_img" src="/img/solution.png" alt="mastermind_solution">
        </div>
    </div>
    <div class="col-3"></div>
</div>
<div class="row">
    <div class="col-3"></div>
    <div class="col-5" align="center">
        <table style="text-align: center;font-size: x-large">
            <tr>
                <td colspan="3">
                    Difficulty:
                    <c:choose>
                        <c:when test="${difficulty == 'easy'}">
                            Easy
                        </c:when>
                        <c:when test="${difficulty == 'medium'}">
                            Medium
                        </c:when>
                        <c:when test="${difficulty == 'hard'}">
                            Hard
                        </c:when>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td colspan="3"></td>
            </tr>
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
                            <form:input path="decription" autocomplete="off" required="required"
                                        pattern="[1-4]{4,4}"
                                        autofocus="autofocus" onfocus="this.value=''"/></c:when>
                        <c:when test="${difficulty == 'medium'}">
                            <form:input path="decription" autocomplete="off" required="required"
                                        pattern="[1-6]{4,4}"
                                        autofocus="autofocus" onfocus="this.value=''"/></c:when>
                        <c:when test="${difficulty == 'hard'}">
                            <form:input path="decription" autocomplete="off" required="required"
                                        pattern="[1-6]{5,5}"
                                        autofocus="autofocus" onfocus="this.value=''"/></c:when>
                    </c:choose>
                </td>
                <td></td>

            </tr>
            <tr>
                <td></td>
                <td>
                    <c:choose>
                        <c:when test="${difficulty == 'easy'}">
                            Use 4 digits from 1 to 4.
                        </c:when>
                        <c:when test="${difficulty == 'medium'}">
                            Use 4 digits from 1 to 6.
                        </c:when>
                        <c:when test="${difficulty == 'hard'}">
                            Use 5 digits from 1 to 6.
                        </c:when>
                    </c:choose>
                </td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Submit"></td>
                <td></td>
            </tr>
            </form:form>
            <%--TODO Delete {encrypted}--%>
            <tr>
                <td>${encrypted}</td>
            </tr>
        </table>
        <br>
        <br>
        <br>
        <button onclick=window.location.href="/mastermind/home">Return to Mastermind menu</button>
    </div>
    <div class="col-3"></div>
</div>
</body>
</html>
