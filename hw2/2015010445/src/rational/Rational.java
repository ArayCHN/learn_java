package rational;

public class Rational {
    int numerator, denominator;

    int gcd(int a, int b) {
        int r, c, tmp;
        a = java.lang.Math.abs(a);
        b = java.lang.Math.abs(b);
        if (a > b) {
            tmp = a;
            a = b;
            b = tmp;
        }
        while (b != 0) {
            c = a / b;
            r = a - b * c;
            a = b;
            b = r;
        }
        return a;
    }

    void simplify() {
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        if (numerator != 0) {
            int c = gcd(numerator, denominator);
            numerator /= c;
            denominator /= c;
        }
    }

    Rational(int a, int b) {
        numerator = a;
        denominator = b;
        simplify();
    }

    void add(Rational b) {
        int gcd_ab = gcd(denominator, b.denominator); // greates common divisor
        int lcm = denominator * b.denominator / gcd_ab; // least common multiple
        int a_new_numerator = lcm / denominator * numerator;
        int b_new_numerator = lcm / b.denominator * b.numerator;
        numerator = a_new_numerator + b_new_numerator;
        denominator = lcm;
        simplify();
    }

    void sub(Rational b) {
        int gcd_ab = gcd(denominator, b.denominator); // greates common divisor
        int lcm = denominator * b.denominator / gcd_ab; // least common multiple
        int a_new_numerator = lcm / denominator * numerator;
        int b_new_numerator = lcm / b.denominator * b.numerator;
        numerator = a_new_numerator - b_new_numerator;
        denominator = lcm;
        simplify();
    }

    void mul(Rational b) {
        numerator *= b.numerator;
        denominator *= b.denominator;
        simplify();
    }

    void div(Rational b) {
        numerator *= b.denominator;
        denominator *= b.numerator;
        simplify();
    }

    void printRational() {
        if (denominator == 1 || numerator == 0)
            System.out.println(numerator);
        else
            System.out.println(String.format("%d/%d", numerator, denominator));
    }

    void printReal() {
        System.out.println((numerator + 0.0) / (denominator + 0.0));
    }

}