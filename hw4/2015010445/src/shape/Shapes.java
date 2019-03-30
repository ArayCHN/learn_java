package shape;

public class Shapes {
    Shape[] shapes;
    Shapes(Shape[] s) {
        shapes = s;
    }
    double getArea() {
        double area = 0;
        for (int i = 0; i < shapes.length; i++) {
            area += shapes[i].getArea();
        }
        return area;
    }
    double getFilledArea() {
        double area = 0;
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i].isFilled())
                area += shapes[i].getArea();
        }
        return area;
    }
    public String toString() {
        String name = "[" + shapes[0].toString();
        for (int i = 1; i < shapes.length; i++) {
            name += ", ";
            name += shapes[i].toString();
        }
        name += "]";
        return name;
    }
}