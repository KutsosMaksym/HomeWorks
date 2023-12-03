package HWS.HW20.pages;

import HWS.globalPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DownloadPage extends BasePage {
    public DownloadPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/download");
    }

    public void downloadFile(String fileName) {
        clickButton(driver.findElement(By.xpath("//a[@href='download/" + fileName + "']")));
    }


}
