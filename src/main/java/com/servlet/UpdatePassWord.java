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

@WebServlet("/updatePassWord")
public class UpdatePassWord extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        var json = JsonReader.receivePost(request);

        var userWithPhone = (com.jsonClass.userWithPhone) JSONObject.toBean(json, com.jsonClass.userWithPhone.class);
        String username = userWithPhone.getUsername();
        String newPassword = userWithPhone.getPassword();
        String tel = userWithPhone.getTel();

        try {
            // 注册 JDBC 驱动器
            Class.forName("com.mysql.jdbc.Driver");

            // 打开一个连接
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                    "root", "admin");

            Statement stmt = c.createStatement();
            stmt.execute("update login set pass = '"+newPassword+"' where user = '"+username+"' and tel='"+tel+"'");
            ResultSet rs = stmt.executeQuery("select * from login where pass = '"+newPassword+"' and user = '"+username+"' and tel = '"+tel+"'");
            if(rs.next()){
                response.getWriter().write("success");
            }else{
                response.getWriter().write("修改失败");
            }

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
