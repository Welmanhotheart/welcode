package exercise.io;

import net.mindview.util.BinaryFile;
import net.mindview.util.Directory;
import net.mindview.util.Directory.TreeInfo;

import java.io.File;
import java.io.IOException;


public class Exercise20 {
    static String file = "rtest123.dat";
    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String bytesToHexFun1(byte[] bytes) {
        // 一个byte为8位，可用两个十六进制位标识
        char[] buf = new char[bytes.length * 2];
        int a = 0;
        int index = 0;
        for (byte b : bytes) { // 使用除与取余进行转换
            if (b < 0) {
                a = 256 + b;
            } else {
                a = b;
            }

            buf[index++] = HEX_CHAR[a / 16];
            buf[index++] = HEX_CHAR[a % 16];
        }

        return new String(buf);
    }

    public static void main(String[] args) throws IOException {
        TreeInfo treeInfo = Directory.walk(".", ".\\.class");
        for (File f : treeInfo) {
            byte[] bts = BinaryFile.read(f);
            System.out.println(bytesToHexFun1(bts));
        }
        System.out.println();
    }
}
/**
 * Yeah, It really is
 */
