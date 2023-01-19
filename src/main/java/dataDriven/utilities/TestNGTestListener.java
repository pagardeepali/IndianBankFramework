package dataDriven.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static dataDriven.utilities.BaseTest.driver;

public class TestNGTestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReporter.logFailedTestStep(result.getName() + " is failed.Refer the above screenshot.");
        ExtentReporter.addScreenshotInReport();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReporter.logPassedTestStep(result.getName() + " is Passed.Refer the above screenshot.");
        ExtentReporter.addScreenshotInReport();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReporter.logSkippedTestStep(result.getName() + " is skipped.");
    }

    @Override
    public void onFinish(ITestContext context)
    {
        driver.quit();
    }
}
