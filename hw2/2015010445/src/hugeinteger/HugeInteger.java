package hugeinteger;

public class HugeInteger {

    int sign = 1, length;
    int[] number = new int[41];
    
    // digits are stored reversely!

    void assign(String num) {
        int j;
        if (num.charAt(0) == '-') {
            sign = -1;
            length = num.length() - 1;
            for (int i = 1; i <= length; i++) {
                j = length - i;
                number[j] = Character.getNumericValue(num.charAt(i));
            }
        }
        else {
            sign = 1;
            length = num.length();
            for (int i = 0; i < length; i++) {
                j = length - 1 - i;
                number[j] = Character.getNumericValue(num.charAt(i));
            }
        }
    }

    HugeInteger(String num) {
        assign(num);
    }

    void input(String num) {
        assign(num);
    }

    void output() {
        int j;
        if (sign == -1)
            System.out.printf("-");
        for (int i = 0; i < length; i++) {
            j = length - 1 - i;
            System.out.format("%d", number[j]);
        }
        System.out.printf("\n");
    }

    void add_abs(HugeInteger b) {
        // a = a + b, not considering signs
        int c = 0;
        for (int i = 0; i < java.lang.Math.max(b.length, length); i++) {
            if (i >= b.length)
                b.number[i] = 0;
            else
                if (i >= length)
                    number[i] = 0;
            // System.out.printf("%d %d %d\n", number[i], b.number[i], c);
            number[i] = number[i] + b.number[i] + c;
            if (number[i] > 9) {
                number[i] -= 10;
                c = 1;
            }
            else
                c = 0;
        }
        if (c == 1) {
            length += 1;
            number[length - 1] = 1;
        }
    }

    // a - b -> this
    void sub_abs(HugeInteger a, HugeInteger b) {
        // a = a + b, not considering signs
        int c = 0;
        // a.length must >= b.length
        for (int i = 0; i < a.length; i++) {
            if (i >= b.length)
                b.number[i] = 0;
            else
                if (i >= a.length)
                    a.number[i] = 0;
            number[i] = a.number[i] - b.number[i] + c;
            if (number[i] < 0) {
                number[i] += 10;
                c = -1;
            }
            else
                c = 0;
        }
        for (int i = length - 1; i >= 0; i--) {
            if (number[i] == 0) {
                length = i;
            }
        }
        if (length == 0) length = 1;
    }

    void add(HugeInteger b) {
        if (sign == b.sign) {
            // add without signs
            // System.out.println("OK!");
            add_abs(b);
            // no need to change sign
        }
        else
            if (sign == 1 && b.sign == -1) {
                if (isGreaterThan_abs(b)) {
                    sub_abs(this, b);
                    sign = 1;
                }
                else {
                    sub_abs(this, b);
                    sign = -1;
                }
            }
            else { // sign == -1 && b.sign == 1
                if (isGreaterThan_abs(b)) {
                    sub_abs(this, b);
                    sign = -1;
                }
                else {
                    sub_abs(b, this);
                    sign = 1;
                }
            }
    }

    void sub(HugeInteger b) {
        if (sign == 1 && b.sign == 1) {
            if (isGreaterThan_abs(b)) {
                sub_abs(this, b);
                sign = 1;
            }
            else {
                sub_abs(b, this);
                sign = -1;
            }
        }
        else if (sign == 1 && b.sign == -1) {
            add_abs(b);
        }
        else if (sign == -1 && b.sign == 1) {
            add_abs(b);
            sign = -1;
        }
        else if (sign == -1 && b.sign == -1) {
            if (isGreaterThan_abs(b)) {
                sub_abs(this, b);
                sign = -1;
            }
            else {
                sub_abs(b, this);
                sign = 1;
            }
        }
    }

    boolean isEqualTo(HugeInteger b) {
        if (sign == b.sign && length == b.length) {
            for (int i = 0; i < length; i++) {
                if (number[i] != b.number[i]) {
                    return false;
                }
            }
            return true;
        }
        else
            return false;
    }

    boolean isNotEqualTo(HugeInteger b) {
        return !isEqualTo(b);
    }

    boolean isGreaterThan_abs(HugeInteger b) {
        if (length < b.length)
            return false;
        else
            if (length > b.length)
                return true;
        // two integers are of the same length
        for (int i = 0; i < length; i++) {
            int j = length - 1 - i;
            if (number[j] > b.number[j])
                return true;
            else
                if (number[j] < b.number[j])
                    return false;
        }
        return false; // equal
    }

    boolean isGreaterThan(HugeInteger b) {
        if (sign > b.sign) return true;
        else if (sign < b.sign) return false;
        else if (sign == 1) return isGreaterThan_abs(b);
        else return !isGreaterThan_abs(b); // sign == -1
    }

    boolean isLessThan(HugeInteger b) {
        return !(isGreaterThan(b) || isEqualTo(b));
    }

    boolean isGreaterThanOrEqualTo(HugeInteger b) {
        return !isLessThan(b);
    }

    boolean isLessThanOrEqualTo(HugeInteger b) {
        return !isGreaterThan(b);
    }

}