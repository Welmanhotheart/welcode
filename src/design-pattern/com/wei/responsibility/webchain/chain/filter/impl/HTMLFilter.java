package com.wei.responsibility.webchain.chain.filter.impl;

import com.wei.responsibility.webchain.Request;
import com.wei.responsibility.webchain.Response;
import com.wei.responsibility.webchain.chain.FilterChain;
import com.wei.responsibility.webchain.chain.filter.Filter;

public class HTMLFilter extends MsgFilter implements Filter {

    @Override
    protected String filter(String msg) {
        return msg == null ? null : msg.replaceAll("[<>]", "");
    }

    @Override
    public String toString() {
        return "HTMLFilter ";
    }
}
