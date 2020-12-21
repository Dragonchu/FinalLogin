package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

import com.jsonClass.user;
import com.util.JsonReader;
import net.sf.json.JSONObject;

public class DatabaseAccess extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatabaseAccess() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        var json = JsonReader.receivePost(request);

        var user = (com.jsonClass.user)JSONObject.toBean(json, user.class);
        String username = user.getUsername();
        String password = user.getPassword();

        try {
            // 注册 JDBC 驱动器
            Class.forName("com.mysql.jdbc.Driver");

            // 打开一个连接
            Connection c = DriverManager.getConnection(
                            "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                            "root", "admin");

            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from login where pass = '"+password+"' and user = '"+username+"'");
            if(rs.next()){
                response.getWriter().write("success");
            }else{
                response.getWriter().write("用户名或者账号错误");
            }

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
