<%--
  Created by IntelliJ IDEA.
  User: 18454
  Date: 2020/12/20
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/alterPassword.js"></script>
</head>
<body>
<div style="position: absolute;left:40%;top:100px;">
<div>
    <span>账号 :</span>
    <input id="name" name="name" placeholder="请输入账号" onkeyup="checkUsername()" type="text">
    <span id="checkResult"></span>
</div>
<div id="inputPhone" style="display: none">
    <span>手机号码 :</span>
    <input id="tel" name="phone" placeholder="请输入手机号码" onkeyup="checkPhone()" type="text">
    <span id="checkPhone"></span>
</div>
<div id="getCode" style="display: none">
    <input  placeholder="请输入短信动态码" id="inputPassword"  name="password" type="text">
    <button id="btn" onclick="sendMessage()">获取验证码</button>
    <span id = "show"></span>
    <button onclick="checkCode()">确认</button>
</div>
<div id="verify" style="display: none">
    <span>新密码 :</span>
    <input type="text" id="newPassWord">
    <button id="alterPassWord" onclick="updatePassWord()">确认提交</button>
    <span id="resOfUpdate"></span>
</div>
</div>
</body>
</html>
