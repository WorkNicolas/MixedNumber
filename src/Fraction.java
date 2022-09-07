import java.math.BigInteger;

/**
 * @author San Juan, Jean Carlo (original)
 * @author San Juan, John Rexcel (original)
 * @author Santos, Johan (original)
 * @author Mendoza, Carl Nicolas (new)
 * @version 9/6/2022
 * @summary Fraction - an object that represents parts of a whole
 *           number. A fraction is created by supplying a numerator and a
 *           denominator.
 */
public class Fraction {
    protected int num = 0;
    protected int den = 1;

    public Fraction() {
    }

    public Fraction(Number num, Number den) {
        this.num = num.intValue();
        this.den = den.intValue();
        this.simplify();
    }

    public static Fraction simplify(Fraction f) {
        int gcd = gcd(f.num, f.den);
        int num = f.num / gcd;
        int den = f.den / gcd;
        return new Fraction(num, den);
    }

    // Class-based operations
    // Prepares two fractions for an add/subtract/comparison operation by providing
    // their scaled equivalents.
    public static int[] operation(Fraction f1, Fraction f2) {
        int[] packed = {
                f1.getNumerator() * f2.getDenominator(),
                f2.getNumerator() * f1.getDenominator(),
                f1.getDenominator() * f2.getDenominator()
        };
        return packed;
    }

    public static Fraction subtract(Fraction f1, Fraction f2) {
        int[] v = operation(f1, f2);

        return new Fraction(v[0] - v[1], v[2]);
    }

    // Creates a new fraction by adding two existing ones.
    public static Fraction add(Fraction f1, Fraction f2) {
        int[] v = operation(f1, f2);
        return new Fraction(v[0] + (v[1]), v[2]);
    }

    public static Fraction multiply(Fraction f1, Fraction f2) {
        return new Fraction(
                f1.getNumerator() * f2.num,
                f1.getDenominator() * f2.den);
    }

    public static Fraction divide(Fraction f1, Fraction f2) {
        Fraction f3 = new Fraction(f2.getDenominator(), f2.getNumerator());
        return multiply(f1, f3);
    }

    /*
     * Algorithm:
     * Scale both fractions
     * compare equality of numerators
     */
    public static int compareTo(Fraction f1, Fraction f2) {
        int[] v = Fraction.operation(f1, f2);
        return Integer.compare(v[0], v[1]);
    }

    public static boolean greaterThan(Fraction f1, Fraction f2) {
        return compareTo(f1, f2) == 1;
    }

    public static boolean equals(Fraction f1, Fraction f2) {
        return compareTo(f1, f2) == 0;
    }

    public static boolean lessThan(Fraction f1, Fraction f2) {
        return compareTo(f1, f2) == -1;
    }

    // Instance behavior here
    public int compareTo(Fraction f) {
        return compareTo(this, f);
    }

    public boolean greaterThan(Fraction f) {
        return compareTo(this, f) == 1;
    }

    public boolean equals(Fraction f) {
        return compareTo(this, f) == 0;
    }

    public boolean lessThan(Fraction f) {
        return compareTo(this, f) == -1;
    }

    // Getters
    public int getNumerator() {
        return this.num;
    }

    public int getDenominator() {
        return this.den;
    }

    // Setters
    protected void setNumerator(int n) {
        this.num = n;
    }

    /**
     * Note must keep negative sign in the numerator;
     * 1/-5 == -1/5
     * 
     * @param n
     */
    protected void setDenominator(int n) throws ArithmeticException {
        if (n == 0) {
            throw new ArithmeticException();
        }

        if (n < 0) {
            setNumerator(
                    this.num * -1);
            n *= -1;
        }

        this.den = n;
    }

    // Outputs
    public String toString() {
        if (den == 0) {
            return "undefined";
        } else if (this.isWholeNumber()) {
            return "" + (num / den);
        }
        return num + "/" + den;
    }

    // Operations
    public Fraction add(Fraction f) {
        return add(this, f);
    }

    public Fraction subtract(Fraction f) {
        return subtract(this, f);
    }

    public Fraction multiply(Fraction f) {
        return multiply(this, f);
    }

    public Fraction divide(Fraction f) {
        return this.multiply(f.reciprocal());
    }

    public Fraction reciprocal() {
        return new Fraction(this.den, this.num);
    }

    /* 
     * Mutates itself
     */
    protected Fraction update(int num, int den) {
        setNumerator(num);
        setDenominator(den);
        return this;
    }

    protected Fraction update(Fraction f) {
        return this.update(f.num, f.den);
    }

    /**
     * Synchronously updates the numerator and denominator.
     * Can't use the static method as it will cause a stackoveflow.
     */
    public void simplify() {
        int gcd = Fraction.gcd(this.num, this.den);
        this.update(
            this.num / gcd,
            this.den / gcd);
    }

    public static int gcd(int a, int b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
    }

    public boolean isWholeNumber() {
        return num % den == 0;
    }

    public static Fraction valueOf(Number n) {
        int w = n.intValue();
        int d = (int) ((n.floatValue() - w) * 100);
        return new Fraction(d, 100);
    }
}