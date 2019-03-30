package shape;

public abstract class Shape {

    public String color = "#"; // only public members can be inherited!

    Shape() {
    }

    Shape(String init_color) {
        color = init_color;
    }

    String getColor() {
        return color;
    }

    void setColor(String set_color) {
        color = set_color;
    }

    boolean isFilled() {
        if (color == "#")
            return false;
        else
            return true;
    }

    abstract double getArea();

    abstract double getPerimeter();

    public abstract String toString();
}