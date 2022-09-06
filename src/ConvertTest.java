import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConvertTest {

    @Test
    public void shouldInstatiateInts() {
        MixedNumber m = new MixedNumber(1);
        assertEquals("1", m.toString());
    }

    @Test
    public void shouldInstatiateDecimals() {
        MixedNumber m = new MixedNumber(0.75);
        assertEquals("3/4", m.toString());
    }

    @Test
    public void shouldInstatiateMixed() {
        MixedNumber m = new MixedNumber(20.75);
        assertEquals("20 3/4", m.toString());
    }

    @Test
    public void shouldSimplify() {
        MixedNumber m = new MixedNumber(0.75);
        assertEquals("3/4", m.toString());
    }

    @Test
    public void twoArgs() {
        MixedNumber m = new MixedNumber(3, 4);
        assertEquals("3/4", m.toString());
    }

    @Test
    public void upgrade() {
        var a = new Fraction(2, 2);
        MixedNumber m = new MixedNumber(a);
        assertEquals("1", m.toString());
    }

    @Test
    public void threeArgs() {
        MixedNumber m = new MixedNumber(1, 2, 3);
        assertEquals("1 2/3", m.toString());
    }

    @Test
    public void shouldAddAndSimplify() {
        var a = new MixedNumber(3, 4);
        var b = new MixedNumber(1, 4);
        assertEquals("1", a.add(b) .toString());
    }

    @Test
    public void shouldSubtractSafely() {
        var a = new MixedNumber(3, 1,3);
        var b = new MixedNumber(3, 1,3);
        assertEquals("0", a.subtract(b) .toString());
    }
    @Test
    public void threeParam(){
        var a = new MixedNumber(2, 3, 7);
        var b = new MixedNumber(8, 2, 5);
        assertEquals("10 29/35", a.add(b).toString());
    }

    @Test
    public void shouldMultiply() {
        var a = new MixedNumber(3, 4);
        var b = new MixedNumber(1, 4);
        assertEquals("3/16", a.multiply(b).toString());
    }

    @Test
    public void shouldMultiplyMixedAndZero() {
        var a = new MixedNumber(0);
        var b = new MixedNumber(1,2,3);
        assertEquals("0", a.multiply(b).toString());
    }
    @Test
    public void shouldMultiplyMixed() {
        var a = new MixedNumber(3,1, 3);
        var b = new MixedNumber(3,9, 27);
        assertEquals("11 1/9", a.multiply(b).toString());
    }
    @Test
    public void shouldMultiplyMixes() {
        var a = new MixedNumber(3,1, 3);
        var b = new MixedNumber(2,3, 27);
        assertEquals("7 1/27", a.multiply(b).toString());
    }
    @Test 
    public void isConvertible() {
        var a = new MixedNumber(3,1,3);
        assertEquals("10/3", a.asFraction().toString());
    }

    @Test 
    public void fractionSimplifies() {
        var a = new Fraction(9, 3);
        assertEquals("3", a.toString());
    }

    @Test
    public void shouldMultiplyAndSimplify() {
        var a = new MixedNumber(2, 1);
        var b = new MixedNumber(1, 2);
        assertEquals("1", a.multiply(b).toString());
    }

    @Test
    public void shouldDivide() {
        var a = new MixedNumber(1, 2);
        var b = new MixedNumber(1, 2);
        assertEquals("1", a.divide(b).toString());
    }

    @Test
    public void shouldDivideAndSimplify() {
        var a = new MixedNumber(2, 1);
        var b = new MixedNumber(1, 2);
        assertEquals("4", a.divide(b).toString());
    }
}