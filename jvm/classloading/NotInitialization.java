package classloading;


/**
 * 非主动使用类字段演示
 **/
public class NotInitialization {
    public static void main(String[] args) {
//        System.out.println(SubClass.value);
//        SuperClass[] sca = new SuperClass[10];
//        sca.length;
//        sca.clone();

        System.out.println(ConstClass.HELLOWORLD);

    }
}

/**
 * 1.
 * System.out.println(SubClass.value);
 * output:
 *  SuperClass init！
 *  123
 * 加上-XX:+TraceClassLoading参数后，发现结果加载过程如下
 * .....
 * [Loaded classloading.SuperClass from file:/S:/Eclipse_space/welcode/target/classes/]
 * [Loaded classloading.SubClass from file:/S:/Eclipse_space/welcode/target/classes/]
 * .....
 *
 * SuperClass init！
 * 123
 *
 */

/*
 * 2.
 * SuperClass[] sca = new SuperClass[10];
 * 没有输出任何东西，执行Javap命令，出现如下：
 *
 * .............
 *
 *  LocalVariableTable:
   Start  Length  Slot  Name   Signature
          0       7     0  args   [Ljava/lang/String;
          6       1     1   sca   [Lclassloading/SuperClass;
 **/


/**
 * 3.
 * System.out.println(ConstClass.HELLOWORLD);
 *  output:
 *  hello world
 *
 *  没有任何类加载的过程
 *
 *  通过javap命令，居然看不到任何与ConstClass有关的信息 ！！！
 *
 *
 */