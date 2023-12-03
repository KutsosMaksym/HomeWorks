package HWS.HW19.pages;

import HWS.HW19.componentes.HeaderComponent;
import HWS.globalPages.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class ContactUsPage extends BasePage {
    HeaderComponent headerComponent;

    public ContactUsPage(WebDriver driver) {
        super(driver);
        this.headerComponent = new HeaderComponent(driver);
    }

    public void setName(String name) {
        setText(driver.findElement(By.name("name")), name);
    }

    public void setEmail(String email) {
        setText(driver.findElement(By.name("email")), email);
    }

    public void setSubject(String subject) {
        setText(driver.findElement(By.name("subject")), subject);
    }

    public void setMessage(String message) {
        setText(driver.findElement(By.name("message")), message);
    }

    public void setGetInTouchFields(String name, String email, String subject, String message) {
        setName(name);
        setEmail(email);
        setSubject(subject);
        setMessage(message);
    }

    public void uploadFile(String fileName) {
        URL url = getClass().getClassLoader().getResource(fileName);
        if (url == null) throw new IllegalArgumentException("file not found");
        File file;
        try {
            file = new File(url.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        WebElement input = driver.findElement(By.name("upload_file"));
        input.sendKeys(file.getAbsolutePath());
    }

    public void submit() {
        clickButton(driver.findElement(By.name("submit")));
    }

    public void confirmAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public String getSuccessMessage(){
        return driver.findElement(By.xpath("//div[@class='status alert alert-success']")).getText();
    }
}
