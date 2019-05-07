package com.wei.responsibility.webchain.chain.filter.impl;

import com.wei.responsibility.webchain.Request;
import com.wei.responsibility.webchain.Response;
import com.wei.responsibility.webchain.chain.FilterChain;
import com.wei.responsibility.webchain.chain.filter.Filter;

public abstract class MsgFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain filter) {
        String msg = request.getMsg();
        msg = msg == null ? msg : this.filter(msg);
        request.setMsg(msg + " " + this);
        filter.doFilter(request, response, filter);
        msg = response.getMsg();
        msg = this.filter(msg);
        response.setMsg(msg + " " + this);
    }

    protected abstract String filter(String msg);
}
