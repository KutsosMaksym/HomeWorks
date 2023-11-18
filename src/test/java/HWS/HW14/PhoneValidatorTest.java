package HWS.HW14;

import HWS.HW9.PhoneValidator;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class PhoneValidatorTest extends BaseTest14 {

    @Test(dataProvider = "validPhones", groups = {"PhoneValidator", "positive"})
    void checkValidPhones(String validPhone) {
        assertTrue(PhoneValidator.isPhoneValid(validPhone));
    }

    @DataProvider
    public Object[] validPhones() {
        return new Object[]{
                "+38(097)9388711",
                "+38(000)0000000",
                "+38(099)9999999",
        };
    }

    @Test(dataProvider = "invalidPhone", groups = {"PhoneValidator", "negative"})
    void checkInvalidPhones(String invalidPhone) {
        assertFalse(PhoneValidator.isPhoneValid(invalidPhone));
    }

    @DataProvider
    public Object[] invalidPhone() {
        return new Object[]{
                "+380979388711",
                "38(000)0000000",
                "+38(09)99999999",
                "+380(97)9388711",
                "+38(097)938871",
                "+38(097)93887112",
                "+3(099)89999999",
                "+3(8099)9999999"
        };
    }

    @Test(dataProvider = "emptyPhones", groups = {"PhoneValidator", "negative", "empty", "null"})
    void checkEmptyPhones(String emptyPhones) {
        assertFalse(PhoneValidator.isPhoneValid(emptyPhones));
    }

    @DataProvider
    public Object[] emptyPhones() {
        return new Object[]{
                "",
                null
        };
    }
}