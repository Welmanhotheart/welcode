package exercise.reusing;

import testcase.reusing.Detergent;
//exercise2
public class DetergentSub extends Detergent {
    @Override
    public void scrub() {
        System.out.println("DetergentSub.sub");
    }

    public void sterilize() {
        System.out.println("DetergentSub.sterilize");
    }
}
