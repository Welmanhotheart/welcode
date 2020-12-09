package exercise.initialization;

import java.util.Random;
//exercise12
public class TankFillEmpty {
    public static void main(String[] args) {
        Random r = new Random(2300);
        for(int i = 0; i < 1000000000; i++) {
            Tank t = new Tank();
            int i1 = r.nextInt();
            if ((i1 & 1) == 0) {
                t.empty();
            }
        }
//        System.gc();
    }
}

class Tank{
    private boolean isEmpty = false;
    public void fill() {
        isEmpty = false;
    }

    public void empty() {
        isEmpty = true;
    }

    @Override
    protected void finalize() throws Throwable {
        if(!isEmpty){
            System.out.println("I am not empty");
            return;
        }
        super.finalize();
    }
}