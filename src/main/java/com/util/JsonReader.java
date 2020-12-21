package com.util;

import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class JsonReader {
    public static JSONObject receivePost(HttpServletRequest request) throws UnsupportedEncodingException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"UTF-8"));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine())!=null){
            sb.append(line);
        }
        JSONObject json = JSONObject.fromObject(sb.toString());
        return json;
    }
}
