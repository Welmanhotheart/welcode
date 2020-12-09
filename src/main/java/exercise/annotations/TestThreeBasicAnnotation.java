package exercise.annotations;

public class TestThreeBasicAnnotation {
    public static void main(String[] args) {
        AnnotationBaseClass baseClass = new AnnotationBaseClass();
        baseClass.add(2,3);
    }
}



class AnnotationBaseClass{
    public void f() {
        System.out.println("base class f()");
    }

//    @Deprecated
    public int add(int a, int b) {
        return a + b;
    }
}


class AnnotationSubClass extends AnnotationBaseClass{
    
//    @Override
//    public void f(int a, int b) {
//        System.out.println("base class f()");
//    }
//
//    @Override
//    public void f1() {
//        System.out.println("base class f()");
//    }

    @Override
    public void f() {
    }
}
