package exercise.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;


public class Exercise12 {
	public static LinkedList<String>
	read(String filename) throws IOException {
		// Reading input by lines:
		BufferedReader in = new BufferedReader(
				new FileReader(filename));
		String s;
		LinkedList<String> lst = new LinkedList<String>();
		while((s = in.readLine())!= null)
			lst.add(s + '\n');
		in.close();
		return lst;
	}
	public static void main(String[] args) throws IOException {
		LinkedList<String> lst = read("D:/learnjavaworkspace/TheReplacements.txt");
//		"D:/learnjavaworkspace/TheReplacements.txt"
		/*
		 * descendingIterator:Returns an iterator over the elements in this deque in reverse sequential order. 
		 * The elements will be returned in order from last (tail) to first (head).
		 */
		PrintWriter pw = new PrintWriter("D:/learnjavaworkspace/TheReplacements.out");
		Iterator<String> itr = lst.iterator();
		int i = 0;
		while(itr.hasNext()) {
			pw.println((++i) + ". " + itr.next());
		}
		pw.close();
	}
}
