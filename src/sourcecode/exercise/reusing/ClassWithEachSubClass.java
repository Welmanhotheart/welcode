package exercise.reusing;

public class ClassWithEachSubClass {
    private Component1 component1 = new Component1();
    private Component2 component2 = new Component2();
    private Component3 component3 = new Component3();
    {
        System.out.println("static ..component1 = new Component1();");
        component1 = new Component1();
        System.out.println("static ..component2 = new Component2();");
        component2 = new Component2();
        System.out.println("static ..component3 = new Component3();");
        component3 = new Component3();
    }
}

class Component1 {
    public Component1(){
        System.out.println("Component1 default contructor");
    }
}
class Component2 {
    public Component2(){
        System.out.println("Component2 default contructor");
    }
}
class Component3 {
    public Component3(){
        System.out.println("Component3 default contructor");
    }
}

class ClassWithEachSubClassSub extends ClassWithEachSubClass{
    private Component1 component1 = new Component1();
    private Component2 component2 = new Component2();
    private Component3 component3 = new Component3();
}


class ClassWithEachSubClassTest{
    public static void main(String[] args) {
        new ClassWithEachSubClassSub();
    }
}

