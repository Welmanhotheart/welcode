package exercise.concurrency;

import static net.mindview.util.Print.*;

import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnWriteArrayList {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Object> list = new CopyOnWriteArrayList<Object>();
        Object o = new Object();
        list.add(o);
        System.out.println(o);

        o = new Object();
        list.add(o);
        System.out.println(o);

        o = new Object();
        list.add(o);
        System.out.println(o);



        print("==============  use for loop to traverse and meanwhile remove=============");

        Exception exception = null;
        try {
            for(int i = 0, len = list.size(); i < len; i++) {
                Object o1 = list.get(i);
                System.out.println(o1);
                list.remove(0);
            }
        } catch (Exception e) {
            exception = e;
        }

        if(exception != null) {
            StackTraceElement[] stackTrace = exception.getStackTrace();
            for (int  len = stackTrace.length,i = len - 1; i>= 0; i--) {
                System.out.println(stackTrace[i].toString());
            }
        }


        print("============== iteratively traverse and remove=============");
        for (Object o1 : list) {
            System.out.println(o1);
            list.remove(0);
        }

        print();
        print("==============iteratively traverse traverse=============");
        for (Object o1 : list) {
            System.out.println(o1);
//            list.remove(0);
        }
    }
}
