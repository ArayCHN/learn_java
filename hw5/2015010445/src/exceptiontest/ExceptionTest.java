package exceptiontest;

import java.lang.Math;

public class ExceptionTest {

    double getX(double y) throws XLessThanZeroException, XGreaterThanOneException {
        double x = Math.log(y);
        if (x < 0) {
            throw new XLessThanZeroException(y);
        }
        else if (x > 1) {
            throw new XGreaterThanOneException();
        }
        else {
            return x;
        }
    }

    int getFirstValidInt() {
        while (true) {
            try {
                return Test.readInt();
            } catch(Exception e) {
            }
        }
    }

    double solve(double y) {
        try {
            return Test.solve2(y);
        } catch(XLessThanZeroException e) {
            return -1;
        } catch(XGreaterThanOneException e) {
            return -2;
        }
    }
}