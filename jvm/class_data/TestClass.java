package class_data;

import util.MethodTestClass;

public class TestClass extends MethodTestClass{
    private int m;
    private static final String const_var = "dasfsfs";

    public static int inc_1() {return 1;}
    public int inc(){
        return m+1;
    }
}
