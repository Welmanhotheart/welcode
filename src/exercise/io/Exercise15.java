package exercise.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import testcase.io.BufferedInputFile;

public class Exercise15 {
	/**
	 * 输出文件
	 */
	static final String outputFile = "D:/learnjavaworkspace/TheReplacements.out";

	/**
	 * 要读取的文件
	 */
	static final String inputFile = "D:/learnjavaworkspace/TheReplacements.txt";

	public static void testBufferWriter() throws IOException {
		BufferedReader in = new BufferedReader(new StringReader(
				BufferedInputFile.read("D:/learnjavaworkspace/TheReplacements.txt")));
		try {
			PrintWriter buffWriter = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
			try {
				String s;
				while ((s = in.readLine()) != null) {
					buffWriter.println(s);
				}
			} finally {
				buffWriter.close();
			}
		} finally {
			in.close();
		}
	}
	
	
	public static void testUnBufferWriter() throws IOException {
		BufferedReader in = new BufferedReader(new StringReader(
				BufferedInputFile.read("D:/learnjavaworkspace/TheReplacements.txt")));
		try {
			PrintWriter buffWriter = new PrintWriter((new FileWriter(outputFile)));
			try {
				String s;
				while ((s = in.readLine()) != null) {
					buffWriter.println(s);
				}
			} finally {
				buffWriter.close();
			}
		} finally {
			in.close();
		}
	}
	public static void main(String[] args) throws IOException {
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
}
/**
 * output following:
 read double : 3.14159
read long : 3
read int : 300
read char : a
read short : 970
read byte : 100
read string : That was pi
read string : Square root of 2

Having seeing the source code, I can know that read different data of different types,
the number of bytes ahead is different
 */
