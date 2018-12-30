package exercise.arrays;


import java.util.Arrays;

import net.mindview.util.CountingGenerator;
import net.mindview.util.ConvertTo;
import net.mindview.util.Generated;
import net.mindview.util.Generator;

class SkipGenerator<T> implements Generator<Object> {
    private Generator<T> gen;//Adapt design pattern
    private int increment;

    public SkipGenerator(Generator<T> gen, int increment) {
        this.gen = gen;
        this.increment = increment;
    }


    public T next() {
        if (this.increment == 1) return gen.next();
        for (int i = 0; i < this.increment - 1; i++) {
            gen.next();
        }
        return gen.next();
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T> Generator<T> getSkipGenerator(Generator<T> gen, int increment) {
        return (Generator<T>) (new SkipGenerator(gen, increment));
    }
}


public class Exercise16 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(ConvertTo.primitive(Generated.array(Double.class, SkipGenerator.getSkipGenerator(new CountingGenerator.Double(), 2), 6))));
    }
}
