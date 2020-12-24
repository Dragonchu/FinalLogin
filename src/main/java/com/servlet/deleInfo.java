package com.servlet;

import com.util.DBServlet;
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
public class deleInfo extends DBServlet {
    @Override
    protected String WrongMessage() {
        return null;
    }

    @Override
    protected String SqlSelect() {
        return "select * from login";
    }

    @Override
    protected String Sql() {
        return "delete from login where user = '"+username+"' and pass = '"+password+"' and tel = '"+tel+"';";
    }
}
