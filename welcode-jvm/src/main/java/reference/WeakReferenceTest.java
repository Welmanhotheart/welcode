package reference;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {
    private static class BiggerObject{//占用空间的一个大对象
        public int[] values;
        public String name;
        public BiggerObject(String name){
            this.name=name;
            values=new int[1024];
        }
    }
    public static void main(String[] args) {
        int count=100;//对象数量改为100，保证堆内存不会溢出
        WeakReference[] values=new WeakReference[count];
        for(int i=0;i<count;i++){
            values[i]=new WeakReference<BiggerObject>(new BiggerObject("Object-"+i));
        }
        System.gc();//即使内存充足时，当执行垃圾回收，对象也会被全部回收
        System.out.println(((BiggerObject)(values[values.length-1].get())).name);
        for(int i=0;i<10;i++){
            System.out.println(((BiggerObject)(values[i].get())).name);
        }
    }
}
