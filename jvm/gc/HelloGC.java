package gc;


public class HelloGC {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("************HelloGC");
//        Thread.sleep(Integer.MAX_VALUE);
    }
}

class HelloGCEx extends HelloGC {
    public static void main(String[] args) {
        byte[]array = new byte[1*1024*1024];
        int i = Runtime.getRuntime().availableProcessors();
        long l = Runtime.getRuntime().totalMemory();
        long l1 = Runtime.getRuntime().maxMemory();
        System.out.println(i + ";" + l/(double)1024/1024 + ";" + l1/(double)1024/1024);
    }
}