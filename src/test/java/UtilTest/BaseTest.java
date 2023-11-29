package UtilTest;

import HWS.Util.ConfigLoader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public ConfigLoader config;

    @BeforeClass(alwaysRun = true)
    public void beforeClass(ITestContext context) {
        String className = this.getClass().getSimpleName();
        System.out.println(className + " tests are started");
        String environment = System.getProperty("env","dev");
        config = new ConfigLoader(environment);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        String className = this.getClass().getSimpleName();
        System.out.println(className + " tests are finished");
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1440, 1100));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}