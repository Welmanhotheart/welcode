package exercise.concurrency;


import java.util.PriorityQueue;

class PriorityElement implements Comparable<PriorityElement> {
    private static int count = 0;
    private int id = count++;
    private int priority;

    public PriorityElement(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "id:" + id + ";priority:" + priority + "; ";
    }

    @Override
    public int compareTo(PriorityElement o) {
        int o1 = this.priority;
        int o2 = o.priority;
        if (o1 < o2) {
            return  -1;
        }
        if (o1 > o2) {
            return 1;
        }
        return 0;
    }
}

public class TestPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<PriorityElement> queue = new PriorityQueue<PriorityElement>(15);
        for (int i = 20; i > 0; i--) {
            queue.add(new PriorityElement(i));
        }

        System.out.println("==================normally traverse it==============");
        for (PriorityElement element : queue) {
            System.out.println(element);
        }

        System.out.println("==================orderly traverse it==============");
       while(true) {
           PriorityElement poll = queue.poll();
           if(poll == null) {
               break;
           }
           System.out.println(poll);
       }
    }
}
