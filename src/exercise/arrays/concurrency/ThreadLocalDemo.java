package exercise.arrays.concurrency;

public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocalService<String> threadLocalService = new ThreadLocalService<String>();
        for (int i = 0; i < 100; i++) {
            new ThreadSub("thread" + i, threadLocalService).start();
        }
    }
    private static class ThreadLocalSub<T> extends ThreadLocal<T> {

        private String name;
        ThreadLocalSub(String name) {
            this.name = name;
        }
        public T get() {
            Thread thread = Thread.currentThread();
            System.out.println("thread:" + thread);
            return super.get();
        }

        @Override
        public String toString() {
            return this.name;
        }
    }


    private static class ThreadLocalService<T> {
        private ThreadLocalSub<T> localSub = new ThreadLocalSub<T>("localSub");

        public void setValue(T value) {
            localSub.set(value);
        }

        public T getValue() {
            return localSub.get();
        }

    }

    private static class ThreadSub extends Thread {
        private static int count = 0;
        private int id = (++count);
        private ThreadLocalService threadLocalService;
        ThreadSub(String name, ThreadLocalService threadLocalService) {
            super(name);
            this.threadLocalService = threadLocalService;
        }

        public void setValue(String value) {
            threadLocalService.setValue(value);
        }

        @Override
        public void start() {
            threadLocalService.setValue(id);

            System.out.println(threadLocalService.getValue());
        }

        @Override
        public String toString() {
            return "id:" + id + ";name=" + getName();
        }
    }

}




