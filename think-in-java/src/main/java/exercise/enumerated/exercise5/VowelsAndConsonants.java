package exercise.enumerated.exercise5;//: control/VowelsAndConsonants.java
// Demonstrates the switch statement.

import net.mindview.util.Enums;

public enum  VowelsAndConsonants {
    VOWEL(VowelsAndConsonants.Alphabet.VOWEL.class),
    SOMETIMES_A_VOWEL(VowelsAndConsonants.Alphabet.SOMETIMES_A_VOWEL.class),
    CONSONANT(VowelsAndConsonants.Alphabet.CONSONANT.class);
    private Alphabet values[];

    VowelsAndConsonants(Class<? extends Alphabet> cls) {
        values = cls.getEnumConstants();
    }

    char randomSelection() {
        Alphabet random = Enums.random(values);
        return random.randomSelection();
    }

    interface Alphabet {
        String toString();

        char randomSelection();

        enum VOWEL implements Alphabet {
            INSTANCE('a','e', 'i', 'o', 'u');

            @Override
            public char randomSelection() {
                return Enums.random(values);
            }

            Character[] values;
            VOWEL(Character...chars) {
                values = chars;
            }


        }

        enum SOMETIMES_A_VOWEL implements Alphabet {
            INSTANCE('y', 'w');

            Character[] values;

            SOMETIMES_A_VOWEL(Character...chars) {
                values = chars;
            }
            @Override
            public char randomSelection() {
                return Enums.random(values);
            }

        }

        enum CONSONANT implements Alphabet {
            INSTANCE('b', 'c', 'd', 'f', 'g', 'h', 'i');
            Character[] values;
            @Override
            public char randomSelection() {
                return Enums.random(values);
            }

            CONSONANT(Character...chars) {
                values = chars;
            }
        }



    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            VowelsAndConsonants e = Enums.random(VowelsAndConsonants.class);
            char alphabet = e.randomSelection();
            System.out.println(e + ":" + alphabet);
        }
    }
}
