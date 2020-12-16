package com.sxt.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.SortedMap;

public class TestChannel {

    @Test
    public void testEncodeAndDecode() throws CharacterCodingException {
        Charset charset = Charset.forName("GBK");
        CharsetEncoder encoder = charset.newEncoder();
        String str = "我要学习Java";
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put(str);
        charBuffer.flip();
        ByteBuffer byteBuffer = encoder.encode(charBuffer);
        charBuffer.flip();
        System.out.println("编码后的charbuffer:" + new String(byteBuffer.array()));

        CharsetDecoder decoder = charset.newDecoder();
        CharBuffer decode = decoder.decode(byteBuffer);

        System.out.println("解码后的charbuffer:" + new String(decode.toString()));


    }


    @Test
    public void testCharset() {
        SortedMap<String, Charset> map = Charset.availableCharsets();
        for (Map.Entry<String, Charset> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    @Test
    public void testChannel1() throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream in = new FileInputStream(new File("1.png"));
        try {
            FileChannel inChannel = in.getChannel();

            try {
                FileOutputStream out = new FileOutputStream(new File("2.png"));

                try {
                    FileChannel outChannel = out.getChannel();
                    try {
                        ByteBuffer dst = ByteBuffer.allocate(1024);
                        while (inChannel.read(dst) != -1) {
                            dst.flip();
                            outChannel.write(dst);
                            dst.clear();
                        }
                    } finally {
                        outChannel.close();
                    }
                } finally {
                    out.close();
                }
            } finally {
                inChannel.close();
            }
        } finally {
            in.close();
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }

    @Test
    public void testChannel2() throws IOException {
        long start = System.currentTimeMillis();
        FileChannel rChannel = FileChannel.open(Paths.get("1.png"), StandardOpenOption.READ);
        try {
            FileChannel oChannel = FileChannel.open(Paths.get("2.png"), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.READ);
            try {
                MappedByteBuffer rMap = rChannel.map(FileChannel.MapMode.READ_ONLY, 0, rChannel.size());
                MappedByteBuffer oMap = oChannel.map(FileChannel.MapMode.READ_WRITE, 0, rChannel.size());
                byte[] dst = new byte[rMap.limit()];
                rMap.get(dst);
                oMap.put(dst);
            } finally {
                oChannel.close();
            }
        } finally {
            rChannel.close();
        }

        System.out.println("耗时" + (System.currentTimeMillis() - start));

    }

    @Test
    public void testChannel3() throws IOException {
        long start = System.currentTimeMillis();
        FileChannel rChannel = FileChannel.open(Paths.get("1.png"), StandardOpenOption.READ);
        try {
            FileChannel oChannel = FileChannel.open(Paths.get("2.png"), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.READ);
            try {
               rChannel.transferTo(0, rChannel.size(),oChannel);
            } finally {
                oChannel.close();
            }
        } finally {
            rChannel.close();
        }

        System.out.println("耗时" + (System.currentTimeMillis() - start));

    }


    @Test
    public void testRandomAccessFile() throws IOException {
        long start = System.currentTimeMillis();
        RandomAccessFile rfile = new RandomAccessFile("1.png","r");
        try {
            FileChannel channel = rfile.getChannel();
            try {
                ByteBuffer buffer1 = ByteBuffer.allocate(1024),
                        buffer2 =ByteBuffer.allocate(1024);
                ByteBuffer[] dst = new ByteBuffer[] {buffer1,buffer2};

                RandomAccessFile ofile = new RandomAccessFile("2.png","rw");
                try {
                    FileChannel ofileChannel = ofile.getChannel();
                    try {
                        while(channel.read(dst) != -1) {
                            for (ByteBuffer byteBuffer : dst) {
                                byteBuffer.flip();
                            }
                            ofileChannel.write(dst);
                            for (ByteBuffer byteBuffer : dst) {
                                byteBuffer.clear();
                            }
                        }
                    } finally {
                        ofileChannel.close();
                    }
                } finally {
                    ofile.close();
                }
            } finally {
                channel.close();
            }
        } finally {
            rfile.close();
        }
        System.out.println("耗时" + (System.currentTimeMillis() - start));
    }
    @Test
    public void testFilePath() {
        System.out.println(new File("1.png").getAbsolutePath());
    }
}
