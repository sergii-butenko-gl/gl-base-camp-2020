package home.kryvenkosergii.SeleniumSimpleProject.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.qameta.allure.Step;

public class ProjectSeleniumPypiOrgPage extends BaseSearchPage {

    /**
     * ProjectSeleniumPypiOrgPage constructor.
     * @param driver WebDriver
     */
    public ProjectSeleniumPypiOrgPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    /**
     * Initialize web elements
     */
    private void initElements() {
        searchField = driver.findElement(By.id("search"));
    }

    // Functional
    public SearchPypiOrgPage searchText(String text) {
        clickSearchField().clearSearchField().inputSearchField(text).clickSearchButton();
        return new SearchPypiOrgPage(driver);
    }
}
