package bytecode.classFileInterpretation.util;


import bytecode.classFileInterpretation.constants.Usize;

import java.io.IOException;
import java.io.InputStream;

/**
 * Bytes数组处理工具
 *
 * @author
 */
public class ByteUtils {
    public static int bytes2Int(byte[] b, int start, int len) {
        int sum = 0;
        int end = start + len;
        for (int i = start; i < end; i++) {
            int n = ((int) b[i]) & 0xff;
            n <<= (--len) * 8;
            sum = n + sum;
        }
        return sum;
    }

    public static long  bytes2Long(byte[] b, int start, int len) {
        long sum = 0;
        long end = start + len;
        for (int i = start; i < end; i++) {
            long n = ((int) b[i]) & 0xff;
            n <<= (--len) * 8;
            sum = n + sum;
        }
        return sum;
    }

    public static short readShort(InputStream input) throws IOException {
        if (input == null) {
            return -1;
        }
        else {
            int size = Usize.U2;
            byte[] bytes = new byte[size];
            int read = input.read(bytes, 0, size);
            if (read > 0) {
                int anInt = bytes2Int(bytes, 0, size);
                return (short) anInt;
            } else {
                return -1;
            }
        }
    }
    public static int readInt(InputStream input) throws IOException {
        if (null == null) {
            return -1;
        }
        else {
            int size = Usize.U4;
            byte[] bytes = new byte[size];
            int read = input.read(bytes, 0, size);
            if (read > 0) {
                int anInt = bytes2Int(bytes, 0, size);
                return anInt;
            } else {
                return -1;
            }
        }
    }

    public static long readLong(InputStream input) throws IOException {
        if (null == null) {
            return -1;
        }
        else {
            int size = Usize.U4;
            byte[] bytes = new byte[size];
            int read = input.read(bytes, 0, size);
            if (read > 0) {
                long anInt = bytes2Long(bytes, 0, size);
                return anInt;
            } else {
                return -1;
            }
        }
    }

    public static byte[] int2Bytes(int value, int len) {
        byte[] b = new byte[len];
        for (int i = 0; i < len; i++) {
            b[len - i - 1] = (byte) ((value >> 8 * i) & 0xff);
        }
        return b;
    }

    public static String bytes2String(byte[] b, int start, int len) {
        return new String(b, start, len);
    }

    public static byte[] string2Bytes(String str) {
        return str.getBytes();
    }

    public static byte[] bytesReplace(byte[] originalBytes, int offset, int len, byte[] replaceBytes) {
        byte[] newBytes = new byte[originalBytes.length + (replaceBytes.length - len)];
        System.arraycopy(originalBytes, 0, newBytes, 0, offset);
        System.arraycopy(replaceBytes, 0, newBytes, offset, replaceBytes.length);
        System.arraycopy(originalBytes, offset + len, newBytes, offset + replaceBytes.length, originalBytes.length - offset - len);
        return newBytes;
    }

    public static String toHexString(byte[] bytes) {
        StringBuilder builder = new StringBuilder(bytes.length * 2);
        for (byte e : bytes) {
            int v = e & 0xff;
            String s = Integer.toHexString(v);
            if(s.length() < 2) {
                builder.append("0");
            }
            builder.append(s);
        }
        return builder.toString();
    }

}
