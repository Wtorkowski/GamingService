<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
      integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
        integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
        integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
        crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
      integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">


<style>

    input[type="radio"]{
        visibility: hidden;
        height: 0;
        width: 0;
    }

    .lightBlue {
        background-color: #9aecfd;
    }


    .topCornersRounded {
        border-top-right-radius: 25px;
        border-top-left-radius: 25px;
    }

    .bottomLeftCornerRounded {
        border-bottom-left-radius: 25px;
    }

    .bottomRightCornerRounded {
        border-bottom-right-radius: 25px;
    }

    .centerContent {
        alignment: center;
    }

    .height70 {
        height: 70px;
    }

    .height90 {
        height: 90px;
    }

    .gstext3d {
        font-family: verdana;
        font-size: 40px;
        font-weight: 700;
        text-shadow: 0 1px 0 #ccc,
        0 2px 0 #c9c9c9,
        0 3px 0 #bbb,
        0 4px 0 #b9b9b9,
        0 5px 0 #aaa,
        0 6px 1px rgba(0, 0, 0, .1),
        0 0 5px rgba(0, 0, 0, .1),
        0 1px 3px rgba(0, 0, 0, .3),
        0 3px 5px rgba(0, 0, 0, .2),
        0 5px 10px rgba(0, 0, 0, .25),
        0 10px 10px rgba(0, 0, 0, .2),
        0 20px 20px rgba(0, 0, 0, .15);
    }

    .menu3dtext {
        color: white;
        font-weight: 600;
        text-shadow: 0 1px 0 #ccc,
        0 2px 0 #c9c9c9,
        0 3px 0 #bbb,
        0 4px 0 #b9b9b9,
        0 5px 0 #aaa,
        0 6px 1px rgba(0, 0, 0, .1),
        0 0 5px rgba(0, 0, 0, .1),
        0 1px 3px rgba(0, 0, 0, .3),
        0 3px 5px rgba(0, 0, 0, .2),
        0 5px 10px rgba(0, 0, 0, .25),
        0 10px 10px rgba(0, 0, 0, .2),
        0 20px 20px rgba(0, 0, 0, .15);
    }

    .btn3d {
        position: relative;
        top: -6px;
        border: 0;
        transition: all 40ms linear;
        margin-top: 10px;
        margin-bottom: 10px;
        margin-left: 2px;
        margin-right: 2px;
    }

    .btn3d:active:focus,
    .btn3d:focus:hover,
    .btn3d:focus {
        -moz-outline-style: none;
        outline: medium none;
    }

    .btn3d:active, .btn3d.active {
        top: 2px;
    }

    .btn3d.btn-white {
        color: #666666;
        box-shadow: 0 0 0 1px #ebebeb inset, 0 0 0 2px rgba(255, 255, 255, 0.10) inset, 0 8px 0 0 #f5f5f5, 0 8px 8px 1px rgba(0, 0, 0, .2);
        background-color: #fff;
    }

    .btn3d.btn-white:active, .btn3d.btn-white.active {
        color: #666666;
        box-shadow: 0 0 0 1px #ebebeb inset, 0 0 0 1px rgba(255, 255, 255, 0.15) inset, 0 1px 3px 1px rgba(0, 0, 0, .1);
        background-color: #fff;
    }

    .btn3d.btn-default {
        color: #666666;
        box-shadow: 0 0 0 1px #ebebeb inset, 0 0 0 2px rgba(255, 255, 255, 0.10) inset, 0 8px 0 0 #BEBEBE, 0 8px 8px 1px rgba(0, 0, 0, .2);
        background-color: #f9f9f9;
    }

    .btn3d.btn-default:active, .btn3d.btn-default.active {
        color: #666666;
        box-shadow: 0 0 0 1px #ebebeb inset, 0 0 0 1px rgba(255, 255, 255, 0.15) inset, 0 1px 3px 1px rgba(0, 0, 0, .1);
        background-color: #f9f9f9;
    }

    .btn3d.btn-primary {
        box-shadow: 0 0 0 1px #417fbd inset, 0 0 0 2px rgba(255, 255, 255, 0.15) inset, 0 8px 0 0 #4D5BBE, 0 8px 8px 1px rgba(0, 0, 0, 0.5);
        background-color: #4274D7;
    }

    .btn3d.btn-primary:active, .btn3d.btn-primary.active {
        box-shadow: 0 0 0 1px #417fbd inset, 0 0 0 1px rgba(255, 255, 255, 0.15) inset, 0 1px 3px 1px rgba(0, 0, 0, 0.3);
        background-color: #4274D7;
    }

    .btn3d.btn-success {
        box-shadow: 0 0 0 1px #31c300 inset, 0 0 0 2px rgba(255, 255, 255, 0.15) inset, 0 8px 0 0 #5eb924, 0 8px 8px 1px rgba(0, 0, 0, 0.5);
        background-color: #78d739;
    }

    .btn3d.btn-success:active, .btn3d.btn-success.active {
        box-shadow: 0 0 0 1px #30cd00 inset, 0 0 0 1px rgba(255, 255, 255, 0.15) inset, 0 1px 3px 1px rgba(0, 0, 0, 0.3);
        background-color: #78d739;
    }

    .btn3d.btn-info {
        box-shadow: 0 0 0 1px #00a5c3 inset, 0 0 0 2px rgba(255, 255, 255, 0.15) inset, 0 8px 0 0 #348FD2, 0 8px 8px 1px rgba(0, 0, 0, 0.5);
        background-color: #39B3D7;
    }

    .btn3d.btn-info:active, .btn3d.btn-info.active {
        box-shadow: 0 0 0 1px #00a5c3 inset, 0 0 0 1px rgba(255, 255, 255, 0.15) inset, 0 1px 3px 1px rgba(0, 0, 0, 0.3);
        background-color: #39B3D7;
    }

    .btn3d.btn-warning {
        box-shadow: 0 0 0 1px #d79a47 inset, 0 0 0 2px rgba(255, 255, 255, 0.15) inset, 0 8px 0 0 #D79A34, 0 8px 8px 1px rgba(0, 0, 0, 0.5);
        background-color: #FEAF20;
    }

    .btn3d.btn-warning:active, .btn3d.btn-warning.active {
        box-shadow: 0 0 0 1px #d79a47 inset, 0 0 0 1px rgba(255, 255, 255, 0.15) inset, 0 1px 3px 1px rgba(0, 0, 0, 0.3);
        background-color: #FEAF20;
    }

    .btn3d.btn-danger {
        box-shadow: 0 0 0 1px #b93802 inset, 0 0 0 2px rgba(255, 255, 255, 0.15) inset, 0 8px 0 0 #AA0000, 0 8px 8px 1px rgba(0, 0, 0, 0.5);
        background-color: #D73814;
    }

    .btn3d.btn-danger:active, .btn3d.btn-danger.active {
        box-shadow: 0 0 0 1px #b93802 inset, 0 0 0 1px rgba(255, 255, 255, 0.15) inset, 0 1px 3px 1px rgba(0, 0, 0, 0.3);
        background-color: #D73814;
    }

    .btn3d.btn-magick {
        color: #fff;
        box-shadow: 0 0 0 1px #9a00cd inset, 0 0 0 2px rgba(255, 255, 255, 0.15) inset, 0 8px 0 0 #9823d5, 0 8px 8px 1px rgba(0, 0, 0, 0.5);
        background-color: #bb39d7;
    }

    .btn3d.btn-magick:active, .btn3d.btn-magick.active {
        box-shadow: 0 0 0 1px #9a00cd inset, 0 0 0 1px rgba(255, 255, 255, 0.15) inset, 0 1px 3px 1px rgba(0, 0, 0, 0.3);
        background-color: #bb39d7;
    }

</style>
