/* 
 * 
 * Issues: 
 * Convert decimal to Fraction
 * When the fraction can be interpreted as a whole number, its value should be moved to the 'whole' field.
 * Requirements:
 * A mixed number can be created with the following data combination.
    1. 1 number - treated as the whole part, the numerator defaults to 0 and denominator defaults to 1
    2. 2 numbers - treated as numerator and denominator, hence whole defaults to 0
    3. 3 numbers - treated as whole, numerator and denominator respectively.


    Convert
 */
public class MixedNumber extends Fraction {
    protected int whole = 0;
    protected double decimal;

    /*
     * #1
     */
    public MixedNumber(Number w) {
        this.whole = w.intValue();
        float decimal = w.floatValue() - whole;
        var f = decimalToFraction(decimal);
        this.update(f);
    }

    public MixedNumber(long num, long den) {
        super();

    }

    // get whole number from float
    protected static int getWhole(float decimal) {
        return (int) decimal;
    }

    private int getWhole(MixedNumber mn) {
        return this.whole;
    }

    // Decimal to Fraction
    public Fraction decimalToFraction(float decimal) {
        var w = getWhole(decimal);
        int d = (int) ((decimal - w) * 100);
        return new Fraction(d, 100);
    }

    // MixedNumber
    public MixedNumber(int whole, Fraction f) {
        this(f);
    }

    public MixedNumber(Fraction f) {
        this.update(f.den, f.num);
    }

    // With fractions
    /*
     * 1 1/2 + 1/2 = 2
     * MixedNumber mixedNumber = new MixedNumber(int whole,int num,int den)
     */
    public void add(MixedNumber m) {
        // this.whole
    }

    // whole
    public void subtract(MixedNumber m) {
        this.whole -= m.whole;

    }

    // whole number operations
    public int add(int whole) {
        this.whole += whole;
        return whole;
    }

    // Adds the whole number beside the fractional part
    //public MixedNumber 
    @Override
    public String toString() {
        if (isOne()) {
            return "" + (whole + 1);
        } else if (isWholeNumber()) {
            return "" + (whole + num);
        }
        if (whole == 0) {
            return super.toString();
        }
        return whole + " " + super.toString();
    }

    public static void main(String[] args) {
        MixedNumber m = new MixedNumber(20.75);
        System.out.println(m);
    }
}