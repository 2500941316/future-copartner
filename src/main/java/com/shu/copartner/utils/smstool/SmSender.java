package com.shu.copartner.utils.smstool;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author cxy
 */
@Slf4j
public class SmSender {
    private static final String url = "http://api.guoyangyun.com/api/sms/sendSmsApi.htm?";
    private static final String appkey = "1346155136202101302021099965008";
    private static final String appsecret = "4adeb8285793ed1461f3d83f9d6a8c5e";

    public static void sendSmCode(String phone, Integer code) {

        String finalUrl = url + "appkey=" + appkey + "&&appsecret=" + appsecret +
                "&mobile=" + phone + "&content=【短信验证】尊敬的未来合伙人用户,您的验证码为:" + code + ",五分钟内有效,不要告诉别人奥!";
        doPost(finalUrl);
    }

    public static String doPost(String URL) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        HttpURLConnection conn = null;
        try {
            java.net.URL url = new URL(URL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            //发送POST请求必须设置为true
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //设置连接超时时间和读取超时时间
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(10000);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            //获取输出流
            out = new OutputStreamWriter(conn.getOutputStream());
            String jsonStr = "{\"qry_by\":\"name\", \"name\":\"Tim\"}";
            out.write(jsonStr);
            out.flush();
            out.close();
            //取得输入流，并使用Reader读取
            if (200 == conn.getResponseCode()) {
                in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                String line;
                while ((line = in.readLine()) != null) {
                    result.append(line);
                    log.info(line);
                }
            } else {
                System.out.println("ResponseCode is an error code:" + conn.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return result.toString();
    }
}
