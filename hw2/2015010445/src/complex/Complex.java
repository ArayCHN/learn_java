package complex;

public class Complex {
    double realPart, imaginaryPart;
    Complex(double a, double b) {
        realPart = a;
        imaginaryPart = b;
    }
    void add(Complex X) {
        realPart += X.realPart;
        imaginaryPart += X.imaginaryPart;
        return;
    }
    void sub(Complex X) {
        realPart -= X.realPart;
        imaginaryPart -= X.imaginaryPart;
        return;
    }
    String print() {
        String printString = new String();
        if (imaginaryPart > 0)
            printString = String.format("%f+%fi", realPart, imaginaryPart);
        else
            printString = String.format("%f%fi", realPart, imaginaryPart);
        System.out.println(printString);
        return printString;
    }
}