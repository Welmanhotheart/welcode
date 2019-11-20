package reference;

import java.util.WeakHashMap;

public class WeakHashMapTest {
    public static void main(String[] args) {
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer i = new Integer(2);
        String a = "weakHashMap";
        map.put(i,a);
        i = null;//这里当i没有被置为null时，换言之，map的key还有被引用时，map里面的东西不会被回收；
        // 而当map里面的key不在被使用时，map里面的东西会被GC回收掉

        System.gc();
        System.out.println(map);
    }
}
