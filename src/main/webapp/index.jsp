<%--
  Created by IntelliJ IDEA.
  User: 18454
  Date: 2020/12/9
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>登陆页面</title>
    <link rel="stylesheet" type="text/css" href="css/signing.css">
    <script type="text/javascript" src="js/login.js"></script>
    <script type="text/javascript" src="js/scrollControl.js"></script>
    <script type="text/javascript" src="js/hide.js"></script>
</head>

<body>
<div class="logo">
    <span><img style="vertical-align: middle;" src="img/logo.png"></span>
    <span class="text">|统一身份认证</span>
</div>
<div class="container">
    <div class="wrap" style="left: 0px;">
        <img src="img/scrollPic1.jpg">
        <img src="img/scrollPic2.jpg">
        <img src="img/scrollPic3.jpg">
        <img src="img/scrollPic4.jpg">
        <img src="img/scrollPic5.jpg">
    </div>
    <div class="buttons">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
    </div>
    <a class="arrow arrow_left" onclick="prev_pic()">&lt;</a>
    <a class="arrow arrow_right" onclick="next_pic()">&gt;</a>
</div>
<div class="right">
    <div class="loginPage">
        <div class="loginWays">
            <span class="choose"><a href="index.jsp">账号登录</a></span>
            <span><a href="SMS.jsp">手机登录</a></span>
        </div>
        <div class="form">
            <input type="text" placeholder="请输入学号/工号" id="inputUsername" name="user">
            <input type="password" placeholder="密码" id="inputPassword" name="password">
            <i id="eye" onclick="hide()"></i>
            <span id = "show"></span>
            <button id="submit" onclick="login()">登录</button>
        </div>
        <div>
            <a href="forgetPassWord.jsp">忘记密码</a>
            <a href="forgetPassWord.jsp">修改密码</a>
            <a href="adminLogin.jsp">管理员登录</a>
        </div>
    </div>
</div>
</body>
<script>
    var dots = document.querySelector(".buttons").getElementsByTagName("span");
    for (let i = 0, len = dots.length; i < len; i++){
        dots[i].onclick = function () {
            index=i;
            showON();
            var wrap = document.querySelector(".wrap");
            var newLeft = index*(-238);
            wrap.style.left = newLeft+"px";
        }
    }
</script>
</html>