package com.sxt.nio;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class TestNonBlockingNIO {

//    @Test

    @Test
    public void server() throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(8080));

        serverChannel.configureBlocking(false);


        Selector selector = Selector.open();

        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

       ;
        Set<SelectionKey> keys = selector.selectedKeys();
        while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = keys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                try {
                    if (key.isValid()) {
                        if (key.isAcceptable()){
                            SocketChannel socketChannel = serverChannel.accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector, SelectionKey.OP_READ);
                        } else if (key.isReadable()) {
                            SocketChannel socketChannel = (SocketChannel) key.channel();

                            ByteBuffer dst = ByteBuffer.allocate(1024);
                            int len = 0;
                            while((len = socketChannel.read(dst)) != -1) {
                                if(len == 0) {
                                    break;
                                }
                                dst.flip();
                                System.out.println(new String(dst.array(), 0, len));
                                dst.clear();
                            }
                            socketChannel.register(selector, SelectionKey.OP_WRITE);
                        } else if (key.isWritable()) {
                            SocketChannel channel = (SocketChannel) key.channel();
                            ByteBuffer dst = ByteBuffer.allocate(1024);
                            Scanner scanner = new Scanner(System.in);
                            System.out.println("服务端，请输入内容：...");

                            while (scanner.hasNext()) {
                                String next = scanner.next();
                                if (next.startsWith("#")) break;
                                dst.put(next.getBytes());
                                dst.flip();
                                channel.write(dst);
                                dst.clear();
                            }

                            channel.register(selector, SelectionKey.OP_READ);
                        }
                    }
                    iterator.remove();
                } catch (IOException e) {
                    System.out.println(e.getCause());
                }
            }
        }
    }


    @Test
    public void client() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1",8080));
        socketChannel.configureBlocking(false);
        Scanner scanner = new Scanner(System.in);
        System.out.println("客户端，请输入内容：...");

        ByteBuffer dst = ByteBuffer.allocate(1024);
        while (scanner.hasNext()) {
            String next = scanner.next();
            if (next.startsWith("#")) break;
            dst.put(next.getBytes());
            dst.flip();
            socketChannel.write(dst);
            dst.clear();
        }

        socketChannel.shutdownOutput();

        dst.clear();
        int len = 0;

        while((len = socketChannel.read(dst)) != -1) {
            if (len == 0) break;
            dst.flip();
            System.out.println("读取服务端内容：" + new String(dst.array(), 0, len));
            dst.clear();
        }
        socketChannel.close();
        scanner.close();
    }

    @Test
    public void testScanner() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String next = scanner.next();
            System.out.println(next);
        }
    }

    @Test
    public void testSystemIn() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        System.out.println(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        System.out.println(s);
    }
}
