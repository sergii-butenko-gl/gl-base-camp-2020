package home.kryvenkosergii.SeleniumSimpleProject.ui.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import home.kryvenkosergii.SeleniumSimpleProject.ui.data.ConfigFile;
import home.kryvenkosergii.SeleniumSimpleProject.ui.data.DataRepository;
import home.kryvenkosergii.SeleniumSimpleProject.ui.data.SearchData;
import home.kryvenkosergii.SeleniumSimpleProject.ui.page.CareerSearchGLPage;
import home.kryvenkosergii.SeleniumSimpleProject.ui.page.CareersGLPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class Test2 extends TestRunner {

    @DataProvider
    public Object[][] searchText() {
        return new Object[][] { { DataRepository.get().qaSearch() }, };
    }

    /**
     * A simple test using Selenium. In GlobalLogic page, we search 'QA', open the
     * first result and read the text into it.
     * @param word string ('selenium install ubuntu python').
     */
    @Epic("A simple test using Selenium.")
    @Feature(value = "search 'QA'")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("In GlobalLogic page, we search ....")
    @Story(value = "Make a search request using a sentence.")
    @Parameters("searchQA")
    @Test(dataProvider = "searchText")
    public void searchQAtext(SearchData testData) {
        //
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("src/test/java/some.properties"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String errorMessage = props.getProperty("unexpected.message");
        System.out.println("error message = " + errorMessage);
        //

        driver.get(new ConfigFile().getURL_Globallogic_careers());
        logger.info("start search with " + testData.getSearchText());
        CareerSearchGLPage careerSearchGLPage = new CareersGLPage(driver).searchText(testData.getSearchText());
        String expected = testData.getExpectedResult();
        String actual = careerSearchGLPage.getTextOfResultByNumberInListResults(1);
        System.out.println("result = " + actual);
        System.out.println("expected = " + expected);
        Assert.assertTrue(actual.contains(expected), errorMessage);
    }
}
