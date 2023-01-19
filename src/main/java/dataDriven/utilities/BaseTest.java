package dataDriven.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BaseTest {
    public static WebDriver driver;


    /**
     * @return it returns screenshot file path.
     */
    public static String takeScreenshot() {
        String filePath = null;
        try {
            filePath = "./ScreenShotsTest/" + getDateTime() + ".png";
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }

    /**
     * @return it return result in DDMMYY_HHMMSS format i.e.02032022_140649
     */
    public static String getDateTime() {
        String dateTimeValue = null;
        try {
            DateTimeFormatter dtf = null;
            LocalDateTime now = null;
            dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            now = LocalDateTime.now();
            dateTimeValue = dtf.format(now).toString().replaceAll("/", "").replaceAll(":", "").replaceAll(" ", "_");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateTimeValue;
    }

    public static void scrollToElementAndClick(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
        waitForSeconds(2);
        element.click();
    }

    public static void clickOnElement(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", element);
    }

    public void getWindowHandle() {
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            System.out.println("ChildWindow: " + ChildWindow);
            waitForSeconds(3);
            driver.switchTo().window(ChildWindow);
        }
        //System.out.println(driver.findElement(By.xpath("//html")).getText());



        /*while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            System.out.println("ChildWindow: "+ChildWindow);
            waitForSeconds(3);
            driver.switchTo().window(ChildWindow);

            if (driver.findElements(By.xpath("//print-preview-app")).size()>0) {
                List<WebElement> list= driver.findElements(By.xpath("//print-preview-app"));
                System.out.println(list);
                System.out.println(list.size());
                break;

//                System.out.println(" head val"+driver.findElement(By.xpath("//print-preview-app")).getText());
            }

        }*/
    }

    public static boolean isElementDisplay(WebElement element) {
        boolean value = false;
        try {
            element.isDisplayed();
            value = true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void waitForSeconds(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectMonthFromDropdown(WebElement element, String visibletext) {
        Select select = new Select(element);
        select.selectByVisibleText(visibletext);
    }

    public WebElement expandRootElement(WebElement element) {
        JavascriptExecutor JS = (JavascriptExecutor) driver;
        WebElement shadowDom = (WebElement) JS.executeScript("return arguments[0].shadowRoot", element);

        return shadowDom;
    }
}
