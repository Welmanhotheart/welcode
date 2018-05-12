package sourcecode.io;

//: io/ChangeSystemOut.java
// Turn System.out into a PrintWriter.

import java.io.*;

public class ChangeSystemOut {
    public static void main(String[] args) {
//    PrintWriter out = new PrintWriter(System.out, true);
        PrintWriter out = new PrintWriter(System.out, false);
        out.println("Hello, world");
        out.close();
    }
} /* Output:
Hello, world
*///:~
        /*Here the Outputstream mean where the data goes
         *
         * PrintWriter has an overloaded constructor that has two parameters
         * one is Outputstream-type and another is boolean that indicates whether every write() action
         * needs to be flushed
         * */
