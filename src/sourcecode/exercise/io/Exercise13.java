package exercise.io;

import java.io.File;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.StringReader;


import testcase.io.BufferedInputFile;

public class Exercise13 {
    public static void main(String[] args) throws IOException {
        BasicFileOutput.main(args);
    }
}


class BasicFileOutput {
    static String file = "D:/learnjavaworkspace/TheReplacements.out";

    public static void main(String[] args)
            throws IOException {
        LineNumberReader in = new LineNumberReader(
                new StringReader(
                        BufferedInputFile.read("D:/learnjavaworkspace/TheReplacements.txt")));
        PrintWriter out = new PrintWriter(new File(file));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            /*
             * Yeah ,here use in.getLineNumber() can keep track of the line that it reads
             */
            out.println(in.getLineNumber() + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
} /* (Execute to see output) *///:~

