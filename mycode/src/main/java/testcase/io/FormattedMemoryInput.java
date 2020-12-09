package testcase.io;

//: io/FormattedMemoryInput.java

import java.io.*;

public class FormattedMemoryInput {
    public static void main(String[] args)
            throws IOException {
        try {
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(
                            BufferedInputFile.read(
                                    "D:/learnjavaworkspace/TheReplacements.txt").getBytes()));
            /*
             * you can also use in.available, but it works differently depending on what sort of medium
             * you're reading from With a file , this means the whole file, but with a different kind of
             * stream this might not be true, so use it thoughtfully
             */
            while (true)
                System.out.print((char) in.readByte());
        } catch (EOFException e) {
            // A really misuse of Exception for control  flow
            System.err.println("End of stream");
        }
    }
} /* (Execute to see output) *///:~
