package exercise.reusing;
//Exercise16
public class ClassCastToSuper {
    public void say() {
        System.out.println("I am super class ClassCastToSuper ");
    }
}


class ClassCastToSuperSub extends ClassCastToSuper {

}


class testClassCastToSuperSub {
    public static void main(String[] args) {
        ClassCastToSuperSub sub = new ClassCastToSuperSub();
        ((ClassCastToSuper)sub).say();
    }
}