package bit;

public class BitTest {
    public static void main(String[] args) {
        int a = -37;
        int _a = -a;
        int b = 45;
        int c = 0b10000000000000000000000000000000;
        System.out.println("c:" + c);
        System.out.println("a:" + a + " " + Integer.toBinaryString(a));
        System.out.println("-a:" + _a + " " + Integer.toBinaryString(_a));
        System.out.println("b:" + b + " " + Integer.toBinaryString(b));
        System.out.println("a^b:" + (a^b) + " " + Integer.toBinaryString(a^b));
        System.out.println("a|b:" + (a|b) + " " + Integer.toBinaryString(a|b));


        System.out.println("===========================!a========================");
        System.out.println("a:" + a + " " + Integer.toBinaryString(a));
        System.out.println("~a:" + (~a) + " " + Integer.toBinaryString(~a));
        System.out.println("===========================!a end========================");
        System.out.println();
        System.out.println("===========================a>>========================");
        System.out.println("a:" + a + " " + Integer.toBinaryString(a));
        System.out.println("a>>1:" + (a>>1) + " " + Integer.toBinaryString(a>>1));
        System.out.println("a>>2:" + (a>>2) + " " + Integer.toBinaryString(a>>2));
        System.out.println("a>>3:" + (a>>3) + " " + Integer.toBinaryString(a>>3));
        System.out.println("===========================a>> end========================");
        System.out.println();
        System.out.println("===========================a>>>========================");
        System.out.println("a:" + a + " " + Integer.toBinaryString(a));
        System.out.println("a>>>1:" + (a>>>1) + " " + Integer.toBinaryString(a>>>1));
        System.out.println("a>>>2:" + (a>>>2) + " " + Integer.toBinaryString(a>>>2));
        System.out.println("a>>>3:" + (a>>>3) + " " + Integer.toBinaryString(a>>>3));
        System.out.println("a>>>4:" + (a>>>4) + " " + Integer.toBinaryString(a>>>4));
        System.out.println("a>>>5:" + (a>>>5) + " " + Integer.toBinaryString(a>>>5));
        System.out.println("a>>>6:" + (a>>>6) + " " + Integer.toBinaryString(a>>>6));
        System.out.println("a>>>7:" + (a>>>7) + " " + Integer.toBinaryString(a>>>7));
        System.out.println("===========================a>>>========================");

    }
}
