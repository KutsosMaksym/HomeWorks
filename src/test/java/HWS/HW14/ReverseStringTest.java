package HWS.HW14;


import HWS.HW9.ReverseString;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class ReverseStringTest extends BaseTest14 {
    ReverseString rev = new ReverseString();

    @Test (groups = {"ReverseString", "positive"})
    public void checkReverseString() {
        assertEquals("!dlroW ,avaJ", rev.reverse(new StringBuilder("Java, World!")));
    }

    @Test (groups = {"ReverseString", "negative"})
    public void checkReverseSymbol() {
        assertEquals("F", rev.reverse(new StringBuilder("F")));
    }

    @Test (groups = {"ReverseString", "negative", "empty"})
    public void checkReverseEmptyString() {
        assertEquals("", rev.reverse(new StringBuilder("")));
    }

    @Test (groups = {"ReverseString", "negative", "null"})
    public void checkReverseNullString() {
        assertEquals("", rev.reverse(null));
    }
}
