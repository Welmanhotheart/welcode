package exercise.arrays;

import java.util.Arrays;
import java.util.Random;


public class Exercise22 {
    public static void main(String[] args) {
        Random r = new Random();
        Exer19[] arr1 = new Exer19[12];
        for (int i = 0, len = arr1.length; i < len; i++) {
            arr1[i] = new Exer19(r.nextInt(len));
        }
        int[] a = {2, 1, 2, 3, 7, 5, 6, 100, 37, 36, 31, 27, 23, 21};
        System.out.println(Arrays.binarySearch(a, 37));
    }
}
        /*
         * output:
         * -15, actually amazing, and unpredictable
         */
