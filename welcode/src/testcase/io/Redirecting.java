package testcase.io;

//: io/Redirecting.java
// Demonstrates standard I/O redirection.
import java.io.*;

public class Redirecting {
  public static void main(String[] args)
  throws IOException {
    DataOutputStream out = new DataOutputStream(
        new BufferedOutputStream(
          new FileOutputStream("Data.txt")));
      out.writeDouble(3.14159);
      out.writeLong(3L);
      out.writeInt(300);
      out.writeChar(97);
      out.writeShort(970);
      out.writeByte(100);
      out.writeUTF("That was pi");
      out.writeUTF("Square root of 2");
      out.close();
      DataInputStream in = new DataInputStream(
        new BufferedInputStream(
          new FileInputStream("Data.txt")));
      System.out.println("read double : " + in.readDouble());
      System.out.println("read long : " + in.readLong());// If I write readInt, the following will execute in wrong rythm
      System.out.println("read int : " + in.readInt());
      System.out.println("read char : " + in.readChar());
      System.out.println("read short : " + in.readShort());
      System.out.println("read byte : " + in.readByte());
      System.out.println("read string : " + in.readUTF());
      System.out.println("read string : " + in.readUTF());
    }
} ///:~
