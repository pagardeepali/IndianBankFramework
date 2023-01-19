package dataDriven.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {


    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public static ExtentSparkReporter extentSparkReporter;

    public static void logInfo(String info) {
        extentTest.log(Status.INFO, info);
    }

    public static void logPassedTestStep(String info) {
        extentTest.log(Status.PASS, info);
    }

    public static void logFailedTestStep(String info) {
        extentTest.log(Status.FAIL, info);
    }

    public static void logSkippedTestStep(String info) {
        extentTest.log(Status.SKIP, info);
    }

    public static void createTest(String testName) {
        extentTest = extentReports.createTest(testName);
    }

    public static void addScreenshotInReport() {
        try {
            String ScreenshotPath = BaseTest.takeScreenshot();
            extentTest.addScreenCaptureFromPath(ScreenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startExtentReport() {
        extentSparkReporter = new ExtentSparkReporter("./ExtentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
    }

    public static void flushReport() {
        extentReports.flush();
    }
}
