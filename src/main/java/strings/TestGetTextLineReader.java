//package strings;
//
//import net.mindview.util.Print;
//import util.io.TextFileLineReader;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestGetTextLineReader {
//    public static void main(String[] args) {
//        List<String> stringList = null;
//        try {
//            stringList = TextFileLineReader.readLines("E:\\Class.txt", "^\\s+public+\\S+.*",
//                    new ArrayList<String>(200));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        for (String s : stringList) {
//            System.out.println(s);
//        }
//    }
//}
