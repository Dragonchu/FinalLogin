package com.servlet;

import com.jsonClass.user;
import com.util.DBServlet;
import com.util.JsonReader;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/adminLogin")
public class AdminLogin extends DBServlet {
    @Override
    protected String WrongMessage() {
        return "用户名或者账号错误";
    }

    @Override
    protected String SqlSelect() {
        return Sql();
    }

    @Override
    protected String Sql() {
        return "select * from adminLogin where pass = '"+password+"' and user = '"+username+"'";
    }
}
