package exercise.generics;

import testcase.typeinfo.pets.*;

class Generic1<T> {
    public void setT(T element2) {
        System.out.println("Generic1 setT");
    }

}

class Generic2<T> {
    private T element;

    public T getElement() {
        return element;
    }
}

public class Exercise28 {
    public static <T> void f1(Generic1<? super T> generic1, T element) {
        generic1.setT(element);
    }

    public static <T> void f2(Generic2<? extends T> generic2) {
        T element = generic2.getElement();
    }

    public static void main(String[] args) {
        f1(new Generic1<Individual>(), new Individual("sdjk"));
        f1(new Generic1<Individual>(), new Person("sdjk"));
        f1(new Generic1<Individual>(), new Cat("sdjk"));
//		f1(new Generic1<Person>(), new Individual("sdjk")); wont compile
//		f1(new Generic1<Cat>(), new Individual("sdjk")); wont compile
        f2(new Generic2<Individual>());
        f2(new Generic2<Person>());
        f2(new Generic2<Cat>());

        String str = "ads";
        String str1 = "ad" + 's';
        String str2 = "ad" + "s";
        String a = "a";
        String s = "s";
        String str3 = a + "ds";
        String str4 = "ad" + s;
        char ch = str4.charAt(0);
        System.out.println(str == str1);
        System.out.println(str == str2);
        System.out.println(str == str3);
        System.out.println(str == str4);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1 == str4);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(str2 == str3);
        System.out.println(str2 == str4);


        System.out.println();
        System.out.println();
        System.out.println(str3 == str4);

    }
}
