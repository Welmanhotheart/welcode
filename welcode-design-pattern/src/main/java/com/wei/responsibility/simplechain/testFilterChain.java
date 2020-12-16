package com.wei.responsibility.simplechain;

import com.wei.responsibility.simplechain.chain.MsgFilterChain;
import com.wei.responsibility.simplechain.chain.filter.impl.EmotionFilter;
import com.wei.responsibility.simplechain.chain.filter.impl.HTMLFilter;
import com.wei.responsibility.simplechain.chain.filter.impl.SensitiveFilter;

public class testFilterChain {
    public static void main(String[] args) {
        MsgProcessor processor = new MsgProcessor("敏感词汇，^^,<script>");
        MsgFilterChain msgFilterChain = new MsgFilterChain();
        msgFilterChain.addFilter(new EmotionFilter());
        msgFilterChain.addFilter(new HTMLFilter());
        msgFilterChain.addFilter(new SensitiveFilter());

        processor.setChain(msgFilterChain);

        String msg = processor.process();
        System.out.println("经过处理后的信息是：" + msg);
    }
}
