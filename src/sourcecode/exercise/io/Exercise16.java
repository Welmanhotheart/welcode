package exercise.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Exercise16 {
    static String file = "rtest123.dat";

    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        System.out.println("read double : " + rf.readDouble());
        System.out.println("read long : " + rf.readLong());// If I write readInt,
        // the following will
        // execute in wrong
        // rythm
        System.out.println("read int : " + rf.readInt());
        System.out.println("read char : " + rf.readChar());
        System.out.println("read short : " + rf.readShort());
        System.out.println("read byte : " + rf.readByte());
        System.out.println("read string : " + rf.readUTF());
        System.out.println("read string : " + rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        rf.writeDouble(3.14159);
        rf.writeLong(3L);
        rf.writeInt(300);
        rf.writeChar(97);
        rf.writeShort(970);
        rf.writeByte(100);
        rf.writeUTF("That was pi");
        rf.writeUTF("Square root of 2");
        rf.close();
        display();
    }
}

        /*
         * Yeah, It actually can retrieved accurately
         * output:
         * read double : 3.14159
         * read long : 3
         * read int : 300
         * read char : a
         * read short : 970
         * read byte : 100
         * read string : That was pi
         * read string : Square root of 2
         */
