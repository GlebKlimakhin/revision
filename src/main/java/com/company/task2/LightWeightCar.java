package com.company.task2;

public class LightWeightCar extends Car{

    private int tyreConditionPercent;

    public LightWeightCar(int hp, String color, String name) {
        this.engine = new Engine(hp);
        this.color = color;
        this.name = name;
        this.tyreConditionPercent = 78;
    }

    public void setTyreConditionPercent(int tyreConditionPercent) {
        this.tyreConditionPercent = tyreConditionPercent;
    }

    @Override
    void open() {
        System.out.println("LightWeight car is opened");
    }

    @Override
    public void move() {
        System.out.println("LightWeightCar is moving with a speed " + tyreConditionPercent * 2);
    }

    @Override
    public void stop() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("LightWeight car stopped in a blink of an eye!");
    }
}
