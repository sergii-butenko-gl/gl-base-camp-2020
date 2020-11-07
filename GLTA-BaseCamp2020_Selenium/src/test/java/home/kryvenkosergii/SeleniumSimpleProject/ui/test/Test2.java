package home.kryvenkosergii.SeleniumSimpleProject.ui.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
    public void searchQAtext(SearchData word) {

        driver.get("https://www.globallogic.com/ua/careers/");
        logger.info("start search with " + word.getSearchText());
        CareerSearchGLPage careerSearchGLPage = new CareersGLPage(driver).searchText(word.getSearchText());
        String expected = "Senior QA Automation engineer IRC103517";
        String actual = careerSearchGLPage.getTextOfResultByNumberInListResults(1);
        System.out.println("result = " + actual);
        Assert.assertTrue(actual.contains(expected), "test is failed");
    }
}
