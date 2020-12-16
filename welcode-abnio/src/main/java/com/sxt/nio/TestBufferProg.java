package com.sxt.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

public class TestBufferProg {

    @Test
    public  void test() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        byte[] bytes = new byte[] {'a','b','c'};

        System.out.println("加入东西之前" + buffer);

        buffer.put(bytes);
        System.out.println("加入东西之后" + buffer);

        buffer.flip();
        System.out.println("flip之后" + buffer);


        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
        System.out.println("读取完之后" + buffer);

        System.out.println("清空数据之后" + buffer.clear());
    }


    @Test
    public void test1() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        byte[] bytes = new byte[] {'a','b','c','d'};

        System.out.println("加入东西之前" + buffer);

        buffer.put(bytes);
        System.out.println("加入东西之后" + buffer);
        System.out.println("flip之后" + buffer.flip());
        byte[] dst = new byte[2];
        buffer.get(dst);
        System.out.println("读取前半部分内容：" + new String(dst) + "之后" + buffer);
        buffer.mark();
        buffer.get(dst);
        System.out.println("mark后读取后半部分:" + new String(dst)+ "之后" + buffer);
        System.out.println("reset后" + buffer.reset());
        buffer.get(dst);
        System.out.println("reset后,读取后半部分内容：" + new String(dst) + buffer);
    }

    @Test
    public void test2() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        byte[] bytes = new byte[] {'a','b','c'};

        System.out.println("加入东西之前" + buffer);

        buffer.put(bytes);
        System.out.println("加入东西之后" + buffer);
        System.out.println("flip之后" + buffer.flip());

        byte[] dst = new byte[2];
        buffer.get(dst);
        System.out.println("读取部分内容之后:" + new String(dst) + buffer);

        System.out.println("rewind之后" + buffer.rewind());

        dst = new byte[bytes.length];
        buffer.get(dst);
        System.out.println("读取部分内容之后:" + new String(dst) + buffer);

    }
}
