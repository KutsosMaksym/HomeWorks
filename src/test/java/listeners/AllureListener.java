package listeners;

import HWS.UtilTest.WebDriverProvider;
import io.qameta.allure.Attachment;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AllureListener implements TestLifecycleListener {
    @Override
    public void beforeTestStop(TestResult result) {
        if (result.getStatus() == Status.FAILED || result.getStatus() == Status.BROKEN) {
            if (WebDriverProvider.getDriver() != null) {
                makeScreenshotOnFailure(WebDriverProvider.getDriver());
            }
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] makeScreenshotOnFailure(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}