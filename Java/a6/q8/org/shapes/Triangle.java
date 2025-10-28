package org.shapes;

public class Triangle {
    double a, b, c; // sides of triangle

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        double s = (a + b + c) / 2; // semi-perimeter
        return Math.sqrt(s * (s - a) * (s - b) * (s - c)); // Heron's Formula
    }

    public double perimeter() {
        return a + b + c;
    }
}
