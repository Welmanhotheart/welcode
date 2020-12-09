package testcase.io;

//: io/FileOutputShortcut.java

import java.io.*;

public class FileOutputShortcut {
    static String file = "D:\\learnjavaworkspace\\TheReplacements.out";

    public static void main(String[] args)
            throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("D:\\learnjavaworkspace\\TheReplacements.txt")));
        // Here's the shortcut:
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null)
            out.println(lineCount++ + ": " + s);

        /*
         * It still get bufferring ,because its constructor is shown as follows:
         * 		this(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName))),false);
         * it first layer decorator is bufferedWriter
         */
        out.close();
        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }
} /* (Execute to see output) *///:~
