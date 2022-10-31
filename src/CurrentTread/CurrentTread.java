package CurrentTread;

public class CurrentTread extends Thread {
    public CurrentTread(String name) {
        super(name);
    }
    @Override
    public void run() {
        // Method currentThread() return the reference of the thread executing the call
        Thread t = Thread.currentThread();
        String threadName = t.getName();
        System.out.println("Inside run() method: " + threadName);
    }

    public static void main(String[] args) {
        CurrentTread currentTread1 = new CurrentTread("Thread #1");
        CurrentTread currentTread2 = new CurrentTread("Thread #2");
        currentTread1.start();
        currentTread2.start();

        Thread t = Thread.currentThread();
        String threadName = t.getName();
        System.out.println("Inside main() method: " + threadName);
    }
}
