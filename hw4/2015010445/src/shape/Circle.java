package shape;

import java.lang.Math;

public class Circle extends Shape {
    private double radius;
    Circle() {
    }
    Circle(double r) {
        radius = r;
    }
    Circle(double r, String c) {
        radius = r;
        color = c;
    }
    double getRadius() {
        return radius;
    }
    void setRadius(double r) {
        radius = r;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }

    double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    public String toString() {
        return "Circle (" + color + ")";
    }
}