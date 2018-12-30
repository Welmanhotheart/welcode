package exercise.object;
//exercise9
public class AutoBoxing {
    public static void main(String[] args) {
        /**
         * It will call the following code statements:
         * public static Integer valueOf(int i) {
             if(i >= -128 && i <= IntegerCache.high)
                return IntegerCache.cache[i + 128];
             else
                return new Integer(i);
          }
         it means autoboxing
         */
        Integer wrapper = 7;
        System.out.println(wrapper);
    }
}
