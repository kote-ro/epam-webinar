package com.epam.task5;

public class Part1 {

    public static void main(String[] args) {
        ClassicThread classicThread = new ClassicThread();
        RunnableThread runnableThread = new RunnableThread();

        try {
            classicThread.start();
            classicThread.join();
            Thread.sleep(500);
            runnableThread.run();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {

        }

    }

    static class ClassicThread extends Thread {
        @Override
        public synchronized void run() {
            ClassicThread ct = new ClassicThread();

            System.out.println(ct.getName());
            for (int i = 0; i < 4; i++) {
                try {
                    sleep(500);
                    System.out.println(ct.getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class RunnableThread implements Runnable {
        @Override
        public synchronized void run() {
            ClassicThread ct = new ClassicThread();

            System.out.println(ct.getName());
            for (int i = 0; i < 4; i++) {
                try {
                    Thread.sleep(500);
                    System.out.println(ct.getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
