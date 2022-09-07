/** 
 * @author San Juan, Jean Carlo
 * @author Mendoza, Carl Nicolas
 * @version 9/6/2022
 * @summary MixedNumber - an object that represents a number composed of an integer and a fraction. It is created by supplying a whole number, a numerator, and a
 *           denominator.
 * 
 * @implNote 
 * A mixed number can be created with the following data combination.
 * <ol>
 *  <li> number - treated as the whole part, the numerator defaults to 0 and denominator defaults to 1.
 *  <li> numbers - treated as numerator and denominator, hence whole defaults to 0.
 *  <li> numbers - treated as whole, numerator and denominator respectively.
 * </ol>
 */
public class MixedNumber extends Fraction {
    protected int whole;

    /*
     * Implements #1
     */
    public MixedNumber(Number w) {
        this.whole = w.intValue();
        float decimal = w.floatValue() - whole;
        this.update(valueOf(decimal));
    }

    /*
     * Implements #2
     */
    public MixedNumber(Number num, Number den) {
        super(num.intValue(), den.intValue());
    }

    /*
     * Implements #3
     */
    public MixedNumber(Number whole, Number num, Number den) {
        this(whole, new Fraction(num, den));
    }

    public int getWhole() {
        return this.whole;
    }

    public MixedNumber(Number whole, Fraction f) {
        this(whole);
        this.update(this.add(f));
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

    public void update(MixedNumber m) {
        super.update(m);
        this.whole = m.whole;
    }
    @Override 
    /* 
     * Consumes and adds the fractional part to 'whole' when it is interpretable as an integer.
     */
    public void simplify() {
        this.whole += num / den; //consume numerator via integer div
        int n = num % den; // store remainder
        int gcd = Fraction.gcd(n, den);
        setDenominator(den / gcd);  
        setNumerator(n / gcd);  
    }

    @Override
    public MixedNumber update(int num, int den) {
        super.update(num, den);
        this.simplify();
        return this;
    }
    // whole number operations
    public MixedNumber add(Number w) {
        return this.add(new MixedNumber(w));
    }

    public MixedNumber subtract(Number w) {
        return this.subtract(new MixedNumber(w));
    }
    public MixedNumber multiply(Number w) {
        return this.multiply(new MixedNumber(w));
    }

    public MixedNumber divide(Number w) {
        return this.divide(new MixedNumber(w));
    }

    // Adds the whole number beside the fractional part
    @Override
    public String toString() {
        if (isWholeNumber()) {
            return "" + (whole + num / den);
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