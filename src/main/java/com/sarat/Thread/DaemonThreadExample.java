package com.Practice.Thread;

public class DaemonThreadExample {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Daemon thread is running in background...");
                    try {
                        Thread.sleep(1000); // Sleep for 1 second
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        daemonThread.setDaemon(true); // Set before starting the thread
        daemonThread.start();

        System.out.println("Main thread sleeping for 10 seconds...");
        try {
            Thread.sleep(10000); // Sleep main thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished. JVM will exit now if only daemon threads are left.");
    }
}
