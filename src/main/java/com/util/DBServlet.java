package com.util;

import com.jsonClass.user;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public abstract class DBServlet extends HttpServlet {
    protected String username;
    protected String password;
    protected String tel;
    protected abstract String WrongMessage();
    protected abstract String SqlSelect();
    protected abstract String Sql();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        var json = JsonReader.receivePost(request);
        //从请求信息中获取Json
        var userWithPhone = (com.jsonClass.userWithPhone)JSONObject.toBean(json, com.jsonClass.userWithPhone.class);
        username = userWithPhone.getUsername();
        password = userWithPhone.getPassword();
        tel = userWithPhone.getTel();
        //连接数据库并执行Sql语句
        try {
            // 注册 JDBC 驱动器
            Class.forName("com.mysql.jdbc.Driver");

            // 打开一个连接
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                    "root", "admin");

            Statement stmt = c.createStatement();
            stmt.execute(Sql());
            ResultSet rs = stmt.executeQuery(SqlSelect());
            if(rs.next()){
                response.getWriter().write("success");
            }else{
                response.getWriter().write(WrongMessage());
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
