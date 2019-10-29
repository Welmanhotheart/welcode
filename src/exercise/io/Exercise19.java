package exercise.io;

import net.mindview.util.BinaryFile;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;


public class Exercise19 {
    static String file = "rtest123.dat";

    public static void main(String[] args) throws IOException {
        Map<Byte, Integer> countMap = new TreeMap<Byte, Integer>();
        byte[] bys = BinaryFile.read("src/testcase/net/mindview/util/TextFile.java");
        for (int j = 0, jlen = bys.length; j < jlen; j++) {
            byte bt = bys[j];
            Integer count = countMap.get(bt);
            if (null == count) {
                countMap.put(bt, 1);
            } else {
                countMap.put(bt, ++count);
            }
        }
        System.out.println(countMap);
    }
}
