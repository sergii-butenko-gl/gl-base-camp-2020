package home.kryvenkosergii.SeleniumSimpleProject.ui.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchPypiOrgPage {
    //
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private WebDriver driver;
    //
    private List<WebElement> results;
    //
    private By selectorForFieldsOfResults = By.cssSelector("ul[aria-label='Search results'] li");
    private By selectorForNeededResult = By.className("package-snippet__name");

    /**
     * SearchPypiOrgPage constructor.
     * @param driver WebDriver
     */
    public SearchPypiOrgPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    /**
     * Initialize web elements
     */
    private void initElements() {
        results = driver.findElements(selectorForFieldsOfResults);
    }

    // Functional
    public String getTextOfResultByNumberInListResults(int number) {
        logger.debug("start openResultByNumberAndGetPackageHeaderName()");
        logger.trace("get the needed result's text on number " + number);
        logger.info(this.getClass().getSimpleName());
        if (results.size() >= number) {
            return results.get(number - 1).findElement(selectorForNeededResult).getText();
        }
        return "wrong number";
    }
}
