package com.wei.responsibility.webchain.chain.filter;

import com.wei.responsibility.webchain.Request;
import com.wei.responsibility.webchain.Response;
import com.wei.responsibility.webchain.chain.FilterChain;

public interface Filter {
    void doFilter(Request request, Response response, FilterChain filter);
}
