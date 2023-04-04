package com.company;

import java.util.Scanner;

public class Main {
    public static void printShapeDetails(String shapeName, Shape shape) {
        System.out.println("Shape: " + shapeName);
        System.out.println("\nProperties: \n" + shape.getProperties() );
        System.out.println("\nArea: " + shape.calculateArea());
        System.out.println("Perimeter: " + shape.calculatePerimeter());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Select a shape:");
        System.out.println("1. Square");
        System.out.println("2. Rectangle");
        System.out.println("3. Circle");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter the side length of the square:");
                double side = sc.nextDouble();
                Square square = new Square(side);
                printShapeDetails("Square", square);
                break;

            case 2:
                System.out.println("Enter the length of the rectangle:");
                double length = sc.nextDouble();
                System.out.println("Enter the width of the rectangle:");
                double width = sc.nextDouble();
                Rectangle rectangle = new Rectangle(length, width);
                printShapeDetails("Rectangle", rectangle);
                break;

            case 3:
                System.out.println("Enter the radius of the circle:");
                double radius = sc.nextDouble();
                Circle circle = new Circle(radius);
                printShapeDetails("Circle", circle);
                break;

            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
}
