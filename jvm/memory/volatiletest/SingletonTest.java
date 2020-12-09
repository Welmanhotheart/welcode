package memory.volatiletest;

public class SingletonTest {
    private volatile static SingletonTest instance;

    public static SingletonTest getInstance() {
        if (instance == null) {
            synchronized (SingletonTest.class) {
                if (instance == null) {
                    instance = new SingletonTest();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonTest.getInstance();
    }
}
