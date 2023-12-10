package HWS.HW21.pagesSelenide;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    public void checkout(){
        $("#checkout").click();
    }
}
