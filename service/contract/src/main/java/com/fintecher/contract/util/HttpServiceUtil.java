package com.fintecher.contract.util;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class HttpServiceUtil {
    private static Logger logger = LoggerFactory.getLogger(HttpServiceUtil.class);

    public HttpServiceUtil() {
    }

    public static String sendPost(String url, Map<String, Object> paramMap) {
        HttpPost httpRequset = new HttpPost(url);
        List<NameValuePair> params = new ArrayList();
        String key;
        if (paramMap != null) {
            Set<String> keys = paramMap.keySet();
            NameValuePair[] data = new NameValuePair[keys.size()];
            Iterator it = keys.iterator();

            while(it.hasNext()) {
                key = String.valueOf(it.next());
                params.add(new BasicNameValuePair(key, paramMap.get(key).toString()));
            }
        }

        DefaultHttpClient httpClient = new DefaultHttpClient();

        String var24;
        try {
            HttpEntity httpentity = new UrlEncodedFormEntity(params, "utf-8");
            httpRequset.setEntity(httpentity);
            httpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(10000));
            HttpResponse httpResponse = httpClient.execute(httpRequset);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = httpResponse.getEntity();
                if (null == entity) {
                    return "";
                }

                String var8 = EntityUtils.toString(httpResponse.getEntity());
                return var8;
            }

            key = "";
            return key;
        } catch (Exception var20) {
            logger.warn(var20.getMessage(), var20);
            var24 = "";
        } finally {
            if (httpClient != null) {
                try {
                    logger.warn(" HttpUtils httpclient close");
                    httpClient.close();
                } catch (Throwable var19) {
                    logger.error("httpClient.close()", var19);
                }
            }

        }

        return var24;
    }

    public static JSONObject sendPost(String url, Object[] params) {
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuffer result = new StringBuffer();

        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection)realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setConnectTimeout(180000);
            conn.setReadTimeout(180000);
            out = new PrintWriter(conn.getOutputStream());
            Object[] arr$ = params;
            int len$ = params.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                Object object = arr$[i$];
                out.print(object);
            }

            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            String line;
            while((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception var21) {
            logger.error(var21.getMessage(), var21);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }

                if (in != null) {
                    in.close();
                }
            } catch (IOException var19) {
                logger.error(var19.getMessage(), var19);
            }

        }

        logger.warn("post请求返回：" + result.toString());
        JSONObject rstJson = new JSONObject();

        try {
            rstJson = JSONObject.fromObject(result.toString());
        } catch (Exception var20) {
            rstJson.put("responseCode", "0");
            rstJson.put("data", "post请求返回异常！");
            rstJson.put("responseBankCode", "");
            logger.error(var20.getMessage(), var20);
        }

        return rstJson;
    }

    public static String sendPostNew(String url, Map<String, Object> paramMap) throws Exception {
        DefaultHttpClient httpClient = new DefaultHttpClient();

        String var21;
        try {
            HttpPost httpRequset = new HttpPost(url);
            List<NameValuePair> params = new ArrayList();
            String key;
            if (paramMap != null) {
                Set<String> keys = paramMap.keySet();
                NameValuePair[] data = new NameValuePair[keys.size()];
                Iterator it = keys.iterator();

                while(it.hasNext()) {
                    key = String.valueOf(it.next());
                    params.add(new BasicNameValuePair(key, paramMap.get(key).toString()));
                }
            }

            HttpEntity httpentity = new UrlEncodedFormEntity(params, "utf-8");
            httpRequset.setEntity(httpentity);
            httpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(10000));
            HttpResponse httpResponse = httpClient.execute(httpRequset);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = httpResponse.getEntity();
                if (null != entity) {
                    key = EntityUtils.toString(httpResponse.getEntity());
                    return key;
                }

                key = "";
                return key;
            }

            var21 = "";
        } finally {
            if (httpClient != null) {
                try {
                    logger.warn(" HttpUtils httpclient close");
                    httpClient.close();
                } catch (Throwable var17) {
                    logger.error("httpClient.close()", var17);
                }
            }

        }

        return var21;
    }

//    public static String postFile(byte[] fileByte, String returnPath, String url) throws ClientProtocolException, IOException {
//        DefaultHttpClient httpClient = new DefaultHttpClient();
//
//        InputStream var11;
//        try {
//            HttpPost httppost = new HttpPost(url);
//            String fileByteString = (new BASE64Encoder()).encodeBuffer(fileByte);
//            StringBody path = new StringBody(returnPath);
//            StringBody byteString = new StringBody(fileByteString);
//            MultipartEntity reqEntity = new MultipartEntity();
//            reqEntity.addPart("path", path);
//            reqEntity.addPart("data", byteString);
//            httppost.setEntity(reqEntity);
//            HttpResponse response = httpClient.execute(httppost);
//            HttpEntity resEntity = response.getEntity();
//            if (resEntity != null) {
//                var11 = resEntity.getContent();
//            }
//
//            if (resEntity != null) {
//                resEntity.consumeContent();
//            }
//
//            var11 = null;
//        } finally {
//            if (httpClient != null) {
//                try {
//                    logger.warn(" HttpUtils httpclient close");
//                    httpClient.close();
//                } catch (Throwable var18) {
//                    logger.error("httpClient.close()", var18);
//                }
//            }
//
//        }
//
//        return var11;
//    }

    public static void main(String[] args) {
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("sysNumber", "crm");
        paramMap.put("cust_nm", "费新玮");
        paramMap.put("certif_id", "320502199107240036");
        paramMap.put("mobile_no", "15952411145");
        paramMap.put("email", "272548484@qq.com");
        paramMap.put("city_id", "3050");
        paramMap.put("parent_bank_id", "0105");
        paramMap.put("bank_nm", "中国建设银行股份有限公司苏州分行");
        paramMap.put("capAcntNm", "费新玮");
        paramMap.put("capAcntNo", "6227002001070123483");
        paramMap.put("password", "411145");
        paramMap.put("lpassword", "411145");
        paramMap.put("rem", "111");
        String abc = sendPost("http://192.168.23.33:8888/poc/reg.html", (Map)paramMap);
    }
}

