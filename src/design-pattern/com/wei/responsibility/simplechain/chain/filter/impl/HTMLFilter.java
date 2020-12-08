package com.wei.responsibility.simplechain.chain.filter.impl;

import com.wei.responsibility.simplechain.chain.filter.Filter;

public class HTMLFilter implements Filter {
    @Override
    public String doFilter(String msg) {
       return msg == null ? null : msg.replaceAll("[<>]", "");
    }
}
