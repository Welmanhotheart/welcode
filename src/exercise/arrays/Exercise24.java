package exercise.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;


class Exer24 implements Comparable<Exer24> {
    private int filed;

    public Exer24(int field) {
        this.filed = field;
    }

    public int getField() {
        return this.filed;
    }

    @Override
    public boolean equals(Object obj) {
        if (null != obj && obj instanceof Exer24) {
            return this.filed == ((Exer24) obj).filed;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getField());
    }

    @Override
    public int compareTo(Exer24 o2) {
        Exer24 o1 = this;
        if (o1 == o2) return 0;
        if (null == o1) return -1;
        int field1 = o1.getField();
        int field2 = o2.getField();
        return field1 == field2 ? 0 : (field1 > field2 ? 1 : -1);
    }
}

class ComparatorE24 implements Comparator<Exer24> {

    @Override
    public int compare(Exer24 o1, Exer24 o2) {
        if (o1 == o2) return 0;
        if (null == o1) return -1;
        int field1 = o1.getField();
        int field2 = o2.getField();
        return field1 == field2 ? 0 : (field1 > field2 ? 1 : -1);
    }

}

public class Exercise24 {
    public static void main(String[] args) {
        Random r = new Random();
        Exer24[] arr1 = new Exer24[12];
        for (int i = 0, len = arr1.length; i < len; i++) {
            arr1[i] = new Exer24(r.nextInt(len));
        }
        ComparatorE24 comparatorE24 = new ComparatorE24();
        System.out.println("before sorting:" + Arrays.toString(arr1));
        Arrays.sort(arr1, comparatorE24);
        System.out.println("after sorting:" + Arrays.toString(arr1));

        Exer24 target = new Exer24(r.nextInt(arr1.length));
        System.out.println("find " + target + " in place:" + Arrays.binarySearch(arr1, target, comparatorE24));
        System.out.println("find " + target + " in place:" + Arrays.binarySearch(arr1, target, null));
    }
}

/**
 * ~~output:
 * before sorting:[6, 9, 0, 2, 4, 9, 3, 11, 9, 4, 5, 1]
 * after sorting:[0, 1, 2, 3, 4, 4, 5, 6, 9, 9, 9, 11]
 * find 9 in place:8
 * find 9 in place:8
 */
