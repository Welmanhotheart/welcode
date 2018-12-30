package exercise.reusing;
//Exersize 20,21,22
public class ClassWithFinalMethods {
    public final void final_method1() {
        System.out.println("ClassWithFinalMethods, public final void final_method1");
    }
}


final class ClassWithFinalMethodsSub extends ClassWithFinalMethods {
    public void final_method() {//cant override the final method from super class

    }
}

class ClassWithFinalMethodsSubSub extends ClassWithFinalMethodsSub{//cant inherit from final class

}