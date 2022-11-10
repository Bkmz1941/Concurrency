package UncaughtException;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CatchAllThreadExceptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Lock fork1 = new ReentrantLock();
        System.out.println("Caught exception from thread: " + t.getName());
    }
}
