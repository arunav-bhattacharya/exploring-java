package com.arunav.java.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _4LockInterface {

    public static void main(String[] args) {
    }

    private class Counter {
        private int counter;
        Lock lock = new ReentrantLock();
        void increment() {
            lock.lock();
            counter++;
            lock.unlock();
        }

        void decrement() {}
    }
}

