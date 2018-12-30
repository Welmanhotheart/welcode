package exercise.arrays;


import net.mindview.util.Generated;
import net.mindview.util.Generator;

import java.math.BigDecimal;
import java.util.Arrays;

class BigDecimalGenerator implements Generator<BigDecimal> {

    public BigDecimal next() {
        return new BigDecimal(12);
    }
}


public class Exercise17 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Generated.array(BigDecimal.class, new BigDecimalGenerator(), 6)));
    }
}

        /*
         * Actually,I dont think this exercise is so easy
         */
