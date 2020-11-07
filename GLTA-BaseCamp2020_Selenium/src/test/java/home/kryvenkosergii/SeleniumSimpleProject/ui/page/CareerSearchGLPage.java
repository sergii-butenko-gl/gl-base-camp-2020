package home.kryvenkosergii.SeleniumSimpleProject.ui.page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CareerSearchGLPage {
    //
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private WebDriver driver;
    protected WebDriverWait wait;
    //
    private List<WebElement> results;
    //
    private By selectorForFieldsOfResults = By
            .cssSelector("div[class*='career-searchpage'] div[class='row'] div.only-mobile-view+div div.row+div");
    private By selectorForNeededResult = By.className("mb-0");
    private By selectorForNumberOfFoundResults = By.tagName("h5");

    /**
     * CareerSearchGLPage constructor.
     * @param driver WebDriver
     */
    public CareerSearchGLPage(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 8);
        this.driver = driver;
    }

    // Functional
    private boolean waitUntilPresenceOfElement(By selector) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(selector));
            return true;
        } catch (Exception e) {
            System.out.println("Element doesn't displayed; " + e.getMessage());
            return false;
        }
    }

    private void scrollToElement() {
        waitUntilPresenceOfElement(selectorForNumberOfFoundResults);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(selectorForNumberOfFoundResults));
    }

    public String getTextOfResultByNumberInListResults(int number) {
        logger.debug("start openResultByNumberAndGetPackageHeaderName()");
        logger.trace("get the needed result's text on number " + number);
        logger.info(this.getClass().getSimpleName());
        waitUntilPresenceOfElement(selectorForNumberOfFoundResults);
        int attempts = 0;
        do {
            this.results = driver.findElements(selectorForFieldsOfResults);
            if (results.size() >= number) {
            }
            attempts++;
        } while (results.size() == 0 && attempts < 2);
        if (results.size() >= number) {
            scrollToElement();
            return results.get(number - 1).findElement(selectorForNeededResult).getText();
        }
        return "wrong number";
    }
}
