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
    <jsp:include page="fragments/header-link.jsp"/>

    <title>Account settings</title>
    <style>

    </style>
</head>
<body>
<jsp:include page="fragments/logged_user.jsp"/>

    <div class="col-4>"></div>
    <div class="col-4>" align="center">
       
        <c:if test="${updated == true}">
            <p style="color: forestgreen">Password successfully updated</p>
        </c:if>
        <c:if test="${updated != true}">Change password:</c:if>
        <%--@elvariable id="editDetails" type="com"--%>
        <form:form id="edit_details" method="POST" modelAttribute="editDetails">
            <table>
                <tr>
                    <td colspan="2">
                        <form:errors path="*" cssStyle="color: red"/>
                    </td>
                </tr>
                <tr>
                    <td>Current password:</td>
                    <td>
                        <form:password path="oldPassword"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        New password:
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
                    <td>Repeat new password:</td>
                    <td>
                        <form:password path="repeatPassword"
                                       pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,20}$"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit change"></td>
                </tr>
            </table>
        </form:form>
        <br>
        <br>
        <button onclick=window.location.href="/main_menu">Return to Main menu</button>
    </div>
    <div class="col-4>"></div>
</body>
</html>
