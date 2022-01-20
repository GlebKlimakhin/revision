package com.company.task3;

public class Circle extends AbstractFigure{

    private double diameter;

    public Circle(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public double calculateAreaNumber() {
        double radius = diameter / 2;
        return (Math.PI * radius* radius);
    }

    public double getDiameter() {
        return diameter;
    }

}
