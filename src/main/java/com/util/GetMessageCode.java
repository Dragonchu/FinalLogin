package com.util;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import net.sf.json.JSONException;

import java.io.IOException;

public class GetMessageCode {

    //创建验证码
    public static String smsCode(){
        String random=(int)((Math.random()*9+1)*100000)+"";
        System.out.print("random验证码:"+random);
        return random;
    }
    //根据相应的手机号发送验证码
    public static String getCode(String phone) throws HTTPException, IOException {
        // 短信应用SDK AppID  1400开头
        int appid = 1400463553 ;
        // 短信应用SDK AppKey
        String appkey = "af28bb84c98aaff5909694ee67d70922";
        // 短信模板ID，需要在短信应用中申请
        int templateId = 815229;
        // 签名，使用的是签名内容，而不是签名ID
        String smsSign = "loveants";
        //随机生成四位验证码的工具类
        String code = smsCode();
            //参数，一定要对应短信模板中的参数顺序和个数，
            String[] params = {code};
            //创建ssender对象
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            //发送
            SmsSingleSenderResult result = ssender.sendWithParam("86", phone,templateId, params, smsSign, "", "");
            return code;
    }

}
