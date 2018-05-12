package exercise.arrays;

import exercise.arrays.BerylliumSphere;


class Banana {
}

class Peel<T> {
}


public class Exercise9 {
    public static void main(String[] args) {
//		Peel<Banana>[] plb = new Peel<Banana>[10]; compile error:Cannot create a generic array of Peel<Banana>
        @SuppressWarnings("unchecked")
        Peel<Banana>[] plb = new Peel[10];

    }
}
