package com.wei.java.sqlserver;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/***
 * TODO
 * @author <a href="zhiwei.wei@bintools.cn">zhiwei.wei</a>
 * @version 1.0.0 2021-10-2021/10/29-上午11:21
 */
public class SqlServerBuildinFunctionExtractor {
    static String prefix = "https://www.techonthenet.com/sql_server/functions/";
    public static void main(String[] args) throws IOException {
        File buildin_functions = new File("/home/weizhiwei/working_code_space/welcode/java-extractor/src/test/java/com/wei/java/sqlserver/SQLServerBuildinFunction.txt");
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(buildin_functions));
        BufferedReader reader = new BufferedReader(new InputStreamReader(bf));
        String s = reader.readLine();
        List<String> listFunctionDetailDesc = new ArrayList<String>();
        while (s != null) {
            s = reader.readLine();
            s = s.trim();
            try {
                String url = prefix + s.toLowerCase() + ".php";
                listFunctionDetailDesc.add(findDetailedDesc(url));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    public static String findDetailedDesc(String urlStr) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        //2.创建get请求，相当于在浏览器地址栏输入 网址
        HttpGet request = new HttpGet(urlStr);
        try {
            //3.执行get请求，相当于在输入地址栏后敲回车键
            response = httpClient.execute(request);

            //4.判断响应状态为200，进行处理
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                //5.获取响应内容
                HttpEntity httpEntity = response.getEntity();
                String html = EntityUtils.toString(httpEntity, "utf-8");
                System.out.println(html);
            } else {
                //如果返回状态不是200，比如404（页面不存在）等，根据情况做处理，这里略
                System.out.println("返回状态不是200");
                System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.关闭
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
        return null;
    }
}