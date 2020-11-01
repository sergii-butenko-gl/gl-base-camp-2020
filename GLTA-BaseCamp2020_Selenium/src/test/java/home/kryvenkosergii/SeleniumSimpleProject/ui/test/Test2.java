package home.kryvenkosergii.SeleniumSimpleProject.ui.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {
    private final Long ONE_SECOND_DELAY = 1000L;
    //
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setUpBeforeClass() {
//      //
//      ChromeOptions options = new ChromeOptions();
//      options.addArguments("--headless"); // Chrome Without UI
//      driver = new ChromeDriver(options);
        //
        driver = new ChromeDriver();
        //
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver.get("https://www.globallogic.com/ua/careers/");
        presentationSleep(); // For Presentation Only
    }

    @AfterClass(alwaysRun = true)
    public void tearDownAfterClass() throws Exception {
        presentationSleep(1);
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        if (!result.isSuccess()) {
            logger.warn("Test " + result.getName() + " ERROR");
        }
    }

    protected void presentationSleep() {
        presentationSleep(1);
    }

    protected void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchQA() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("by_keyword")));
        WebElement searchField = driver.findElement(By.id("by_keyword"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(searchField);
//        actions.perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchField);
        searchField.sendKeys("QA");
        searchField.submit();
        WebElement firstResult = driver
                .findElements(By.cssSelector("div[class*='career-searchpage'] div[class='row'] div.only-mobile-view+div div.row+div"))
                .get(0).findElement(By.className("mb-0"));
        System.out.println(firstResult.getText());
    }
}
