package exercise.concurrency;

import java.util.ArrayList;

public class TestCurrentModificationMaker {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>(8);
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

//        for (String s : list) {
//            System.out.println(s);  //Exception in thread "main" java.util.ConcurrentModificationException
//            list.add("ddd");
//        }

//        for (int i = 0, len = list.size(); i < len; i++) {
//            System.out.println(list.get(i)); // no exception
//            list.add("ddd");
//        }

//        Iterator<String> itr = list.iterator();
//        while (itr.hasNext()) {
//            String next = itr.next(); // Exception in thread "main" java.util.ConcurrentModificationException
//            System.out.println(next);
//            list.add("ddd");
//            System.out.println("list size=" + list.size());
//        }

    }
}
