package dataDriven.locators;

import dataDriven.utilities.BaseTest;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Getter
public class CommonLocators extends BaseTest {

    private WebDriver driver;

    public CommonLocators() {
        this.driver = BaseTest.driver;
        PageFactory.initElements(driver, this);
    }

    //for field url
    @FindBy(xpath = "//input[@id='loginid']")
    private WebElement fieldLeadersUserId;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement fieldLeadersUserPassword;

    @FindBy(xpath = "//input[@id='loginForm']")
    private WebElement fieldLeadersLogin;

    @FindBy(xpath = "//div[@class='dropdown user-info']")
    private WebElement userInfo;

    @FindBy(id = "sr_number1")
    private WebElement fieldLeaderssearchTextBox;

    @FindBy(id = "searchbtn")
    private WebElement fieldLeaderssearchButton;
    //for branch url
    @FindBy(id = "loginid")
    private WebElement branchUserId;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement branchPassword;

    @FindBy(id = "loginForm")
    private WebElement branchLogin;

    @FindBy(xpath = "//div[@class='emp-dashboard']/div[1]/h5")
    private WebElement branchuserDetails;

    @FindBy(css = "#monthlyData")
    private WebElement branchSelectDropdown;

    @FindBy(xpath = "//a[text()='Print']")
    private WebElement branchSelectPrintButton;

    //for corporate url
    @FindBy(name = "loginid")
    private WebElement corporateLeadersUserId;

    @FindBy(name = "password")
    private WebElement corporateLeadersUserPassword;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement corporateLeadersLogin;

    @FindBy(xpath = "//div[@class='emp-dashboard'']/div[1]/h5")
    private WebElement corporateUserDetails;

    @FindBy(xpath = "//select[@id='monthlyData']")
    private WebElement corporateSelectDropdown;

    @FindBy(tagName = "print-preview-app")
    private WebElement root1;
}
