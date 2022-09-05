import java.math.BigInteger;
import java.util.Scanner;

public class Fraction  {
    protected BigInteger num;
    protected BigInteger dem;
    public static final BigInteger NEGATIVEONE = new BigInteger("-1");

    public static void main(String[] args) {
        if (args.length == 1) {
            if ("class".equals(args[0])) {
                System.out.println("Showing class examples:");
                exampleClass();
            } else if ("instance".equals(args[0])) {
                System.out.println("Showing instance examples:");
                exampleInstance();
            }
            System.exit(0);
        }

        char op = '\0';
        Fraction a = null, b = null, c = null;
        Scanner sc = new Scanner(System.in);
        do {
            if (a == null || b == null) {
                if (a == null) {
                    System.out.print("Enter first fraction (a b): ");
                } else {
                    System.out.print("Enter second fraction (c d): ");
                }
                BigInteger numerator,
                        denominator;
                try {
                    numerator = sc.nextBigInteger();
                    denominator = sc.nextBigInteger();

                    if (denominator.equals(BigInteger.ZERO)) {
                        throw new ArithmeticException();
                    }
                } catch (Exception e) {
                    System.out.println(
                            "Please enter a non-zero digit.");
                    sc.nextLine();
                    continue;
                }
                try {
                    if (a == null) {
                        a = new Fraction(numerator, denominator);
                    } else {
                        b = new Fraction(numerator, denominator);
                    }
                } catch (Exception e) {
                    System.out.println(
                            "this fraction is undefined because it has a zero denominator. Please enter another fraction.");
                    sc.nextLine();
                    continue;
                }
            }
        } while (a == null || b == null);

        do {
            sc.nextLine();
            System.out.print("Enter operation (+-/*<>=): ");
            op = sc.nextLine().strip().charAt(0);
            switch (op) {
                case '+':
                    c = add(a, b);
                    break;
                case '-':
                    c = subtract(a, b);
                    break;
                case '/':
                    c = divide(a, b);
                    break;
                case '*':
                case 'x':
                    c = multiply(a, b);
                    break;
                case '>':
                    System.out.println(a.greaterThan(b));
                    break;
                case '<':
                    System.out.println(a.lessThan(b));
                    break;
                case '=':
                    System.out.println(a.equals(b));
                    break;
                default:
                    op = '\0';
                    System.out.println("Please enter a valid operation using the specified characters");
                    break;
            }

        } while (op == '\0');

        // c only becomes defined if a math operation happened.
        if (c != null) {
            System.out.print(c);
        }

        System.out.print("\nPress enter to continue...");
        sc.nextLine();
        main(args);
    }

    //Constructor
    public Fraction(){}

    // Class behavior here
    public Fraction(BigInteger num, BigInteger dem) throws ArithmeticException {
        if (dem.equals(BigInteger.ZERO)) {
            throw new ArithmeticException();
        }

        this.num = num;
        this.dem = dem;
        this.simplify();
    }

    public static Fraction simplify(Fraction f) {
        BigInteger gcd = f.num.gcd(f.dem);
        BigInteger num = f.num.divide(gcd);
        BigInteger dem = f.dem.divide(gcd);
        return new Fraction(num, dem);
    }

    public static void exampleInstance() {
        BigInteger c = new BigInteger("3");
        BigInteger d = new BigInteger("4");
        Fraction fraction1 = new Fraction(BigInteger.ONE, BigInteger.TWO);
        Fraction fraction2 = new Fraction(c, d);

        fraction1.add(fraction2); // makes the value of fraction1 as 5/4.
        System.out.println("1/2 + 3/4 = " + fraction1);

        fraction1 = new Fraction(BigInteger.ONE, BigInteger.TWO);
        fraction1.subtract(fraction2); // makes the value of fraction1 as -1/4.
        System.out.println("1/2 - 3/4 = " + fraction1);

        fraction1 = new Fraction(BigInteger.ONE, BigInteger.TWO);
        fraction1.multiply(fraction2); // makes the value of fraction1 as 3/8.
        System.out.println("1/2 * 3/4 = " + fraction1);

        fraction1 = new Fraction(BigInteger.ONE, BigInteger.TWO);
        fraction1.divide(fraction2); // makes the value of fraction1 as 2/3.
        System.out.println("1/2 / 3/4 = " + fraction1);

        System.out.println("1/2 compared to 3/4 returns " + fraction1.compareTo(fraction2)); // returns -1
        System.out.println("3/4 compared to 1/2 returns " + fraction2.compareTo(fraction1));// returns 1
    }

