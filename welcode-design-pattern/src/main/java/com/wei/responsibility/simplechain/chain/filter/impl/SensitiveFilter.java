package com.wei.responsibility.simplechain.chain.filter.impl;

import com.wei.responsibility.simplechain.chain.filter.Filter;

public class SensitiveFilter implements Filter {
    @Override
    public String doFilter(String msg) {
        return msg == null ? msg : msg.replaceAll("敏感","");
    }
}
