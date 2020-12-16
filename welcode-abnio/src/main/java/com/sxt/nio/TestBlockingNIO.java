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

public class TestBlockingNIO {

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
    public void clientProg() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        try {
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));

            FileChannel fileChannel = FileChannel.open(Paths.get("1.png"), StandardOpenOption.READ);

            try {
                fileChannel.transferTo(0, fileChannel.size(), socketChannel);
            } finally {
                fileChannel.close();
            }
        } finally {
            socketChannel.close();
        }

    }

    @Test
    public void client() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        try {
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));

            FileChannel fileChannel = FileChannel.open(Paths.get("1.png"), StandardOpenOption.READ);
            try {
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                while(fileChannel.read(buffer) != -1) {
                    buffer.flip();
                    socketChannel.write(buffer);
                    buffer.clear();
                }
            } finally {
                fileChannel.close();
            }
        } finally {
            socketChannel.close();
        }

    }

}
