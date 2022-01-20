package com.company.task2;

public class Lorry extends Car{

    private final long weight;

    public Lorry(long weight, String color, String name) {
        this.weight = weight;
        this.color = color;
        this.engine = new Engine(500);
    }

    @Override
    void open() {
        System.out.println("Lorry is opened");
    }

    @Override
    public void move() {
        System.out.println("Lorry is moving slowly");
    }

    @Override
    public void stop() {
        try {
            Thread.sleep(weight * 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Lorry has been stopping for donkey’s years");
    }
}
