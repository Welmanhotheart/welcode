package exercise.io;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import testcase.net.mindview.util.BinaryFile;
import testcase.net.mindview.util.TextFile;


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
