package shape;

public class Rectangle extends Shape {
    public double width, height;
    Rectangle() {
    }
    Rectangle(double w, double h) {
        width = w;
        height = h;
    }
    Rectangle(double w, double h, String c) {
        width = w;
        height = h;
        color = c;
    }
    double getHeight() {
        return height;
    }
    double getWidth() {
        return width;
    }
    void setHeight(double h) {
        height = h;
    }
    void setWidth(double w) {
        width = w;
    }

    double getArea() {
        return width * height;
    }

    double getPerimeter() {
        return 2 * (height + width);
    }

    public String toString() {
        return "Rectangle (" + color + ")";
    }
}