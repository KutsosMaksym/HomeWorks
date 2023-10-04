package HWS.HW9;

import org.testng.annotations.Test;

public class ReverseStringTest {

    @Test
    void reverseStr() {
        ReverseString rev = new ReverseString();
        StringBuilder s = new StringBuilder("Java, World!");
        StringBuilder f = new StringBuilder("av");
        System.out.println(rev.reverse(s));
        System.out.println(rev.reverse(f));
    }
}
