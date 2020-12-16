package com.wei.responsibility.webchain;

import com.wei.responsibility.webchain.chain.FilterChain;
import com.wei.responsibility.webchain.chain.filter.impl.EmotionFilter;
import com.wei.responsibility.webchain.chain.filter.impl.HTMLFilter;
import com.wei.responsibility.webchain.chain.filter.impl.SensitiveFilter;

public class HttpMsgIntercepter {

    private FilterChain msgFilterChain;
    public HttpMsgIntercepter() {
        msgFilterChain = new FilterChain();
        msgFilterChain.addFilter(new EmotionFilter());
        msgFilterChain.addFilter(new HTMLFilter());
        msgFilterChain.addFilter(new SensitiveFilter());

        FilterChain fc = new FilterChain();
        fc.addFilter(new SensitiveFilter());
        fc.addFilter(new EmotionFilter());

        msgFilterChain.addFilter(fc);
    }

    public void intercept(Request request, Response response) {
        msgFilterChain.doFilter(request, response, msgFilterChain);
    }
}
