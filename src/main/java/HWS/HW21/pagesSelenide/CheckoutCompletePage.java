package HWS.HW21.pagesSelenide;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePage {
    public void backHome() {
    $("#back-to-products").click();
    }

    public String getTitle() {
        return $(".title").getText();
    }

}
