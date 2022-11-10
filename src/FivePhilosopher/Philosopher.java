package FivePhilosopher;

import java.util.concurrent.locks.Lock;

public class Philosopher {
    private final Lock leftFork;
    private final Lock rightFork;
    private final String name;

    public Philosopher(Lock leftFork, Lock rightFork, String name) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.name = name;
    }

    public void think() {
        System.out.println(name + " is thinking...");
    }

    public void eat() {
        if (leftFork.tryLock()) {
            try {
                if (rightFork.tryLock()) {
                    try {
                        System.out.println(name + " is eating...");
                    } finally {
                        rightFork.unlock();

                    }
                } else {
                    this.think();
                }
            } finally {
                leftFork.unlock();
            }
        } else {
            this.think();
        }
    }
}
