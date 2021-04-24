package org.zhxie.leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {
    private final ReentrantLock[] forks = new ReentrantLock[] {
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
    };

    private final Semaphore eatLimit = new Semaphore(4);

    public DiningPhilosophers() {


    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int leftFork = (philosopher + 1) % 5;
        int rightFork = philosopher;
        eatLimit.acquire();
        forks[leftFork].lock();
        forks[rightFork].lock();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        forks[leftFork].unlock();
        forks[rightFork].unlock();
        eatLimit.release();
    }
}