package exercise.initialization;

public class CreateStringArray {
    public static void main(String[] args) {
        String[] arr = new String[34];
        for (int i = 0, len = arr.length; i < len; i++) {
            arr[i] = "a" + ('a' + i);
        }
        for (String s : arr) {
            System.out.println(s);

        }
    }
}
