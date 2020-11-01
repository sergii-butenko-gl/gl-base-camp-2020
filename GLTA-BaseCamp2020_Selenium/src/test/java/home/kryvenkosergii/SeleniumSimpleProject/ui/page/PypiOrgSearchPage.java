package home.kryvenkosergii.SeleniumSimpleProject.ui.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PypiOrgSearchPage {
    //
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private WebDriver driver;
    //
    private List<WebElement> results;

    /**
     * PypiOrgProjectSeleniumPage constructor.
     * @param driver WebDriver
     */
    public PypiOrgSearchPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    /**
     * Initialize web elements
     */
    private void initElements() {
        results = driver.findElements(By.cssSelector("ul[aria-label='Search results'] li"));
    }

    // Functional
    public String openResultByNumberAndGetPackageHeaderName(int number) {
        if (results.size() >= number) {
            return results.get(number - 1).findElement(By.className("package-snippet__name")).getText();
        }
        return "wrong number";
    }
}
