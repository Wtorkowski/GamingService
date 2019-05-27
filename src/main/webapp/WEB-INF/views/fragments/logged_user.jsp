<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../fragments/header-link.jsp"/>
<div>
    <div class="row height90">
        <div class="col-3"></div>
        <div class="col-6 lightBlue topCornersRounded"><h2 class="gstext3d text-white">Gaming Service Demo</h2></div>
        <div class="col-3"></div>
    </div>
    <div class="row height70">
        <div class="col-3"></div>
        <div class="col-2 lightBlue bottomLeftCornerRounded">
            <sec:authorize access="isAuthenticated()">
                <p class="menu3dtext text-white" style="font-size: 30px"><i class="far fa-user"></i> ${username}</p>
            </sec:authorize>
        </div>
        <div class="col-2 lightBlue"></div>
        <div class="col-1 lightBlue"></div>
        <div class="col-1 lightBlue bottomRightCornerRounded">
            <sec:authorize access="isAuthenticated()">
                <button type="button" class="btn btn-danger btn3d" onclick=window.location.href="/logout"><span class="fas fa-power-off"></span> Logout</button>
            </sec:authorize>
        </div>
        <div class="col-3"></div>
    </div>
</div>
