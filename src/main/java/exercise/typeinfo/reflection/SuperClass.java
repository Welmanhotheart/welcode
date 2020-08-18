package exercise.typeinfo.reflection;

public class SuperClass<String>  extends HigherClass implements SuperInterFace {
    private SubClass subClass;
    private String superId;
    protected int superPubField;
    private static int superStaticPrivateCounterer;
    public static int superStaticPublicCounterer;

    public SuperClass() {

    }

    public String getSuperId() {
        return superId;
    }



    public static int getSuperStaticPrivateCounterer() {
        return superStaticPrivateCounterer;
    }


    private void superPrivateMethod() {

    }

    private static void superPrivateStaticMethod() {

    }


}
