<%--
  Created by IntelliJ IDEA.
  User: 18454
  Date: 2020/12/21
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/adminLogin.js"></script>
</head>
<body>
<div style="position: absolute;left:40%;top:200px;">
    <div>
        <span>用户名:</span>
        <input type="text" placeholder="请输入学号/工号" id="inputUsername" name="user">
    </div>
    <div style="margin-top: 5%">
        <span>密码：</span>
        <input type="password" placeholder="密码" id="inputPassword" name="password">
    </div>
    <div style="margin-top: 5%">
        <span id = "show"></span>
    </div>
    <div style="margin-top: 5%;text-align: center">
        <button id="submit" onclick="login()">登录</button>
    </div>
</div>
</body>
</html>
