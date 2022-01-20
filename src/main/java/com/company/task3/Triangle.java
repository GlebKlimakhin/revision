package com.company.task3;

public class Triangle extends AbstractFigure{

    private double aSideLength;
    private double bSideLength;
    private double cSideLength;
    private double squareRadiusLength;

    public Triangle(double aSideLength, double bSideLength, double cSideLength, double squareRadiusLength) {
        this.aSideLength = aSideLength;
        this.bSideLength = bSideLength;
        this.cSideLength = cSideLength;
        this.squareRadiusLength = squareRadiusLength;
    }

    public double getASideLength() {
        return aSideLength;
    }

    public double getBSideLength() {
        return bSideLength;
    }

    public double getCSideLength() {
        return cSideLength;
    }

    public double getSquareRadiusLength() {
        return squareRadiusLength;
    }

    @Override
    public double calculateAreaNumber() {
        return (aSideLength * bSideLength * cSideLength)/4*squareRadiusLength;
    }



}
