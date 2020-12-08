package exercise.access.Exercizep_package_4;
//exercise 4,5,6
public class ClassWithProtectedMethod {
    protected String data;
    {
        data = "asfsadfsadfsadfsdfsad";
    }
    protected void methodProtected() {

    }

    private void methodPrivate() {

    }

    public void methodPublic() {

    }
}

class ClassManipulateClass{
    public static void main(String[] args) {
        ClassWithProtectedMethod o = new ClassWithProtectedMethod();
        System.out.println(o.data.length());
    }
}
