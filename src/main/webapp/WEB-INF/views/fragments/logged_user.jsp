<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .logged_user_container {
        height: 70px;
        text-align: left;
    }
</style>
<div>
    <div class="row">
        <div class="col-3"></div>
        <div class="col-6"><h2>Gaming Service Demo</h2></div>
        <div class="col-3"></div>
    </div>
    <div class="row logged_user_container">
        <div class="col-3"></div>
        <div class="col-2">
            <sec:authorize access="isAuthenticated()">
                <p style="font-size: large">${user.userName} logged</p>
            </sec:authorize>
        </div>
        <div class="col-2"></div>
        <div class="col-1"></div>
        <div class="col-1">
            <sec:authorize access="isAuthenticated()">
                <button onclick=window.location.href="/logout">Logout</button>
            </sec:authorize>
        </div>
        <div class="col-3"></div>
    </div>
</div>
