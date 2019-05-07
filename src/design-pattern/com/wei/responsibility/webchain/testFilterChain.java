package com.wei.responsibility.webchain;

public class testFilterChain {
    public static void main(String[] args) {
        HttpMsgIntercepter intercepter = new HttpMsgIntercepter();
        Request request = new Request("敏感词汇，^^, <html><div>");
        Response response = new Response("，^^, <scripts>");
        intercepter.intercept(request, response);
        System.out.println("requestMsg: " + request.getMsg());
        System.out.println("responseMsg: " + response.getMsg());
    }
}
