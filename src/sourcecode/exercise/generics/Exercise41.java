package exercise.generics;

import testcase.generics.SimpleQueue;
import testcase.generics.coffee.*;

import java.util.*;

import testcase.net.mindview.util.*;

import static testcase.net.mindview.util.Print.*;

import testcase.typeinfo.pets.*;

public class Exercise41 {
    public static void main(String[] args) {
        // Adapt a Collection:
        List<Pet> pets = new ArrayList<Pet>();
        Fill2.fill(new AddableCollectionAdapter<Pet>(pets), Cat.class, 3);
        // Helper method captures the type:
        Fill2.fill(Adapter.collectionAdapter(pets), Manx.class, 2);
        for (Pet c : pets)
            print(c);
        print("----------------------");
        // Use an adapted class:
        AddableSimpleQueue<Coffee> coffeeQueue = new AddableSimpleQueue<Coffee>();
        Fill2.fill(coffeeQueue, Mocha.class, 4);
        Fill2.fill(coffeeQueue, Latte.class, 1);
        for (Coffee c : coffeeQueue)
            print(c);
    }
}

interface Addable<T> {
    void add(T t);
}

class Fill2 {
    // Classtoken version:
    public static <T> void fill(Addable<T> addable,
                                Class<? extends T> classToken, int size) {
        for (int i = 0; i < size; i++)
            try {
                addable.add(classToken.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    // Generator version:
    public static <T> void fill(Addable<T> addable, Generator<T> generator,
                                int size) {
        for (int i = 0; i < size; i++)
            addable.add(generator.next());
    }
}

// To adapt a base type, you must use composition.
// Make any Collection Addable using composition:
class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> c;

    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }

    public void add(T item) {
        c.add(item);
    }
}

// A Helper to capture the type automatically:
class Adapter {
    public static <T> Addable<T> collectionAdapter(Collection<T> c) {
        return new AddableCollectionAdapter<T>(c);
    }
}

// To adapt a specific type, you can use inheritance.
// Make a SimpleQueue Addable using inheritance:
class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    public void add(T item) {
        super.add(item);
    }
}

