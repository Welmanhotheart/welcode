package class_data;

public class Try_catch_demo {
    //Java源码
    public int inc(){
        int x;
        try{
            x=1;
            return x;
        }catch(Exception e){
            x=2;
            return x;
        }finally{
            x=3;
        }}

    public static void main(String[] args) {
        Try_catch_demo try_catch_demo = new Try_catch_demo();
        int x = try_catch_demo.inc();
        System.out.println(x);
    }
}
