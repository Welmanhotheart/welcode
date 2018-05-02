package exercise.io;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import testcase.net.mindview.util.TextFile;


public class Exercise17 {
	static String file = "rtest123.dat";
	public static void main(String[] args) {
		Map<Character, Integer> countMap = new TreeMap<Character, Integer>();
		TextFile words = new TextFile("src/testcase/net/mindview/util/TextFile.java", "\\W+");
		for (int i = 0, len =  words.size(); i < len; i++) {
			String word = words.get(i);
			for (int j = 0, jlen = word.length(); j < jlen; j++) {
				char Char = word.charAt(j);
				Integer count = countMap.get(Char);
				if (null == count) {
					countMap.put(Char, 1);
				} else {
					countMap.put(Char, ++count);
				}
			}
		}
		System.out.println(countMap);
  }
}
