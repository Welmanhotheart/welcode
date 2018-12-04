package dynamic;

import dynamic.impl.InterfaceClassImpl;

public class TestDynamicCall {

    private int field1;
    public static void main(String[] args) {
        InterfaceClass interfaceClass = new InterfaceClassImpl();
//        int sum = interfaceClass.add(3,4);
        int c,d,e,f;
        c = 1;
        d = 2;
        e = c+d;
        f = c + e;
        doAdd(interfaceClass, 3,4);
        TestDynamicCall call = new TestDynamicCall( );
//        call.field1 = 3;
    }

    public static int doAdd(InterfaceClass interfaceClass, int a, int b) {
        return interfaceClass.add(a, b);

    }
}
