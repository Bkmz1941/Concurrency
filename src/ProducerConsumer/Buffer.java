package ProducerConsumer;

public class Buffer {
    private int data;
    private boolean empty;
    public Buffer() {
        this.empty = true;
    }

    /**
     * Отправить данные в буфер
     * @param newData - некоторые данные
     */
    public synchronized void produce(int newData) {
        while (!this.empty) {
            try {
                // Перейти в состояние 'ожидающий' и ждать когда тебя пробудят
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.data = newData;
        this.empty = false;
        // Уведомить другой случайный 'ожидающий' поток программы (пробудить его)
        this.notify();
        System.out.println("Produced: " + newData);
    }
    /**
     * Считать данные из буфера
     */
    public synchronized int consume() {
        while (this.empty) {
            try {
                // Перейти в состояние 'ожидающий' и ждать когда тебя пробудят
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.empty = true;
        // Уведомить другой случайный 'ожидающий' поток программы (пробудить его)
        this.notify();
        System.out.println("Consumed: " + data);
        return data;
    }
}
