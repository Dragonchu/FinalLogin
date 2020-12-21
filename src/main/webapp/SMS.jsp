<%--
  Created by IntelliJ IDEA.
  User: 18454
  Date: 2020/12/18
  Time: 9:26
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
    <script type="text/javascript" src="js/hide.js"></script>
</head>
<body>
<div class="logo">
    <span><img style="vertical-align: middle;" src="img/logo.png"></span>
    <span class="text">|统一身份认证</span>
</div>
<div class="right">
    <div class="loginPage">
        <div class="loginWays">
            <span><a href="index.jsp">账号登录</a></span>
            <span class="choose"><a href="SMS.jsp">手机登录</a></span>
        </div>
        <div class="form">
            <input type="text" placeholder="请输入手机号/学号" id="inputUsername" name="user">
            <input type="text" placeholder="请输入短信动态码" id="inputPassword" name="password">
            <button id="btn" onclick="sendMessage()">获取验证码</button>
            <span id = "show"></span>
            <button id="submit" onclick="checkCode()">登录</button>
        </div>
    </div>
</div>
</body>
</html>
