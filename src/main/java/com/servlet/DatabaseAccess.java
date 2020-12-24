package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

import com.jsonClass.user;
import com.util.DBServlet;
import com.util.JsonReader;
import net.sf.json.JSONObject;

public class DatabaseAccess extends DBServlet {
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
        return "select * from login where pass = '"+password+"' and user = '"+username+"'";
    }
}
