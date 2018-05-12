package testcase.containers;

//: containers/Unsupported.java
// Unsupported operations in Java containers.

import java.util.*;

public class Unsupported {
    static void test(String msg, List<String> list) {
        System.out.println("--- " + msg + " ---");
        Collection<String> c = list;
        Collection<String> subList = list.subList(1, 8);
        // Copy of the sublist:
        Collection<String> c2 = new ArrayList<String>(subList);
        try {
            c.retainAll(c2);
        } catch (Exception e) {
            System.out.println("retainAll(): " + e);
            e.printStackTrace();
        }
        try {
            c.removeAll(c2);
        } catch (Exception e) {
            System.out.println("removeAll(): " + e);
            e.printStackTrace();
        }
        try {
            c.clear();
        } catch (Exception e) {
            System.out.println("clear(): " + e);
            e.printStackTrace();
        }
        try {
            c.add("X");
        } catch (Exception e) {
            System.out.println("add(): " + e);
            e.printStackTrace();
        }
        try {
            c.addAll(c2);
        } catch (Exception e) {
            System.out.println("addAll(): " + e);
            e.printStackTrace();
        }
        try {
            c.remove("C");
        } catch (Exception e) {
            System.out.println("remove(): " + e);
            e.printStackTrace();
        }
        // The List.set() method modifies the value but
        // doesn't change the size of the data structure:
        try {
            list.set(0, "X");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("List.set(): " + e);
        }
    }

    public static void main(String[] args) {
        List<String> list =
                Arrays.asList("A B C D E F G H I J K L".split(" "));
        test("Modifiable Copy", new ArrayList<String>(list));
        test("Arrays.asList()", list);
        test("unmodifiableList()",
                Collections.unmodifiableList(
                        new ArrayList<String>(list)));
    }
} /* Output:
--- Modifiable Copy ---
--- Arrays.asList() ---
retainAll(): java.lang.UnsupportedOperationException
removeAll(): java.lang.UnsupportedOperationException
clear(): java.lang.UnsupportedOperationException
add(): java.lang.UnsupportedOperationException
addAll(): java.lang.UnsupportedOperationException
remove(): java.lang.UnsupportedOperationException
--- unmodifiableList() ---
retainAll(): java.lang.UnsupportedOperationException
removeAll(): java.lang.UnsupportedOperationException
clear(): java.lang.UnsupportedOperationException
add(): java.lang.UnsupportedOperationException
addAll(): java.lang.UnsupportedOperationException
remove(): java.lang.UnsupportedOperationException
List.set(): java.lang.UnsupportedOperationException
*///:~

/**
 * as for the list created by calling 'Arrays.asList()'
 * when passed a list that is created by calling 'Arrays.asList()', which returns an arrayList,
 * its primary implementation is Arrays$ArrayList, this class extends AbstractList when calling
 * 'remove()' it throw UnsupportedOperationException, and its the same when calling 'add()'
 */
