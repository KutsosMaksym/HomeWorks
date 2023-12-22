package HWS.HW19;

import HWS.HW19.pages.ContactUsPage;
import HWS.HW19.pages.MainPage;
import HWS.UtilTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Automationexercise  extends BaseTest {
    @Test
    public void submitContactUsForm(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.openContactUsPage();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.setGetInTouchFields(config.getProperty("name"), config.getProperty("email"), config.getProperty("subject"), config.getProperty("message"));
        contactUsPage.uploadFile(config.getProperty("fileName"));
        contactUsPage.submit();
        contactUsPage.confirmAlert();
        Assert.assertEquals(contactUsPage.getSuccessMessage(),"Success! Your details have been submitted successfully.");
    }
}
