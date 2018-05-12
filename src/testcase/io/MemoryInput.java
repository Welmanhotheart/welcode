package testcase.io;

//: io/MemoryInput.java
import java.io.*;

public class MemoryInput {
  public static void main(String[] args)
  throws IOException {
  	/*
  	 * read one char at one time
  	 */
    StringReader in = new StringReader(
      BufferedInputFile.read("D:/learnjavaworkspace/TheReplacements.txt"));
    int c;
    while((c = in.read()) != -1)
      System.out.print((char)c);
  }
} /* (Execute to see output) *///:~
