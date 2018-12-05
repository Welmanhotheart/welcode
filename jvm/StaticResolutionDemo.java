public class StaticResolutionDemo {

    public static final void sayHello() {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        StaticResolutionDemo.sayHello();
    }

    public  final void sayNo() {
        System.out.println("StaticResolutionDemo no");
    }
}

class StaticResolutionDemoSub extends StaticResolutionDemo {
    public final void sayNo1() {
        System.out.println("StaticResolutionDemoSub, no1");
    }

    public static void main(String[] args) {
        StaticResolutionDemo sub = new StaticResolutionDemoSub();
        sub.sayNo();
    }
}

