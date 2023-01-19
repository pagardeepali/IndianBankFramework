package dataDriven.validation;

import dataDriven.locators.CommonLocators;
import dataDriven.utilities.BaseTest;
import dataDriven.utilities.ExtentReporter;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebValidation {

    public static void verifyPageTitleShouldNotNull(String pageTitle) {
        ExtentReporter.logInfo("Validate page title should not be Null");
        Assert.assertNotNull(pageTitle);
        ExtentReporter.logPassedTestStep("Page title is display successfully");
    }

    public void validateElementIsDisplay(WebElement element) {
        ExtentReporter.logInfo("Validate element is display");
        Assert.assertTrue(BaseTest.isElementDisplay(element));
    }

    public void validateFieldLeaderLoginSuccess() {
        ExtentReporter.logInfo("validate field leader login success");
        CommonLocators commonLocators = new CommonLocators();
        Assert.assertTrue(BaseTest.isElementDisplay(commonLocators.getUserInfo()));
    }

    public void validateBranchLoginSuccess() {
        ExtentReporter.logInfo("validate Branch login success");
        CommonLocators commonLocators = new CommonLocators();
        Assert.assertTrue(BaseTest.isElementDisplay(commonLocators.getBranchuserDetails()));
    }

    public void validateCorporateLoginSuccess() {
        ExtentReporter.logInfo("validate corporate login success");
        CommonLocators commonLocators = new CommonLocators();
        Assert.assertTrue(BaseTest.isElementDisplay(commonLocators.getCorporateLeadersLogin()));

    }
}
