package com.company.task3;

public class Main {
    public static void main(String[] args) {
        AbstractFigure figure = new Circle(10);
        System.out.println(figure.calculateAreaNumber());
        AbstractFigure square = new Square(5.5);
        System.out.println(square.calculateAreaNumber());
        AbstractFigure triangle = new Triangle(1, 1, 1, 1);
        System.out.println(triangle.calculateAreaNumber());
    }
}
