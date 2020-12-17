package effective.item_11;

public class TestArrayClone {
    public static void main(String[] args) {
        int length = 23;
        TestReflectionClone [] arr = new TestReflectionClone[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new TestReflectionClone();
        }

        TestReflectionClone[] clone = arr.clone();
        System.out.println(clone.length);
    }
}

/**
 * Through debugging, we see the cloned arr holds the same size and
 * the same elements (reference to the object) as the original arr
 * */