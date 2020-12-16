package com.javapapers.java.instrumentation;

import java.lang.instrument.Instrumentation;
/***
 *
 * @author <a href="邮箱或其他信息">自己的姓名</a>
 * @version 1.0.0 2019---
 */
public class DurationAgent {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("Executing premain.........");
        int a = 1+2;
        System.out.println(a);
        inst.addTransformer(new DurationTransformer());
    }
}