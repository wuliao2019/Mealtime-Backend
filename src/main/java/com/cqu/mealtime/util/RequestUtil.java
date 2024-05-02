package com.cqu.mealtime.util;

import okhttp3.*;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Map;

public class RequestUtil {
    public static final String API_KEY = "wkRrmGpuV9nFOWhwIpr4z0f3";
    public static final String SECRET_KEY = "GNgMEbW4snhZD1wPr6qF9sLVcdUFxZ4m";
    static final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();

    /**
     * 将map型转为请求参数型
     */
    public static String urlEncode(Map<String, ?> data) {
        if (data.isEmpty())
            return "";
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, ?> i : data.entrySet()) {
            sb.append(i.getKey()).append("=").append(i.getValue()).append("&");
        }
        String result = sb.toString();
        result = result.substring(0, result.lastIndexOf("&"));
        return result;
    }

    public static String doPost(String httpUrl, String queryParams) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        String result = null;// 返回结果字符串
        try {
            // 创建远程url连接对象
            URL url = new URL(httpUrl + "?" + queryParams);
            // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接方式：get
            connection.setRequestMethod("POST");
            // 设置连接主机服务器的超时时间：15000毫秒
            connection.setConnectTimeout(5000);
            // 设置读取远程返回的数据时间：60000毫秒
            connection.setReadTimeout(6000);
            // 发送请求
            connection.connect();
            // 通过connection连接，获取输入流
            if (connection.getResponseCode() == 200) {
                inputStream = connection.getInputStream();
                // 封装输入流，并指定字符集
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                // 存放数据
                StringBuilder sbf = new StringBuilder();
                String temp;
                while ((temp = bufferedReader.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append(System.lineSeparator());
                }
                result = sbf.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();// 关闭远程连接
            }
        }
        return result;
    }

    /**
     * 获取文件base64编码
     *
     * @param path      文件路径
     * @param urlEncode 如果Content-Type是application/x-www-form-urlencoded时,传true
     * @return base64编码信息，不带文件头
     * @throws IOException IO异常
     */
    static String getFileContentAsBase64(String path, boolean urlEncode) throws IOException {
        byte[] b = Files.readAllBytes(Paths.get(path));
        String base64 = Base64.getEncoder().encodeToString(b);
        if (urlEncode) {
            base64 = URLEncoder.encode(base64, StandardCharsets.UTF_8);
        }
        return base64;
    }


    /**
     * 从用户的AK，SK生成鉴权签名（Access Token）
     *
     * @return 鉴权签名（Access Token）
     * @throws IOException IO异常
     */
    static String getAccessToken() throws IOException {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials&client_id=" + API_KEY + "&client_secret=" + SECRET_KEY);
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/oauth/2.0/token")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        return new JSONObject(response.body().string()).getString("access_token");
    }

    public static String queryName(String file_path) {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        Request request;
        String result;
        try {
            RequestBody body = RequestBody.create(mediaType, "image=" + getFileContentAsBase64(file_path, true));
            request = new Request.Builder()
                    .url("https://aip.baidubce.com/rest/2.0/ocr/v1/facade?access_token=" + getAccessToken())
                    .method("POST", body)
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .addHeader("Accept", "application/json")
                    .build();
            Response response = HTTP_CLIENT.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
