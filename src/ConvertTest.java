import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConvertTest {

    @Test
    public void shouldInstatiateInts() {
        MixedNumber m = new MixedNumber(1);
        var s = m.toString();
        assertEquals("1", s);
    }

    @Test
    public void shouldInstatiateDecimals() {
        MixedNumber m = new MixedNumber(0.75);
        var s = m.toString();
        assertEquals("3/4", s);
    }

    @Test
    public void shouldInstatiateMixed() {
        MixedNumber m = new MixedNumber(20.75);
        var s = m.toString();
        assertEquals("20 3/4", s);
    }

    @Test
    public void shouldSimplify() {
        MixedNumber m = new MixedNumber(0.75);
        var s = m.toString();
        assertEquals("3/4", s);
    }

    @Test
    public void twoArgs() {
        MixedNumber m = new MixedNumber(3, 4);
        var s = m.toString();
        assertEquals("3/4", s);
    }

    @Test
    public void threeArgs() {
        MixedNumber m = new MixedNumber(1, 2, 3);
        var s = m.toString();
        assertEquals("1 2/3", s);
    }

    @Test
    public void shouldAddAndSimplify() {
        var m1 = new MixedNumber(3, 4);
        var m2 = new MixedNumber(1, 4);
        m1.add(m2);
        assertEquals("1", m1.toString());
    }

    @Test
    public void threeParam(){
        var m1 = new MixedNumber(3, 1, 3);
        var m2 = new MixedNumber(3, 1, 3);
        m1.add(m2);
        assertEquals("6 2/3", m1.toString());
    }
}
