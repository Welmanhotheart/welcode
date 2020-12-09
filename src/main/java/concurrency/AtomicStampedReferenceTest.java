package concurrency;


import java.util.concurrent.atomic.AtomicStampedReference;

/**
 *
 */
public class AtomicStampedReferenceTest {
    public static void main(String[] args) {
        AtomicStampedReference<Integer> reference = new AtomicStampedReference<Integer>(4,1);
        new Thread();
    }
}
