package HWS.HW9;

import org.testng.annotations.Test;

public class RemoveExtraStringTest {

    @Test
    public void removingString(){
        RemoveExtraString removeExtraSymbols = new RemoveExtraString();
        String s = "This is the test string";
        System.out.println(removeExtraSymbols.remove(s, "st"));
    }
}
