package ProducerConsumer;

public class Consumer extends Thread {
    private final Buffer buffer;
    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }
    /**
     * It read number from buffer
     */
    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            buffer.consume();
        }
    }
}
