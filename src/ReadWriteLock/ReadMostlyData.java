package ReadWriteLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadMostlyData {
    private int value;
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock rLock = rwLock.readLock();
    private final Lock wLock = rwLock.writeLock();

    public int getValue() {
        rLock.lock();
        try {
            return this.value;
        } finally {
            rLock.unlock();
        }
    }

    public void setValue(int value) {
        wLock.lock();
        try {
            this.value = value;
        } finally {
            wLock.unlock();
        }
    }
}
