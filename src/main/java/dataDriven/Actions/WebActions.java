package dataDriven.Actions;

import dataDriven.locators.CommonLocators;
import dataDriven.utilities.ExtentReporter;
import dataDriven.utilities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebActions extends BaseTest {

    public void openURL(String url) {
        ExtentReporter.logInfo("Open URL " + url);
        driver.get(url);
        ExtentReporter.logPassedTestStep("URL open successfully");
    }


    public void performFieldLeaderLogin() {
        CommonLocators commonLocators = new CommonLocators();
        ExtentReporter.logInfo("perform Field Leader Login ");
        commonLocators.getFieldLeadersUserId().sendKeys("70272");
        commonLocators.getFieldLeadersUserPassword().sendKeys("welcome");
        commonLocators.getFieldLeadersLogin().click();
        ExtentReporter.logPassedTestStep("Field Leader Login successful");
    }

    public void searchFieldLeaderBySrNo(String srNumber) {
        ExtentReporter.logInfo("search field leader by SR No " + srNumber);
        CommonLocators commonLocators = new CommonLocators();
        commonLocators.getFieldLeaderssearchTextBox().sendKeys(srNumber);
        commonLocators.getFieldLeaderssearchButton().click();
    }

    public void performBranchLogin() {
        CommonLocators commonLocators = new CommonLocators();
        ExtentReporter.logInfo("Perform Branch Login");
        commonLocators.getBranchUserId().sendKeys("12345");
        commonLocators.getBranchPassword().sendKeys("welcome");
        commonLocators.getBranchLogin().click();
        ExtentReporter.logPassedTestStep("Branch Login successful");
    }

    public void selectMonthFromMonthlyDashboard(String monthName) {
        CommonLocators commonLocators = new CommonLocators();
        commonLocators.selectMonthFromDropdown(commonLocators.getBranchSelectDropdown(), monthName);
    }

    public void performBranchPrintOperation() {
        CommonLocators commonLocators = new CommonLocators();
        commonLocators.getBranchSelectPrintButton().click();
    }

    public void performCorporateLeaderLogin() {
        CommonLocators commonLocators = new CommonLocators();
        ExtentReporter.logInfo("perform Corporate Leader Login");
        commonLocators.getCorporateLeadersUserId().sendKeys("63262");
        commonLocators.getCorporateLeadersUserPassword().sendKeys("welcome");
        commonLocators.getCorporateLeadersLogin().click();
        ExtentReporter.logPassedTestStep("Corporate Login Successful");
    }

    public void selectMonthFromCorporateDashboard(String monthName) {
        CommonLocators commonLocators = new CommonLocators();
        commonLocators.selectMonthFromDropdown(commonLocators.getCorporateSelectDropdown(), monthName);
    }

    public void refreshWebPage() {
        driver.navigate().refresh();
    }

    public void maximizePage() {
        driver.manage().window().maximize();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentPageURL() {return driver.getCurrentUrl();}

    public void clickPrint()
    {
        CommonLocators commonLocators = new CommonLocators();
        getWindowHandle();

        /*System.out.println("Validate downloads page header text");
       // WebElement root1 = driver.findElement(By.tagName("print-preview-app"));

        //Get shadow root element
        WebElement shadowRoot1 = expandRootElement(commonLocators.getRoot1());
        System.out.println("shadowRoot1");
        WebElement root2 = shadowRoot1.findElement(By.tagName("print-preview-sidebar"));
        WebElement shadowRoot2 = expandRootElement(root2);

        WebElement root3 = shadowRoot1.findElement(By.tagName("print-preview-button-strip"));
        WebElement shadowRoot3 = expandRootElement(root2);


        WebElement root4 = shadowRoot3.findElement(By.cssSelector("div > cr-button.action-button"));

        root4.click();
        System.out.println("test");*/
    }

}