package exercise.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import testcase.io.BufferedInputFile;

public class Exercise14 {
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
        int time = 1000000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            testBufferWriter();
        }
        System.out.println("buffer writer time consuming: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            testUnBufferWriter();
        }
        System.out.println("unbuffer writer time consuming: " + (System.currentTimeMillis() - start));
    }
}
/**
 * output following:
 * buffer writer time consuming: 195412
 * unbuffer writer time consuming: 199756
 * I didn't see any difference between buffered and unbuffered
 */
