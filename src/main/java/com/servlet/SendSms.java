package com.servlet;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.jsonClass.user;
import com.util.GetMessageCode;
import com.util.JsonReader;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sendSMS")
public class SendSms extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var json = JsonReader.receivePost(request);
        var phoneNumber = (com.jsonClass.phone) JSONObject.toBean(json, com.jsonClass.phone.class);
        String phone = phoneNumber.getPhone();
        //根据获取到的手机号发送验证码
        String code = null;
        try {
            code = GetMessageCode.getCode(phone);
        } catch (HTTPException e) {
            e.printStackTrace();
        }
        System.out.print("短信已经发送，请等待");
        //使用servlet session来将此次产生的验证码和时间保存下来
        HttpSession session = request.getSession();
        JSONObject codeJson = new JSONObject();
        codeJson.put("Code",code);
        codeJson.put("createTime",System.currentTimeMillis());
        request.getSession().setAttribute("MsCode",codeJson);
    }
}
