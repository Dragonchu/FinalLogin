package com.servlet;

import com.jsonClass.user;
import com.util.JsonReader;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/addNewInfo")
public class AddNewInfo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        var json = JsonReader.receivePost(request);

        var userWithPhone = (com.jsonClass.userWithPhone) JSONObject.toBean(json, com.jsonClass.userWithPhone.class);
        String username = userWithPhone.getUsername();
        String password = userWithPhone.getPassword();
        String tel = userWithPhone.getTel();

        try {
            // 注册 JDBC 驱动器
            Class.forName("com.mysql.jdbc.Driver");

            // 打开一个连接
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                    "root", "admin");

            Statement stmt = c.createStatement();
            stmt.execute("insert into login values ('"+username+"','"+password+"','"+tel+"')");
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
