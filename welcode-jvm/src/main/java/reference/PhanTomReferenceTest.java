package reference;


import java.lang.ref.PhantomReference;

public class PhanTomReferenceTest {
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
        PhantomReference[] values=new PhantomReference[count];
        for(int i=0;i<count;i++){
            values[i]=new PhantomReference<BiggerObject>(new BiggerObject("Object-"+i), null);
        }

        System.out.println(((BiggerObject)(values[values.length-1].get())).name);
        for(int i=0;i<10;i++){
            System.out.println(((BiggerObject)(values[i].get())).name);
        }
    }
}
