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

    /*
     * #1
     */
    public MixedNumber(Number w) {
        this.whole = w.intValue();
        float decimal = w.floatValue() - whole;
        var f = decimalToFraction(decimal);
        this.update(f);
    }

    public MixedNumber(Number num, Number den) {
        super();
        this.update(num.intValue(), den.intValue());
    }

    public MixedNumber(Number whole, Number num, Number den) {
        this(whole);
        this.add(new Fraction(num.intValue(), den.intValue()));
    }

    // get whole number from float
    protected static int getWhole(float decimal) {
        return (int) decimal;
    }

    public int getWhole(MixedNumber mn) {
        return this.whole;
    }

    // get num and den from mn
    /*
     * private int getNum(MixedNumber m) {
     * 
     * }
     */

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
    public MixedNumber add(MixedNumber m) {
        super.add(m);
        this.whole += m.whole;
        return this;
    }

    public MixedNumber subtract(MixedNumber m) {
        super.subtract(m);
        this.whole -= m.whole;
        return this;
    }

    public MixedNumber multiply(MixedNumber m) {
        super.multiply(m);
        this.whole *= m.whole;
        return this;
    }

    
    public MixedNumber divide(MixedNumber m) {
        super.divide(m);
        if (m.whole != 0)
            this.whole /= m.whole;
        return this;
    }

    @Override 
    /* 
     * Consumes and adds the fractional part to 'whole' when it is interpretable as an integer.
     */
    public void simplify() {
        if (isWholeNumber()) {
            if (this.isOne()) {
                this.whole++;
            } else {
                this.whole += this.num;
            }
            this.update(new Fraction());
            return;
        }
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
        MixedNumber m = new MixedNumber(3, 4);
        System.out.println(m);
    }
}