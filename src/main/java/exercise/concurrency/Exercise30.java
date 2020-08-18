package exercise.concurrency;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.*;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

public class Exercise30 {
}



class SenderEx30 implements Runnable {
    private Random rand = new Random(47);
    private BlockingQueue<Character> out = new LinkedBlockingQueue<Character>();

    public BlockingQueue<Character> getPipedWriter() {
        return out;
    }

    public void run() {
        try {
            while (true)
                for (char c = 'A'; c <= 'z'; c++) {
                    out.put(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
        } catch (InterruptedException e) {
            print(e + " Sender sleep interrupted");
        }
    }
}

class Receiver implements Runnable {
    private BlockingQueue<Character> in;

    public Receiver(SenderEx30 sender) throws IOException {
        in = sender.getPipedWriter();
    }

    public void run() {
        try {
            while (true) {
                // Blocks until characters are there:
                printnb("Read: " + (char) in.take() + ", ");
            }
        } catch (InterruptedException e) {
            print(e + " Receiver read exception");
        }
    }

}

class PipedIO {
    public static void main(String[] args) throws Exception {
        SenderEx30 sender = new SenderEx30();
        Receiver receiver = new Receiver(sender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
} /* Output: (65% match)
Read: A, Read: B, Read: C, Read: D, Read: E, Read: F, Read: G, Read: H, Read: I, Read: J, Read: K, Read: L, Read: M, java.lang.InterruptedException: sleep interrupted Sender sleep interrupted
java.io.InterruptedIOException Receiver read exception
*///:~