    // Class-based operations
    // Prepares two fractions for an add/subtract/comparison operation by providing their scaled equivalents.
    public static BigInteger[] operation(Fraction f1, Fraction f2) {
        BigInteger[] packed = {
                f1.getNumerator().multiply(f2.getDenominator()),
                f2.getNumerator().multiply(f1.getDenominator()),
                f1.getDenominator().multiply(f2.getDenominator())
        };
        return packed;
    }

    public static Fraction subtract(Fraction f1, Fraction f2) {
        BigInteger[] v = operation(f1, f2);

        return new Fraction(v[0].subtract(v[1]), v[2]);
    }

    // Creates a new fraction by adding two existing ones.
    public static Fraction add(Fraction f1, Fraction f2) {
        BigInteger[] v = operation(f1, f2);
        return new Fraction(v[0].add(v[1]), v[2]);
    }

    public static Fraction multiply(Fraction f1, Fraction f2) {
        return new Fraction(
                f1.getNumerator().multiply(f2.num),
                f1.getDenominator().multiply(f2.dem));
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
        BigInteger[] v = Fraction.operation(f1, f2);
        return v[0].compareTo(v[1]);
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
    public BigInteger getNumerator() {
        return this.num;
    }

    public BigInteger getDenominator() {
        return this.dem;
    }

    // Setters
    private void setNumerator(BigInteger n) {
        this.num = n;
    }

    /**
     * Note must keep negative sign in the numerator;
     * 1/-5 == -1/5
     * @param n
     */
    private void setDenominator(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            throw new ArithmeticException();
        }

        if (n.compareTo(BigInteger.ZERO) == -1) {
            setNumerator(
                this.num.multiply(NEGATIVEONE)
            );
            n = n.multiply(NEGATIVEONE);
        }

        this.dem = n;
    }

    // Outputs
    public String toString() {
        if (dem.equals(BigInteger.ZERO)) {
            return "undefined";
        } else if (num.equals(dem)) {
            return "1";
        } else if (dem.equals(BigInteger.ONE)) {
            return num.toString();
        } 

        return num + "/" + dem;
    }

    public static void exampleClass() {
        BigInteger c = new BigInteger("3");
        BigInteger d = new BigInteger("4");

        Fraction fraction1 = new Fraction(BigInteger.ONE, BigInteger.TWO);
        Fraction fraction2 = new Fraction(c, d);
        Fraction fractionSum = Fraction.add(fraction1, fraction2); // creates 5/4.
        Fraction fractionDifference = Fraction.subtract(fraction1, fraction2); // creates 1/4.
        Fraction fractionProduct = Fraction.multiply(fraction1, fraction2); // creates 3/8.
        Fraction fractionQuotient = Fraction.divide(fraction1, fraction2); // creates 2/3.

        System.out.println("1/2 + 3/4 = " + fractionSum);
        System.out.println("1/2 - 3/4 = " + fractionDifference);
        System.out.println("1/2 * 3/4 = " + fractionProduct);
        System.out.println("1/2 / 3/4 = " + fractionQuotient);
        System.out.println("1/2 > 3/4 is " + Fraction.greaterThan(fraction1, fraction2)); // prints false
        System.out.println("1/2 < 3/4 is " + Fraction.lessThan(fraction1, fraction2)); // prints true
        System.out.println("1/2 = 3/4 is " + Fraction.equals(fraction1, fraction2)); // prints false
    }

    // Operations
    public void add(Fraction f) {
        this.update(add(this, f));
    }

    public void subtract(Fraction f) {
        this.update(subtract(this, f));
    }

    public void multiply(Fraction f) {
        this.update(multiply(this, f));
    }

    public void divide(Fraction f) {
        this.multiply(f.reciprocal());
    }

    public Fraction reciprocal() {
        return new Fraction(this.dem, this.num);
    }

    private void update(BigInteger num, BigInteger dem) {
        setNumerator(num);
        setDenominator(dem);
        simplify();
    }

    private void update(Fraction f) {
        this.update(f.num, f.dem);
    }

    /**
     * Synchronously updates the numerator and denominator.
     * Can't use the static method as it will cause a stackoveflow.
     */
    public void simplify() {
        BigInteger gcd = this.num.gcd(this.dem);
        this.update(
            this.num.divide(gcd),
            this.dem.divide(gcd)
        );
    }
}