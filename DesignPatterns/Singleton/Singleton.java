package DesignPatterns.Singleton;
import java.util.concurrent.locks.ReentrantLock;


public class Singleton {
    private static Singleton instance;
    private static final ReentrantLock lock = new ReentrantLock();

    private Singleton() {
    }

    public static Singleton getinstance() {
        if (instance == null) {
            lock.lock();
            if (instance == null) {
                instance = new Singleton();
            }
            lock.unlock();
        }
        return instance;
    }
}
