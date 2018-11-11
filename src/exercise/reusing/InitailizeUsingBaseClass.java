package exercise.reusing;
//Exercise 3,4,5,7,8
public class InitailizeUsingBaseClass {
    public static void main(String[] args) {
        new HelperClassSub(7);
    }
}


class HelperClassSuper{
    {
        System.out.println("intantialize...");
    }
    public HelperClassSuper(String i) {
        System.out.println("HelperClassSuper  constructor:" + i);
    }
}

class HelperClassSub extends HelperClassSuper{
    public HelperClassSub(int i) {
        super("dfgd" + i);
        System.out.println("HelperClasdsddsSub(int i):" + i);
    }
//    public HelperClassSub() {
//        super(5 + "");
//        System.out.println("default constructor.....");
//    }
}

class HelperClassSubSub extends HelperClassSub{
    public HelperClassSubSub() {
        super(67787);

    }
}
