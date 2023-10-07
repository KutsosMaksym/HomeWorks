package HWS.HW9;

import org.testng.annotations.Test;

public class PhoneValidatorTest {
    @Test
    public void checkIsPhoneValid() {
        String validPhone = "+38(097)9388711";
        String invalidPhone = "+38(097)93A8711";
        System.out.println(validPhone + " is valid: " + PhoneValidator.isPhoneValid(validPhone));
        System.out.println(invalidPhone + " is valid: " + PhoneValidator.isPhoneValid(invalidPhone));
    }
}
