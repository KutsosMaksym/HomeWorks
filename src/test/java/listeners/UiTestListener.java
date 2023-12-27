package listeners;

import HWS.UtilTest.WebDriverProvider;
import HWS.Utils.ScreenshotHelper;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class UiTestListener implements ITestListener {
    private static final Logger logger = LoggerFactory.getLogger(UiTestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed successfully: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test failed: " + result.getMethod().getMethodName());
        WebDriver driver = WebDriverProvider.getDriver();
        if (driver != null) {
            String screenshotPath = ScreenshotHelper.takeScreenshot(driver, result.getMethod().getMethodName());
            logger.error("Screenshot taken: " + screenshotPath);
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("Test skipped: " + result.getMethod().getMethodName());
    }

}
