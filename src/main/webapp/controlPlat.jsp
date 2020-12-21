<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: 18454
  Date: 2020/12/21
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>管理员控制台</title>
    <script type="text/javascript" src="js/dbController.js"></script>
    <link rel="stylesheet" type="text/css" href="css/controlPlat.css">
</head>
<body>
<%
        // 注册 JDBC 驱动器
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

    // 打开一个连接
    Connection c = null;
    try {
        c = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "admin");
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }

    assert c != null;
    Statement stmt = c.createStatement();
    ResultSet rs = null;
    try {
        rs = stmt.executeQuery("select * from login");
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
%>
<table width="200px" align="center" border="1" cellspacing="0">
    <tr>
        <td>账户</td>
        <td>密码</td>
        <td>手机号码</td>
    </tr>
    <%
        while(rs.next()){
    %>
    <tr>
        <td><input readonly="readonly" value=<%=rs.getString(1)%>></td>
        <td><input readonly="readonly" value=<%=rs.getString(2)%>></td>
        <td><input readonly="readonly" value=<%=rs.getString(3)%>></td>
        <td><button id="alter" onclick="alter(this)">修改</button></td>
        <td><button id="delete" onclick="deleteInfo(this)">删除</button></td>
        <td><button onclick="submitToDB(this)">确认</button></td>
    </tr>
    <%
        }
    %>
    <tr><td colspan="6"><button onclick="addInfo(this)">添加</button></td></tr>
</table>
</body>
</html>
