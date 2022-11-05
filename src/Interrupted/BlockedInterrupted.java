package Interrupted;

public class BlockedInterrupted {
    public static void main(String[] args) {
        Thread t = new Thread(BlockedInterrupted::run);
        t.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }

    public static void run() {
        int counter = 0;
        while (true) {
            try {
                Thread.sleep(1000);
                counter++;
                System.out.println("Counter: " + counter);
            } catch (InterruptedException e) {
                System.out.println("I got interrupted");
                return;
            }
        }
    }
}
