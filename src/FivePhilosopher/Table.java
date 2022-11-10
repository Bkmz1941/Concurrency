package FivePhilosopher;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Table {
    public static void main(String[] args) {
        Lock fork1 = new ReentrantLock();
        Lock fork2 = new ReentrantLock();
        Lock fork3 = new ReentrantLock();
        Lock fork4 = new ReentrantLock();
        Lock fork5 = new ReentrantLock();

        Philosopher philosopher1 = new Philosopher(fork1, fork2, "Ilya");
        Philosopher philosopher2 = new Philosopher(fork2, fork3, "Anna");
        Philosopher philosopher3 = new Philosopher(fork3, fork4, "Dima");
        Philosopher philosopher4 = new Philosopher(fork4, fork5, "Elena");
        Philosopher philosopher5 = new Philosopher(fork5, fork1, "Alexandr");

        Thread t1 = new Thread(philosopher1::eat);
        Thread t2 = new Thread(philosopher2::eat);
        Thread t3 = new Thread(philosopher3::eat);
        Thread t4 = new Thread(philosopher4::eat);
        Thread t5 = new Thread(philosopher5::eat);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
