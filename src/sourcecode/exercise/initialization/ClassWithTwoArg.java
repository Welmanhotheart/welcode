package exercise.initialization;

public class ClassWithTwoArg {
    public static void main(String[] args) {
        ClassCreateHelper[] arr = new ClassCreateHelper[21];
        for (int i = 0, len = arr.length; i < len; i++) {
            arr[i] = new ClassCreateHelper("a" + ('a' + i));
        }

    }

}

class  ClassCreateHelper {
    ClassCreateHelper(String name){
        System.out.println("I am " + name);

    }
}
