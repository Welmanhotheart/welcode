package exercise.typeinfo.reflection;


import annotations.database.SQLChar;

import javax.annotation.Resource;

@Resource
public class SubClass extends SuperClass {
    @SQLChar
    public int pubSub;
    private int subId;
    private static int subPriStaticCounter;
    public  static int subPubStaticCounter;

    public SubClass() {}
    private  SubClass(int i) {}
    public  SubClass(int i,int a) {}

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public static int getSubPubStaticCounter() {
        return subPubStaticCounter;
    }



    private static void subPrivateStaticMethod() {

    }
}
