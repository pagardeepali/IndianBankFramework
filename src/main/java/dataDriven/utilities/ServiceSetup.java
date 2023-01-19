package dataDriven.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class ServiceSetup extends BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void launchBrowser() {
        ExtentReporter.startExtentReport();
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeoptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite(alwaysRun = true)
    public void teardown() {
        driver.quit();
        ExtentReporter.flushReport();
    }
}