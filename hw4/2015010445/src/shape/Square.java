package shape;

public class Square extends Rectangle {
    public double side;
    Square() {
    }
    Square(double s) {
        side = s;
        width = s;
        height = s;
    }
    Square(double s, String c) {
        side = s;
        width = s;
        height = s;
        color = c;
    }
    double getSide() {
        return side;
    }
    void setSide(double s) {
        side = s;
        width = s;
        height = s;
    }

    public String toString() {
        return "Square (" + color + ")";
    }
}