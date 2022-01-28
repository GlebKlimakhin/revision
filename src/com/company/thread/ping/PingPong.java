package com.company.thread.ping;

public class PingPong {

    private final static Object ball = new Object();
    static Counter counter = new Counter();

    public static void main(String[] args) throws InterruptedException{

        while (true) {
            new Thread(() -> {
                try {
                    synchronized (ball) {
                        while (counter.getCounter() != 0) {
                            ball.wait();
                        }
                        System.out.println("ping");
                        counter.setCounter(1);
                        ball.notifyAll();
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            Thread.sleep(1000);


            new Thread(() -> {
                try {
                    synchronized (ball) {
                        while (counter.getCounter() != 1) {
                            ball.wait();
                        }
                        System.out.println("pong");
                        counter.setCounter(0);
                        ball.notifyAll();
                        Thread.sleep(1000);
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            Thread.sleep(1000);
        }
    }

}
