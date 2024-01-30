package HWS.Helper;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getInstanceName() + "." + result.getName() + " test is passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getInstanceName() + "." + result.getName() + " test is failed " + result.getThrowable().getMessage());
    }
}
