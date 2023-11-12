package HWS.HW14;

import HWS.HW9.RemoveExtraString;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class RemoveExtraStringTest extends BaseTest{
    RemoveExtraString removeExtraSymbols = new RemoveExtraString();

    @Test(dataProvider = "stringSt", groups = {"RemoveExtraString", "positive"})
    public void checkRemovalString(String stringSt) {
        assertEquals("This is the te ring", removeExtraSymbols.remove(stringSt, "st"));
    }

    @DataProvider
    public Object[] stringSt() {
        return new Object[]{
                "This is the test string",
                "stThis is the te ring",
                "This is the te ringst",
                "This is the te ringST",
                "This is the te ring",
        };
    }

    @Test(groups = {"RemoveExtraString", "negative", "empty"})
    public void checkRemoveFromEmptyString() {
        assertEquals("", removeExtraSymbols.remove("", "st"));
    }

    @Test(groups = {"RemoveExtraString", "negative", "null"})
    public void checkRemoveFromNull() {
        assertEquals("", removeExtraSymbols.remove(null, "st"));
    }

    @Test(groups = {"RemoveExtraString", "negative", "empty"})
    public void checkRemoveEmptyString() {
        assertEquals("This is the te ring", removeExtraSymbols.remove("This is the te ring", ""));
    }

    @Test(groups = {"RemoveExtraString", "negative", "null"})
    public void checkRemoveNull() {
        assertEquals("This is the te ring", removeExtraSymbols.remove("This is the te ring", null));
    }
}