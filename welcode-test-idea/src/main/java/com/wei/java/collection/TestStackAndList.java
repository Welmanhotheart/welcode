package com.wei.java.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 * TODO
 * @author <a href="zhiwei.wei@bintools.cn">zhiwei.wei</a>
 * @version 1.0.0 2021-01-2021/1/14-上午11:01
 */
public class TestStackAndList {

    @Test
    public void testStackAndList() {
        Stack<String> list = new Stack<>();
        list.push("1");
        list.push("2");
        list.push("3");

        for (String s : list) {
            System.out.println(s);
        }
    }
}
