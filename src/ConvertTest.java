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
    public void threeArgs() {
        MixedNumber m = new MixedNumber(1, 2, 3);
        assertEquals("1 2/3", m.toString());
    }

    @Test
    public void shouldAddAndSimplify() {
        var a = new MixedNumber(3, 4);
        var b = new MixedNumber(1, 4);
        a.add(b);
        assertEquals("1", a.toString());
    }

    @Test
    public void shouldSubtractSafely() {
        var a = new MixedNumber(3, 1,3);
        var b = new MixedNumber(3, 1,3);
        a.subtract(b);
        assertEquals("0", a.toString());
    }
    @Test
    public void threeParam(){
        var m1 = new MixedNumber(2, 3, 7);
        var m2 = new MixedNumber(8, 2, 5);
        m1.add(m2);
        assertEquals("10 29/35", m1.toString());
    }

    @Test
    public void shouldMultiply() {
        var a = new MixedNumber(3, 4);
        var b = new MixedNumber(1, 4);
        a.multiply(b);
        assertEquals("3/16", a.toString());
    }

    @Test
    public void shouldMultiplyAndSimplify() {
        var a = new MixedNumber(2, 1);
        var b = new MixedNumber(1, 2);
        a.multiply(b);
        assertEquals("1", a.toString());
    }

    @Test
    public void shouldDivide() {
        var a = new MixedNumber(1, 2);
        var b = new MixedNumber(1, 2);
        a.divide(b);
        assertEquals("1", a.toString());
    }

    @Test
    public void shouldDivideAndSimplify() {
        var a = new MixedNumber(2, 1);
        var b = new MixedNumber(1, 2);
        a.divide(b);
        assertEquals("4", a.toString());
    }
}