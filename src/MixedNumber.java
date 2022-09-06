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

 */
public class MixedNumber extends Fraction {
    protected int whole = 0;

    /*
     * Implements #1
     */
    public MixedNumber(Number w) {
        this.whole = w.intValue();
        float decimal = w.floatValue() - whole;
        var f = decimalToFraction(decimal);
        this.update(f);
    }

    /*
     * Implements #2
     */
    public MixedNumber(Number num, Number den) {
        this.update(num.intValue(), den.intValue());
    }

    /*
     * Implements #3
     */
    public MixedNumber(Number whole, Number num, Number den) {
        this(num, den);
        this.whole = whole.intValue();
    }

    // get whole number from float
    protected static int getWhole(float decimal) {
        return (int) decimal;
    }

    public int getWhole(MixedNumber mn) {
        return this.whole;
    }

    // Decimal to Fraction
    public Fraction decimalToFraction(float decimal) {
        var w = getWhole(decimal);
        int d = (int) ((decimal - w) * 100);
        return new Fraction(d, 100);
    }

    public MixedNumber(int whole, Fraction f) {
        this(whole);
        this.update(f);
    }

    public MixedNumber(Fraction f) {
        this.update(f.num, f.den);
    }

    // With fractions
    /*
     * 1 1/2 + 1/2 = 2
     * MixedNumber mixedNumber = new MixedNumber(int whole,int num,int den)
     */
    public MixedNumber add(MixedNumber m) {
        return new MixedNumber(
            this.whole + m.whole,
            super.add(m)
        );
    }

    public MixedNumber subtract(MixedNumber m) {
        return new MixedNumber(
            this.whole - m.whole,
            super.subtract(m)
        );
    }
    public Fraction asFraction() {
        return new Fraction(whole * den + num, den);
    }
    public MixedNumber multiply(MixedNumber m) {
        var a = this.asFraction();
        var b = m.asFraction();
        return new MixedNumber(a.multiply(b));
    }
    
    public MixedNumber divide(MixedNumber m) {
        var a = this.asFraction();
        var b = m.asFraction();
        return new MixedNumber(a.divide(b));
    }

    @Override 
    /* 
     * Consumes and adds the fractional part to 'whole' when it is interpretable as an integer.
     */
    public void simplify() {
        this.whole += num / den;
        this.num = num % den;
    }

    @Override
    public MixedNumber update(int num, int den) {
        super.update(num, den);
        this.simplify();
        return this;
    }
    // whole number operations
    public Fraction add(int whole) {
        this.whole += whole;
        return this;
    }

    // Adds the whole number beside the fractional part
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
        MixedNumber m = new MixedNumber(0.3);
        System.out.println(m);
    }
}