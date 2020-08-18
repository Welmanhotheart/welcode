package project;

/**
 * 线程还未执行完成异常
 */
public class ThreadUnfinishedYetException extends IllegalAccessException {
    public ThreadUnfinishedYetException(String message) {
        super(message);
    }
}
