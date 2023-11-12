package HWS.HW14;

import HWS.TestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class BaseTest {

    @BeforeClass (alwaysRun = true)
    public void beforeClass(ITestContext context) {
        String className = this.getClass().getSimpleName();
        System.out.println(className + " tests are started");
    }

    @AfterClass (alwaysRun = true)
    public void afterClass() {
        String className = this.getClass().getSimpleName();
        System.out.println(className + " tests are finished");
    }

    @BeforeMethod (alwaysRun = true)
    public void beforeTestMethod(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        System.out.println("Before method for test: " + testName);
    }

    @AfterMethod (alwaysRun = true)
    public void afterTestMethod(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        System.out.println("After method for test: " + testName);
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Test failed!");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println("Test passed!");
        }
    }
}
