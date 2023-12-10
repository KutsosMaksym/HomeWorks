package HWS.HW21.pagesSelenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CheckoutStep2Page {
    public void finish() {
        $("#finish").click();
    }
    public String getFirstItemTitle (){
        return $(".inventory_item_name").getText();
    }
    public String getTotalPrice(){
        return $x("//div[@class='summary_subtotal_label']").getText();
    }

}
