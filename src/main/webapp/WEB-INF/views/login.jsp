<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="fragments/header-link.jsp"/>
    <title>Login</title>
</head>
<body>
<jsp:include page="fragments/logged_user.jsp"/>
<div class="row">
    <div class="col-3"></div>
    <div class="col-6 " align="center">
        <c:out value="Ready to use registered players for demo purposes only:"/><br>
        <table>
            <tr>
                <td>1st time logged in:</td>
                <td>"newbie"</td>
                <td>Password1</td>
            </tr>
            <br>
            <tr>
                <td>Experienced player:</td>
                <td>"veteran"</td>
                <td>Password1</td>
            </tr>
        </table>
    </div>
    <div class="col-3"></div>
</div>
<div class="row height70">
    <div class="col-3"></div>
    <div class="col-6">
        <c:if test="${not empty errorMessage}">
            <div style="color:red; font-weight: bold; margin: 30px 0px; text-align: center">${errorMessage}</div>
        </c:if>
    </div>
    <div class="col-3"></div>
</div>

<div class="row">
    <div class="col-3"></div>
    <div class="col-6" align="center">
        <form name='login' action="/login" method='POST'>
            Username:<br>
            <i class="fas fa-user"></i> <input type='text' name='username' value=''><br>
            <br>
            Password:<br>
            <i class="fas fa-key"></i> <input type='password' name='password'/><br>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><br>
            <input name="submit" type="submit" class="btn btn-info btn3d" value="Sign in"/><br>
        </form>
    </div>
    <div class="col-3"></div>
</div>
<div class="row">
    <div class="col-3"></div>
    <div class="col-6" align="center">Don't have an account? <a href="/register">Sign up</a><br>
        <a href="/login/forgotten_password " >Forgot your password? </a></div>
    <div class="col-3"></div>
</div>
<footer class="page-footer font-small">
    <jsp:include page="fragments/footer.jsp"/>
</footer>
</body>
</html>