package com.sxt.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestBlockingNIO2 {
    @Test
    public void server() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        try {
            serverSocketChannel.bind(new InetSocketAddress(8080));
            FileChannel fileChannel = FileChannel.open(Paths.get("D:/2.jpg"),
                    StandardOpenOption.READ,
                    StandardOpenOption.WRITE,
                    StandardOpenOption.CREATE);
            try {
                SocketChannel channel = serverSocketChannel.accept();

                try {
                    ByteBuffer dst = ByteBuffer.allocate(1024);
                    while(channel.read(dst)!= -1) {
                        dst.flip();
                        fileChannel.write(dst);
                        dst.clear();
                    }

                    dst.clear();
                    dst.put("图片接收完毕".getBytes());
                    dst.flip();
                    channel.write(dst);

                } finally {
                    channel.close();
                }
            } finally {
                fileChannel.close();
            }
        } finally {
            serverSocketChannel.close();
        }

    }

    @Test
    public void client() throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(8080));

        FileChannel fileChannel = FileChannel.open(Paths.get("1.png"),StandardOpenOption.READ);

        ByteBuffer dst = ByteBuffer.allocate(1024);

        while(fileChannel.read(dst) != -1) {
            dst.flip();
            socketChannel.write(dst);
            dst.clear();
        }

        socketChannel.shutdownOutput();

        dst.clear();
        int len = 0;
        while ((len = socketChannel.read(dst)) != -1) {
            dst.flip();
            System.out.println( new String(dst.array(), 0, len));
            dst.clear();
        }
    }
}
