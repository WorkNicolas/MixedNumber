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
}
