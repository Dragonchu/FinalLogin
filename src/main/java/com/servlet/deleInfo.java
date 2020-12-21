package com.servlet;

import com.util.JsonReader;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/deleteInfo")
public class deleInfo extends HttpServlet {
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
            stmt.execute("delete from login where user = '"+username+"' and pass = '"+password+"' and tel = '"+tel+"';");
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
