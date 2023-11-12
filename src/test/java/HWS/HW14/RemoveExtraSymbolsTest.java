package HWS.HW14;

import HWS.HW9.RemoveExtraSymbols;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class RemoveExtraSymbolsTest extends BaseTest {
    RemoveExtraSymbols removeExtraSymbols = new RemoveExtraSymbols();

    @Test(dataProvider = "initialString", groups = {"RemoveExtraSymbols", "positive"})
    public void checkRemovalSymbols(String initialString) {
        assertEquals("bc4efbc12ebc", removeExtraSymbols.remove(initialString, "a", "d", "3"));
    }

    @DataProvider
    public Object[] initialString() {
        return new Object[]{
                "abcd4efabc123deabcdaaa",
                "bc4efbc12ebc",
        };
    }

    @Test(groups = {"RemoveExtraSymbols", "negative", "empty"})
    public void checkRemovalFromEmptyString() {
        assertEquals("", removeExtraSymbols.remove("", "a", "d", "3"));
    }

    @Test(groups = {"RemoveExtraSymbols", "negative", "null"})
    public void checkRemovalFromNull() {
        assertEquals("", removeExtraSymbols.remove(null, "a", "d", "3"));
    }
}
