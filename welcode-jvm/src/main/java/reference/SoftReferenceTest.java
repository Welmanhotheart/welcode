package reference;

import java.lang.ref.SoftReference;

public class SoftReferenceTest {

    private static class BiggerObject{//占用空间的一个大对象
        public int[] values;
        public String name;
        public BiggerObject(String name){
            this.name=name;
            values=new int[1024 * 1024];
        }
    }

    public static void main(String[] args) {
        int count=20;//对象数量为100000，保证使得堆内存溢出
        SoftReference[] values=new SoftReference[count];
        for(int i=0;i<count;i++){
            values[i]=new SoftReference<BiggerObject>(new BiggerObject("Object-"+i));
        }
//        System.gc();//，如果内存不足，即使不进行垃圾回收也会发生内存溢出；如果内存充足，即使强制进行垃圾回收也不会回收对象
        System.out.println(((BiggerObject)(values[values.length-1].get())).name);
        for(int i=10;i<1;i++){
            System.out.println(((BiggerObject)(values[i].get())).name);
        }
    }
}

/**
 * //说明回收后，还是内存不够
 Object-999999

 //说明早期的对象已经被回收了
 Exception in thread "main" java.lang.NullPointerException
 at reference.SoftReferenceTest.main(SoftReferenceTest.java:24)
 */