import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FractionTests {
    /* 
    * Based on the requirments in ITE-012
    */
    @Test
    public void canvas() {
        int c = 3;
        int d = 4;

        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(c, d);
        assertEquals("5/4", a.add(b).toString());
        assertEquals("-1/4", a.subtract(b).toString());
        assertEquals("3/8", a.multiply(b).toString());
        assertEquals("2/3", a.divide(b).toString());
        assertEquals(false, Fraction.greaterThan(a, b)); // prints false
        assertEquals(true, Fraction.lessThan(a, b)); // prints true
        assertEquals(false, Fraction.equals(a, b)); // prints false
    }
}
