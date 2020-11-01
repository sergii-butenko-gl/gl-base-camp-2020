package home.kryvenkosergii.SeleniumSimpleProject.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.qameta.allure.Step;

public class PypiOrgProjectSeleniumPage {
    //
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private WebDriver driver;
    //
    private WebElement searchField;
//    private WebElement searchButton;

    /**
     * PypiOrgProjectSeleniumPage constructor.
     * @param driver WebDriver
     */
    public PypiOrgProjectSeleniumPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    /**
     * Initialize web elements
     */
    private void initElements() {
        searchField = driver.findElement(By.id("search"));
    }

    // Page Object
    // searchField
    private WebElement getSearchField() {
        return searchField;
    }

    @Step(value = "input in Search Field text {0}")
    private PypiOrgProjectSeleniumPage inputSearchField(String text) {
        logger.debug("start inputSearchField()");
        logger.trace("input SearchField: " + text);
        logger.info(this.getClass().getSimpleName() + " input SearchField: " + text);
        log("Start search using string: " + text);
        this.getSearchField().sendKeys(text);
        return this;
    }

    @Step(value = "clear Search Field")
    private PypiOrgProjectSeleniumPage clearSearchField() {
        logger.debug("start clearSearchField()");
        logger.trace("clear SearchField");
        logger.info(this.getClass().getSimpleName() + " clear SearchField");
        this.getSearchField().clear();
        return this;
    }

    @Step(value = "click in Search Field")
    private PypiOrgProjectSeleniumPage clickSearchField() {
        logger.debug("start clickSearchField()");
        logger.trace("click SearchField");
        logger.info(this.getClass().getSimpleName() + " click SearchField");
        if (isDisplayedSearchField()) {
            this.getSearchField().click();
            Actions action = new Actions(driver);
            action.contextClick(getSearchField()).sendKeys(Keys.LEFT).sendKeys(Keys.RIGHT);
        }
        return this;
    }

    private boolean isDisplayedSearchField() {
        logger.debug("start isDisplayedSearchField()");
        logger.trace("is Displayed SearchField");
        return getSearchField().isDisplayed();
    }

    /**
     * Getting text in the Search field.
     * @return String
     */
    public String getSearchFieldText() {
        return getSearchField().getAttribute("data-ved");
    }

    // searchButton
    private PypiOrgProjectSeleniumPage clickSearchButton() {
        logger.debug("start clickSearchButton()");
        logger.trace("click SearchButton");
        logger.info(this.getClass().getSimpleName() + " click SearchButton");
        if (isDisplayedSearchField()) {
            this.getSearchField().submit();
        }
        return this;
    }

    // empty method for Allure logging
    @Step("{0}")
    private void log(String value) {
        // empty method
    }

    // Functional
    public PypiOrgSearchPage searchText(String text) {
        if (isDisplayedSearchField()) {
            clickSearchField().clearSearchField().inputSearchField(text).clickSearchButton();
        }
        return new PypiOrgSearchPage(driver);
    }
}
