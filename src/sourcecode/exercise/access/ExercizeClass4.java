package exercise.access;

import exercise.access.Exercizep_package_4.ClassWithProtectedMethod;

public class ExercizeClass4 {
    public static void main(String[] args) {
        ClassWithProtectedMethod classWithProtectedMethod = new ClassWithProtectedMethod();
        classWithProtectedMethod.methodProtected();//Compile error, method should be public,only has protected access
        classWithProtectedMethod.methodPublic();
        classWithProtectedMethod.methodPrivate();// Compile error, method should be public,only has private access

    }
}
