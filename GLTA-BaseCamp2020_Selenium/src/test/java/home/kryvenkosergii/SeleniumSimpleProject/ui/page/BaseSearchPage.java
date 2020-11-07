package home.kryvenkosergii.SeleniumSimpleProject.ui.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.qameta.allure.Step;

public class BaseSearchPage {
    //
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected WebDriver driver;
    protected WebDriverWait wait;
    //
    protected WebElement searchField;
    protected WebElement searchButton;
    protected WebElement searchResult;
    protected List<WebElement> searchResults;
    protected By selectorForSearchField;
    protected By selectorForNeededResult;
    protected By selectorForFieldsOfResults;

    // Page Object
    // searchField
    protected WebElement getSearchField() {
        return searchField;
    }

    @Step(value = "input in Search Field text {0}")
    protected BaseSearchPage inputSearchField(String text) {
        logger.debug("start inputSearchField()");
        logger.trace("input SearchField: " + text);
        logger.info(this.getClass().getSimpleName() + " input SearchField: " + text);
        log("Start search using string: " + text);
        if (isDisplayedSearchField()) {
            int attempts = 0;
            while (attempts < 2) {
                try {
                    this.getSearchField().sendKeys(text);
                    break;
                } catch (StaleElementReferenceException e) {
                }
                attempts++;
            }
        }
        while (text.equals(getSearchFieldText())) {
            this.getSearchField().sendKeys(text);
        }
        return this;
    }

    @Step(value = "clear Search Field")
    protected BaseSearchPage clearSearchField() {
        logger.debug("start clearSearchField()");
        logger.trace("clear SearchField");
        logger.info(this.getClass().getSimpleName() + " clear SearchField");
        int attempts = 0;
        while (attempts < 2) {
            try {
                this.getSearchField().clear();
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
        return this;
    }

    @Step(value = "click in Search Field")
    protected BaseSearchPage clickSearchField() {
        logger.debug("start clickSearchField()");
        logger.trace("click SearchField");
        logger.info(this.getClass().getSimpleName() + " click SearchField");
        if (isDisplayedSearchField()) {
            int attempts = 0;
            while (attempts < 2) {
                try {
                    waitUntilElementToBeClickable(selectorForSearchField);
                    this.getSearchField().click();
                    break;
                } catch (StaleElementReferenceException e) {
                }
                attempts++;
            }
            Actions action = new Actions(driver);
            action.contextClick(getSearchField()).sendKeys(Keys.LEFT).sendKeys(Keys.RIGHT);
        }
        return this;
    }

    protected boolean isDisplayedSearchField() {
        logger.debug("start isDisplayedSearchField()");
        logger.trace("is Displayed SearchField");
        int attempts = 0;
        boolean result = false;
        while (attempts < 2) {
            try {
                result = this.getSearchField().isDisplayed();
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }

    @Step(value = "get text from SearchField")
    protected String getSearchFieldText() {
        logger.debug("start getSearchFieldText()");
        logger.trace("get text from SearchField");
        int attempts = 0;
        String text = "";
        while (attempts < 2) {
            try {
                text = getSearchField().getText();
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
        return text;
    }

    // searchButton
    protected BaseSearchPage clickSearchButton() {
        logger.debug("start clickSearchButton()");
        logger.trace("click SearchButton");
        logger.info(this.getClass().getSimpleName() + " click SearchButton");
        if (isDisplayedSearchField()) {
            this.getSearchField().submit();
        }
        return this;
    }

    // searchResults
    protected List<WebElement> getSearchResults() {
        return searchResults;
    }

    protected boolean isDisplayedSearchResults() {
        logger.debug("start isDisplayedSearchResults()");
        logger.trace("is Displayed searchResults");
        return getSearchResults().size() > 0;
    }

    protected List<String> getSearchResultList() {
        logger.info(this.getClass().getSimpleName());
        log(this.getClass().getSimpleName());
        List<String> list = new ArrayList<String>();
        for (WebElement webElement : searchResults) {
            list.add(webElement.findElement(this.selectorForNeededResult).getText());
        }
        return list;
    }

    // empty method for Allure logging
    @Step("{0}")
    protected void log(String value) {
        // empty method
    }

    protected boolean waitUntilPresenceOfElement(By selector) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(selector));
            return true;
        } catch (Exception e) {
            System.err.println("Element not displayed; " + e.getMessage());
            return false;
        }
    }

    protected boolean waitUntilElementToBeClickable(By selector) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(selector));
            return true;
        } catch (ElementNotInteractableException e) {
            System.err.println("Element not interactable; " + e.getMessage());
            return false;
        }
    }

    protected boolean waitUntilWebElementToBeClickable(WebElement webElement) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            return true;
        } catch (ElementNotInteractableException e) {
            System.err.println("Element not interactable; " + e.getMessage());
            return false;
        }
    }

    protected boolean waitUntilVisibilityOfElement(By selector) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
            return true;
        } catch (Exception e) {
            System.err.println("Element is not visible; " + e.getMessage());
            return false;
        }
    }

    protected boolean waitUntilElementPresenceAndClickable(By selector) {
        if (waitUntilPresenceOfElement(selector) && waitUntilElementToBeClickable(selector)) {
            return true;
        }
        return false;
    }

    public void inputTextInSearchFieldAndClick(String text) {
        clickSearchField().clearSearchField().inputSearchField(text).clickSearchButton();
    }
}
