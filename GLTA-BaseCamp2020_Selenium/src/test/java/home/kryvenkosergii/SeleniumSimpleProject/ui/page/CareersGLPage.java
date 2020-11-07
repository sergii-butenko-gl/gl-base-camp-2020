package home.kryvenkosergii.SeleniumSimpleProject.ui.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareersGLPage extends BaseSearchPage {
    //
    private By selectorForCookies = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");

    /**
     * MainGooglePage constructor.
     * @param driver WebDriver
     */
    public CareersGLPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    /**
     * Initialize web elements
     */
    private void initElements() {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        closeCookies();
        //
        this.selectorForSearchField = By.id("by_keyword");
    }

    // Functional
    private void closeCookies() {
        logger.debug("start closeCookies()");
        logger.trace("close Cookies");
        logger.info(this.getClass().getSimpleName());
        if (waitUntilElementPresenceAndClickable(selectorForCookies)) {
            driver.findElement(selectorForCookies).click();
        }

    }

    public CareerSearchGLPage searchText(String textToSearch) {
        if (waitUntilVisibilityOfElement(selectorForSearchField)) {
            this.searchField = driver.findElement(selectorForSearchField);
            inputTextInSearchFieldAndClick(textToSearch);
            return new CareerSearchGLPage(driver);
        }
        return null;
    }
}
