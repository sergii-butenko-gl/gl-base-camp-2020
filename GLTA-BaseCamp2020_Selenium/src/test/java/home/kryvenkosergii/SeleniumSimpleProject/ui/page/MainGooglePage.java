package home.kryvenkosergii.SeleniumSimpleProject.ui.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

/**
 * MainGooglePage class.
 * @author SergiiK
 */
public class MainGooglePage extends BaseSearchPage {

    /**
     * MainGooglePage constructor.
     * @param driver WebDriver
     */
    public MainGooglePage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    /**
     * Initialize web elements
     */
    private void initElements() {
        wait = new WebDriverWait(driver, 5);
        this.searchField = driver.findElement(By.name("q"));
        this.selectorForNeededResult = By.cssSelector("cite");
        this.selectorForFieldsOfResults = By.className("g");
    }

    // Page Object

    /**
     * Getting text in the Search field.
     * @return String
     */
    public String getSearchFieldText() {
        return getSearchField().getAttribute("data-ved");
    }

    // searchResults
    @Override
    protected List<WebElement> getSearchResults() {
        searchResults = driver.findElements(selectorForFieldsOfResults);
        return searchResults;
    }

    // Functional
    @Step(value = "get needed link's WebElement by path: {0}")
    private WebElement getLinkByPath(String neededLink) {
        logger.info(this.getClass().getSimpleName() + " search needed link");
        log(this.getClass().getSimpleName() + " search needed link");
        for (WebElement webElement : searchResults) {
            if (webElement.findElement(this.selectorForNeededResult).getText().contains(neededLink)) {
                logger.info(this.getClass().getSimpleName() + " found needed link");
                log(this.getClass().getSimpleName() + " found needed link");
                return webElement.findElement(By.tagName("h3"));
            }
        }
        return null;
    }

    /**
     * In the main Google page click to search field, clear it and input text.
     * @param text String
     * @return MainGooglePage class.
     */
    public MainGooglePage searchText(String text) {
        clickSearchField().clearSearchField().inputSearchField(text).clickSearchButton();
        return this;
    }

    /**
     * Search a result with a link to "pypi.org" and click on it.
     * @param path
     * @return PypiOrgProjectSeleniumPage class.
     */
    public ProjectSeleniumPypiOrgPage searchNeededLinkAndClick() {
        String link = "pypi.org";
        if (isDisplayedSearchResults()) {
            getLinkByPath(link).click();
        }
        return new ProjectSeleniumPypiOrgPage(driver);
    }
}
