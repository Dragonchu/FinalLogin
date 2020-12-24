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

@WebServlet("/updatePassWord")
public class UpdatePassWord extends DBServlet {
    @Override
    protected String WrongMessage() {
        return "修改失败";
    }

    @Override
    protected String SqlSelect() {
        return "select * from login where pass = '"+password+"' and user = '"+username+"' and tel = '"+tel+"'";
    }

    @Override
    protected String Sql() {
        return "update login set pass = '"+password+"' where user = '"+username+"' and tel='"+tel+"'";
    }
    
}
