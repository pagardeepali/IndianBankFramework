import dataDriven.Actions.WebActions;
import dataDriven.utilities.ExtentReporter;
import dataDriven.utilities.ServiceSetup;
import dataDriven.validation.WebValidation;
import org.testng.annotations.Test;

public class CorporateLeadersTest extends ServiceSetup {

    WebActions webActions = new WebActions();
    WebValidation webValidation = new WebValidation();

    @Test(priority = 0)
    public void performCorporateLogin() {
        ExtentReporter.createTest("Test Case - perform admin login operation");
        webActions.openURL("http://43.241.61.184/indian-bank-pms3/login");
        webActions.maximizePage();
        webActions.performCorporateLeaderLogin();
        waitForSeconds(4);
    }

    @Test
    public void performDropdownPrintDownloadOperation(){
        webActions.selectMonthFromCorporateDashboard("November");
        waitForSeconds(5);
    }
}