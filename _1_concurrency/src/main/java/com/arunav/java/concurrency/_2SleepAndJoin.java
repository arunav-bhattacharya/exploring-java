package com.arunav.java.concurrency;

import java.util.ArrayList;
import java.util.List;

import static com.arunav.java.concurrency.Util.sleep;

public class _2SleepAndJoin {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        StatusReporter reporter = new StatusReporter(threads);

        Thread t1 = new Thread("Thread1");
        threads.add(t1);
        t1.start();

        Thread t2 = new Thread(() -> sleep(5000L), "Thread2");
        threads.add(t2);
        t2.start();

        Thread reportingThread = new Thread (reporter::report);
        reportingThread.setDaemon(true);
        reportingThread.start();
    }
}

class StatusReporter {
    private List<Thread> threads;
    StatusReporter(List<Thread> threads) {
        this.threads = threads;
    }

    void report() {
        while(true) {
            threads.forEach(thread -> System.out.println("Thread=" + thread.getName() + ", State=" + thread.getState()));
            sleep(2000L);
        }
    }
}

class Util{
    static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            System.out.println("Thread interrupted");
        }
    }
}

