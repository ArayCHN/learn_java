package exceptiontest;

public class XLessThanZeroException extends Exception {
    double y;
    public XLessThanZeroException(double y_init) {
        y = y_init;
    }
    String getInfo() {
        return Double.toString(y) + " is too small";
    }
}