package dynamic;

import dynamic.impl.InterfaceClassImpl;
import dynamic.impl.InterfaceClassImpl2;

public class TestDynamicCall {

    private int field1;

    public static void main(String[] args) {
        InterfaceClass interfaceClass = getInterfaceInstance(1);
//        int sum = interfaceClass.add(3,4);
        int c, d, e, f;
        c = 1;
        d = 2;
        e = c + d;
        f = c + e;
        int sum = doAdd(interfaceClass, 3, 4);
        System.out.println("sum=" + sum);
        TestDynamicCall call = new TestDynamicCall();
//        call.field1 = 3;
    }

    public static InterfaceClass getInterfaceInstance(int i) {
        if (i ==1) {
            return new InterfaceClassImpl();
        } else {
            return new InterfaceClassImpl2();
        }
    }
    public static int doAdd(InterfaceClass interfaceClass, int a, int b) {
        return interfaceClass.add(a, b);

    }
}
