package ThreadPriority;

public class ThreadPriority {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("main thread priority: " + t.getPriority());

        Thread t1 = new Thread();
        System.out.println("t1 thread priority: " + t1.getPriority());
        t1.setPriority(Thread.MAX_PRIORITY);
        System.out.println("t1 thread priority: " + t1.getPriority());

        t.setPriority(Thread.MAX_PRIORITY);
        Thread t2 = new Thread();
        System.out.println("t2 thread priority: " + t2.getPriority());
        t2.setPriority(Thread.MIN_PRIORITY);
        System.out.println("t2 thread priority: " + t2.getPriority());

        /**
         * main thread priority: 5
         * t1 thread priority: 5
         * t1 thread priority: 10
         * t2 thread priority: 10
         * t2 thread priority: 1
         */
    }
}
