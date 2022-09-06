import java.util.Scanner;

/**
 * @author San Juan, Jean Carlo
 * @author San Juan, John Rexcel
 * @author Santos, Johan
 * @version 5/31/2022
 * @category Assignment
 *           {@summary} Runner class for a Fraction
 * @implNote it is extended to simplify calls
 */
public class FractionRunner extends Fraction {
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
                int numerator,
                        denominator;
                try {
                    numerator = sc.nextInt();
                    denominator = sc.nextInt();

                    if (denominator == 0) {
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

    public static void exampleClass() {
        int c = 3;
        int d = 4;

        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(c, d);
        Fraction fractionSum = Fraction.add(fraction1, fraction2); // creates 5/4.
        Fraction fractionDifference = Fraction.subtract(fraction1, fraction2); // creates -1/4.
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

    public static void exampleInstance() {
        int c = 3;
        int d = 4;
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(c, d);

        fraction1.add(fraction2); // makes the value of fraction1 as 5/4.
        System.out.println("1/2 + 3/4 = " + fraction1);

        fraction1 = new Fraction(1, 2);
        fraction1.subtract(fraction2); // makes the value of fraction1 as -1/4.
        System.out.println("1/2 - 3/4 = " + fraction1);

        fraction1 = new Fraction(1, 2);
        fraction1.multiply(fraction2); // makes the value of fraction1 as 3/8.
        System.out.println("1/2 * 3/4 = " + fraction1);

        fraction1 = new Fraction(1, 2);
        fraction1.divide(fraction2); // makes the value of fraction1 as 2/3.
        System.out.println("1/2 / 3/4 = " + fraction1);

        System.out.println("1/2 compared to 3/4 returns " + fraction1.compareTo(fraction2)); // returns -1
        System.out.println("3/4 compared to 1/2 returns " + fraction2.compareTo(fraction1));// returns 1
    }
}
