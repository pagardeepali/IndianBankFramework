import dataDriven.Actions.WebActions;
import dataDriven.utilities.ExtentReporter;
import dataDriven.utilities.ServiceSetup;
import dataDriven.validation.WebValidation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BranchTest extends ServiceSetup {

    WebActions webActions = new WebActions();
    WebValidation webValidation = new WebValidation();

    @BeforeClass
    public void performLogin() {
        ExtentReporter.createTest("Test Case - perform admin login operation");
        webActions.openURL("http://43.241.61.184/indian-bank-pms2/login");
        webActions.maximizePage();
        webActions.performBranchLogin();
        webValidation.validateBranchLoginSuccess();
    }

    @Test
    public void testPrintAndDownloadOperation() {
        waitForSeconds(4);
        webActions.selectMonthFromMonthlyDashboard("November");
        webActions.performBranchPrintOperation();
        webActions.clickPrint();
    }
}