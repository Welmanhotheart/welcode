//: polymorphism/PrivateOverride.java
// Trying to override a private method.
package testcase.polymorphism;

import static sourcecode.net.mindview.util.Print.*;

public class PrivateOverride {
    private void f() {
        print("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();//如果是基类可以访问的，优先访问积累的函数（从更加私有的层面）
    }
}

class Derived extends PrivateOverride {
    public void f() {
        print("public f()");
    }
} /* Output:
private f()



*///:~
