package StopSuspendResume;

public class StopSuspendResume extends Thread {
    private volatile boolean keepRunning = true;
    private boolean suspend = false;

    public StopSuspendResume(String name) {
        super(name);
    }

    public synchronized void stopThread() {
        this.interrupt();
//        this.keepRunning = false;
//        this.notify();
    }

    public synchronized void suspendTread() {
        this.suspend = true;
    }

    public synchronized void resumeTread() {
        this.suspend = false;
        this.notify();
    }

    @Override
    public void run() {
        System.out.println("Thread started...");

        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println("Going to sleep...");
                Thread.sleep(1000);

                synchronized (this) {
                    while (suspend) {
                        System.out.println("Suspended...");
                        this.wait();
                        System.out.println("Resume...");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

        System.out.println("Thread stopped...");
    }

    public static void main(String[] args) {
        StopSuspendResume t = new StopSuspendResume("Suspend");
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.suspendTread();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.resumeTread();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.stopThread();
    }
}
