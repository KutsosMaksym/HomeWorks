package HWS.UtilTest;

import HWS.Util.ConfigLoader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected final String DOWNLOAD_FOLDER_PATH = "target/downloads";
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
        ChromeOptions options = new ChromeOptions(); //setPathDownloadedFiles
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", new File(DOWNLOAD_FOLDER_PATH).getAbsolutePath());
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1440, 1100));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}