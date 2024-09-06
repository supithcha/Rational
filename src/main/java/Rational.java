class Rational {
    long numerator,denominator;

    class Illegal extends Exception {
        String reason;
        Illegal (String reason) {
            this.reason = reason;
        }
    }

    Rational() {
        // to be completed
        numerator = 0;
        denominator = 1;
    }

    Rational(long numerator, long denominator) throws Illegal {
        // to be completed
        if (denominator == 0) {
            throw new Illegal("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplestForm();
    }

    // find the reduce form
    private void simplestForm() {
        long computeGCD;
        computeGCD = GCD(Math.abs(numerator), denominator);
        numerator /= computeGCD;
        denominator /= computeGCD;
    }

    // find the greatest common denominator
    private long GCD(long a, long b) {
        if (a%b ==0) return b;
        else return GCD(b,a%b);
    }

    /***
     * Compute an addition of the current rational number to another given rational number
     * @param x the rational number to be added to the current rational number
     */
    public void add(Rational x) {
        numerator = (numerator * x.denominator) + (x.numerator * denominator);
        denominator = (denominator * x.denominator);
        simplestForm();
    }

    /***
     * Compute a subtraction of the current rational number to another given rational number
     * @param x the rational number to be subtracted from the current rational number
     */
    public void subtract(Rational x) {
        // to be completed

        numerator = (numerator * x.denominator) - (x.numerator * denominator);
        denominator = (denominator * x.denominator);
        simplestForm();
    }

    /***
     * Compute a multiplication of the current rational number to another given rational number
     * @param x the rational number to be multiplied to the current rational number
     */
    public void multiply(Rational x) {
        // to be completed

        numerator = numerator * x.numerator;
        denominator = denominator * x.denominator;
        simplestForm();
    }

    /***
     * Compute a division of the current rational number to another given rational number
     * @param x the rational number to be divided by the current rational number
     */
    public void divide(Rational x) {
        // to be completed

        if (x.numerator == 0) {
            throw new ArithmeticException("Division by zero");
        }
        numerator = numerator * x.denominator;
        denominator = denominator * x.numerator;
        simplestForm();
    }

    /***
     * Check if the given rational number equals to the current rational number
     * @param x the rational number to be compared to the current rational number
     * @return true if the given rational number equals to the current, false otherwise
     */
    public boolean equals(Object x) {
        // to be completed
        if (x instanceof Rational) {
            Rational other = (Rational) x;
            // Simplify both rational numbers before comparison
            this.simplestForm();
            other.simplestForm();
            return this.numerator == other.numerator && this.denominator == other.denominator;
        }
        return false;
    }

    /***
     * Compare the current rational number to the current rational number
     * @param x the rational number to be compared to the current rational number
     * @return -1 if the current rational number is less than the given number, 0 if they're equal, 1 if the current
     * rational number is larger than the given number
     */
    public long compareTo(Object x) {
        // to be completed
        if (x instanceof Rational) {
            Rational other = (Rational) x;
            long leftSide = this.numerator * other.denominator;
            long rightSide = this.denominator * other.numerator;
            return Long.compare(leftSide, rightSide);
        }
        return -1; // Error code for incompatible object
    }

    /***
     * Give the formatted string of the rational number
     * @return the string representation of the rational number. For example, "1/2", "3/4".
     */
    public String toString() {
        // to be completed
        if (denominator == 1) {
            return numerator + "";
        } else {
            return numerator + "/" + denominator;
        }
    }

    public static void main(String[] args) {
        System.out.println("This is Rational class.");
        try {
            Rational r1 = new Rational(1, 2);
            Rational r2 = new Rational(1, 4);

            System.out.println("Numerator of r1 is " + 1 + ", Denominator is " + 2);
            System.out.println("Numerator of r2 is " + 1 + ", Denominator is " + 4);

            r1.add(r2);
            System.out.println("Addition: " + r1);

            r1 = new Rational(1, 2);
            r1.subtract(r2);
            System.out.println("Subtraction: " + r1);

            r1 = new Rational(1, 2);
            r1.multiply(r2);
            System.out.println("Multiplication: " + r1);

            r1 = new Rational(1, 2);
            r1.divide(r2);
            System.out.println("Division: " + r1);

        } catch (Illegal e) {
            System.out.println(e.reason);
        }
    }
}