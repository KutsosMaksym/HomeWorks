package HWS.HW9;

import org.testng.annotations.Test;

public class RemoveExtraSymbolsTest {

    @Test
    public void removeSymbols() {
        RemoveExtraSymbols removeExtraSymbols = new RemoveExtraSymbols();
        String initialString = "abcd4efabc123deabcdaaa";
        initialString = removeExtraSymbols.remove(initialString, "a", "d", "3");
        System.out.println(initialString);
    }
}
