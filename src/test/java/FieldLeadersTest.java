import dataDriven.Actions.WebActions;
import dataDriven.utilities.BaseTest;
import dataDriven.utilities.ExtentReporter;
import dataDriven.utilities.ServiceSetup;
import dataDriven.validation.WebValidation;
import org.testng.annotations.Test;

public class FieldLeadersTest extends ServiceSetup {
    WebActions webActions = new WebActions();
    WebValidation webValidation = new WebValidation();

    @Test(priority = 0)
    public void performLogin() {
        ExtentReporter.createTest("Test Case - perform admin login operation");
        webActions.openURL("http://43.241.61.184/indian-bank/login");
        webActions.maximizePage();
        webActions.performFieldLeaderLogin();
        webValidation.validateFieldLeaderLoginSuccess();
    }

    @Test(dataProvider = "getUserDetails", dataProviderClass = TestDataProviders.class)
    public void testFieldLeaders(String userId) {
        webActions.refreshWebPage();
        ExtentReporter.createTest("Test Case - Verify search operation for user " + userId);
        webActions.searchFieldLeaderBySrNo(userId);
        waitForSeconds(4);
    }
}
