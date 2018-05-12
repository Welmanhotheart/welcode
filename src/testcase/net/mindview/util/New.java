//: net/mindview/util/New.java
// Utilities to simplify generic container creation
// by using type argument inference.
package testcase.net.mindview.util;

import java.util.*;

import testcase.typeinfo.pets.Person;
import testcase.typeinfo.pets.Pet;

public class New {
    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }

    public static <T> List<T> list() {
        return new ArrayList<T>();
    }

    public static <T> LinkedList<T> lList() {
        return new LinkedList<T>();
    }

    public static <T> Set<T> set() {
        return new HashSet<T>();
    }

    public static <T> Queue<T> queue() {
        return new LinkedList<T>();
    }

    // Examples:
    public static void main(String[] args) {
        /**
         * can be applied to the MapOfList.java
         */
        //Map<Person, List<? extends Pet>>  petPeople = New.map();
        Map<String, List<String>> sls = New.map();
        List<String> ls = New.list();
        LinkedList<String> lls = New.lList();
        Set<String> ss = New.set();
        Queue<String> qs = New.queue();
    }
} ///:~
