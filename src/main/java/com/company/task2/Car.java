package com.company.task2;

abstract class Car implements Moveable, Stopable{
    public Engine engine;
    protected String color;
    protected String name;

    public Car(Engine engine, String color, String name) {
        this.engine = engine;
        this.color = color;
        this.name = name;
    }

    public Car() {
    }

    abstract void open();

    protected static class Engine {
        private final int HP;

        protected Engine(int hp) {
            this.HP = hp;
        }
    }


}
