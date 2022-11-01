package Lifecycle;

import java.util.Comparator;

public class ThreadStateTest {
    public static void main(String[] args) {
        final Object syncObject = new Object();
        ThreadState ts = new ThreadState(syncObject);
        detectAliveAndState(ts, 1);

        ts.start();
        detectAliveAndState(ts, 2);

        ts.setWait(true);
        synchronized (syncObject) {
            detectAliveAndState(ts, 3);
            ts.setWait(false);
            syncObject.notify();
        }

        sleepNow(2000);
        detectAliveAndState(ts, 4);

        ts.setKeepRunning(false);
        sleepNow(2000);
        detectAliveAndState(ts, 5);

        /**
         * isAlive(): false
         * #1: NEW
         * isAlive(): true
         * #2: RUNNABLE
         * isAlive(): true
         * #3: WAITING
         * isAlive(): true
         * #4: RUNNABLE
         * isAlive(): false
         * #5: TERMINATED
         */
    }

    private static void detectAliveAndState(Thread t, int n) {
        System.out.println("isAlive(): " + t.isAlive());
        System.out.println("#" + n + ": " + t.getState());
    }

    private static void sleepNow(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Throwable ignore) {}
    }
}
