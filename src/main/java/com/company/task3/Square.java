package com.company.task3;

public class Square extends AbstractFigure{

    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    @Override
    public double calculateAreaNumber() {
        return Math.pow(sideLength, 2);
    }
}
