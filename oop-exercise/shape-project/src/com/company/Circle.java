package com.company;

public class Circle implements Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return (22 / 7) * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (22 / 7) * radius;
    }

    @Override
    public String getProperties() {
        return " Radius: " + radius;
    }
}
