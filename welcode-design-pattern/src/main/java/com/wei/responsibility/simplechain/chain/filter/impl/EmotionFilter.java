package com.wei.responsibility.simplechain.chain.filter.impl;

import com.wei.responsibility.simplechain.chain.filter.Filter;

public class EmotionFilter implements Filter {
    @Override
    public String doFilter(String msg) {
        return msg == null ? msg : msg.replaceAll("\\^", "");
    }
}
