package ProducerConsumer;

import java.util.Random;

public class Producer extends Thread {
    private final Buffer buffer;
    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }
    /**
     * Generate a random number and store it in the buffer
     */
    @Override
    public void run() {
        Random rand = new Random();
        //noinspection InfiniteLoopStatement
        while (true) {
            int n = rand.nextInt();
            buffer.produce(n);
        }
    }
}
