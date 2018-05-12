package testcase.io;

//: io/BasicFileOutput.java
import java.io.*;

public class BasicFileOutput {
  static String file = "D:/learnjavaworkspace/TheReplacements.out";
  public static void main(String[] args)
  throws IOException {
    BufferedReader in = new BufferedReader(
      new StringReader(
        BufferedInputFile.read("D:/learnjavaworkspace/TheReplacements.txt")));
    PrintWriter out = new PrintWriter(
      new BufferedWriter(new FileWriter(file)));
    int lineCount = 1;
    String s;
    while((s = in.readLine()) != null ) {
    	out.println(lineCount++ + ": " + s);
    }
    /*
     *  yeah ,here if I dont close the out, then its relative file has no content
     *  because you can see that the out's decorator is a bufferendWriter
     */
    out.close();
    // Show the stored file:
    System.out.println(BufferedInputFile.read(file));
  }
} /* (Execute to see output) *///:~
