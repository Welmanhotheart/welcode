package exercise.generics;

//: innerclasses/Sequence.java
//Holds a sequence of Objects.

interface Selector<T> {
    boolean end();

    T current();

    void next();
}

class Sequence<T> {
    private Object[] items;
    private int next = 0;

    @SuppressWarnings("unchecked")
    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(T x) {
        if (next < items.length)
            items[next++] = x;
    }

    private class SequenceSelector<T> implements Selector<T> {
        private int i = 0;

        public boolean end() {
            return i == items.length;
        }

        @SuppressWarnings("unchecked")
        public T current() {
            return (T) items[i];
        }

        public void next() {
            if (i < items.length) i++;
        }
    }

    public Selector<T> selector() {
        return new SequenceSelector<T>();
    }

    public static void main(String[] args) {
        Sequence<String> sequence = new Sequence<String>(10);
        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Selector<String> selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
} /* Output:
0 1 2 3 4 5 6 7 8 9
*///:~

public class Exercise4 {
    public static void main(String[] args) {
        /**
         * It's wrong with parameter
         */
//		Sequence<String>.main(null);

        Sequence.main(null);
    }
}
