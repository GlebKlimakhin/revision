package com.company.task2;

import java.net.URI;

public class Main {
    public static void main(String[] args) {
        Car speedy = new LightWeightCar(500, "red", "Ferrari");
        Car lorry = new Lorry(400, "black", "Man");
        speedy.open();
        speedy.move();
        speedy.stop();
        lorry.open();
        lorry.move();
        lorry.stop();
    }
}
