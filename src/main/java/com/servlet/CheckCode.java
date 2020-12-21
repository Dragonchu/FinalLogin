package com.servlet;

import com.util.JsonReader;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkCode")
public class CheckCode extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        var json = JsonReader.receivePost(request);
        var Code = (com.jsonClass.code) JSONObject.toBean(json, com.jsonClass.code.class);
        String code = Code.getCode();
        var RightCodeJson=(JSONObject)request.getSession().getAttribute("MsCode");
        if(!RightCodeJson.getString("Code").equals(code)){
            response.getWriter().write("验证码错误");
        }else if(System.currentTimeMillis()-RightCodeJson.getLong("createTime")> 1000 * 60){
            response.getWriter().write("验证码过期");
        }else{
            response.getWriter().write("success");
        }


    }
}
