package DeamonThread;

public class DeamonThread {
    public static void main(String[] args) {
        Thread t = new Thread(DeamonThread::print);
        t.setDaemon(true);
        t.start();

        System.out.println("Exiting main thread");
    }

    public static void print() {
        int counter = 1;
        while (true) {
            try {
                System.out.println("Counter: ^^" + counter++);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
