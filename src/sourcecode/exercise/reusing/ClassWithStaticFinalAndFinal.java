package exercise.reusing;
// Exersie18,19
public class ClassWithStaticFinalAndFinal {
    public static final String static_final_member;//声明时，必须赋值，或者再静态快里面复制,与类有关,这个是由编译器强制保证的
    static{
        try {
            static_method();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {

        }
        static_final_member = "static_final_member";
    }
    public void say() {
        System.out.println("static_final_member" + static_final_member);
        System.out.println("final_member" + final_member);
    }
    public final String final_member; //必须当即创建类的实例时，当即创建，且不能被修改，与实例有关,这个是由编译器强制保证的
    {
//        static_final_member = "static_final_member";
//        final_member = "final_member";
    }

    public static void static_method() throws Exception{

    }
    public ClassWithStaticFinalAndFinal(int a) {
        System.out.println("safsafd");
        final_member = "final_member";
    }
    public ClassWithStaticFinalAndFinal() {
        this(5);
//        final_member = "final_member";
    }
}
