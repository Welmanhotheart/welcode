package exercise.operators;

public class DisplayLM {
    public static void main(String[] args) {
        float minValue = Float.MIN_VALUE;
        float maxValue = Float.MAX_VALUE;
        System.out.println("minValue:" + Float.floatToRawIntBits(minValue));
        System.out.println("maxValue:" + Float.floatToRawIntBits(maxValue));
        System.out.println();
    }
}
