package com.wei.rest;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * TODO
 * @author <a href="zhiwei.wei@bintools.cn">zhiwei.wei</a>
 * @version 1.0.0 2020-10-2020/10/20-下午4:44
 */
public class TestRest {
    public static void main(String[] args) {
//        testRest();
//        testRest2();
        testRest3();
    }

    private static void testRest3() {
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("appStatus", "UNKNOWN");
        hashMap.put("host", "my1.doc.com");
        hashMap.put("ip", "177.18.1.1");
        hashMap.put("probeId", "YUIOKJHGCVBNASDF");
        hashMap.put("uploadDateTime", "548111548569655");
        HttpUriRequest request = RequestBuilder.post().
                setUri("http://127.0.0.1:3000/user/app/probe/data")
                .setEntity(new StringEntity(JSONObject.toJSONString(hashMap), ContentType.APPLICATION_JSON)).build();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            CloseableHttpResponse response = httpClient.execute(request);
            System.out.println(response.getStatusLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static void testRest2() {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://127.0.0.1:3000/user/app/probe/data");
        httpPost.setHeader("Content-Type", "application/json");
        List<NameValuePair> nameAndValues = new ArrayList<NameValuePair>();
        nameAndValues.add(new BasicNameValuePair("appStatus", "UNKNOWN"));
        nameAndValues.add(new BasicNameValuePair("host", "my1.doc.com"));
        nameAndValues.add(new BasicNameValuePair("ip", "177.18.1.1"));
        nameAndValues.add(new BasicNameValuePair("probeId", "YUIOKJHGCVBNASDF"));
        nameAndValues.add(new BasicNameValuePair("uploadDateTime", "548111548569655"));
        UrlEncodedFormEntity formEntity = null;
        try {
            formEntity = new UrlEncodedFormEntity(nameAndValues, "UTF-8");
            httpPost.setEntity(formEntity);
            HttpResponse execute = client.execute(httpPost);
//            execute.get
            System.out.println("done:" + execute.getStatusLine());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void testRest() {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://192.168.1.159:9898/dms/meta/node");
        List<NameValuePair> nameAndValues = new ArrayList<NameValuePair>();
        nameAndValues.add(new BasicNameValuePair("connectionId", "17"));
        nameAndValues.add(new BasicNameValuePair("connectionType", "SQLServer"));
        nameAndValues.add(new BasicNameValuePair("nodeName", "db_accessadmin"));
        nameAndValues.add(new BasicNameValuePair("nodePath", "/root/0/SqlServer/master/db_accessadmin"));
        nameAndValues.add(new BasicNameValuePair("nodeType", "schema"));
        UrlEncodedFormEntity formEntity = null;
        try {
            formEntity = new UrlEncodedFormEntity(nameAndValues, "UTF-8");
            httpPost.setEntity(formEntity);
            HttpResponse execute = client.execute(httpPost);
            System.out.println("done:" + execute.getStatusLine());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}