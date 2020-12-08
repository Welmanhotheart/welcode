package com.wei.responsibility.simplechain;

import com.wei.responsibility.simplechain.chain.MsgFilterChain;

public class MsgProcessor {

    private String msg;

    private MsgFilterChain chain;

    public MsgProcessor(String msg) {
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setChain(MsgFilterChain chain) {
        this.chain = chain;
    }

    public String process() {
        return chain.doFilter(msg);
    }


}
