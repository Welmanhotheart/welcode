package exercise.initialization;

public class ClassWithFinalize {
    public static void main(String[] args) {
        new ClassHelperFinalize().say();
        System.gc();
    }
}


class ClassHelperFinalize{
    public void say() {
        System.out.println("exercise.initialization.ClassHelperFinalize");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("end with finanlize....");
    }
}