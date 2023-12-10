package HWS.HW21.pagesSelenide;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutStep1Page {
    public void setPersonalInfo(String firstName, String lastName, String zipCode) {
        setFirstName(firstName);
        setLastName(lastName);
        setZipCode(zipCode);
    }

    private void setZipCode(String zipCode) {
        $("#postal-code").setValue(zipCode);
    }

    private void setLastName(String lastName) {
        $("#last-name").setValue(lastName);
    }

    private void setFirstName(String firstName) {
        $("#first-name").setValue(firstName);
    }

    public void continueCheckout() {
        $("#continue").click();
    }
}
