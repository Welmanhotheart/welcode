package exercise.reusing;
//Exercise 13
public class ClassWithOverLoadingMethods {
    public void method1(String arg1,int arg2) {}
    public void method1(int arg1,int arg2) {}
    public void method1(int  arg1,String arg2) {}
}

class ClassWithOverLoadingMethodsSub extends ClassWithOverLoadingMethods{
    public void method1(String arg1,int arg2) {
        method1(12,34);
        method1(12,"34");
    }
}
