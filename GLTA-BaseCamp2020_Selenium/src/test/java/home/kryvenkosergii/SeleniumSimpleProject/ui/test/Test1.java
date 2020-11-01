package home.kryvenkosergii.SeleniumSimpleProject.ui.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import home.kryvenkosergii.SeleniumSimpleProject.ui.data.DataRepository;
import home.kryvenkosergii.SeleniumSimpleProject.ui.data.SearchData;
import home.kryvenkosergii.SeleniumSimpleProject.ui.page.MainGooglePage;
import home.kryvenkosergii.SeleniumSimpleProject.ui.page.PypiOrgProjectSeleniumPage;
import home.kryvenkosergii.SeleniumSimpleProject.ui.page.PypiOrgSearchPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class Test1 extends TestRunner {

    @DataProvider
    public Object[][] searchText() {
        return new Object[][] { { DataRepository.get().seleniumInstallUbuntuPythonSearch() }, };
    }

    /**
     * A simple test using Selenium. In Google page, we search 'selenium install
     * ubuntu python', open link with path 'pypi.org' and searching string 'selenium'.
     * Take a second result and matching with 'amazon-selenium'.
     * @param word string ('selenium install ubuntu python').
     */
    @Epic("A simple test using Selenium.")
    @Feature(value = "search 'selenium install ubuntu python'")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("In Google page, we search ....")
    @Story(value = "Make a search request using a sentence.")
    @Parameters("selenium install ubuntu python")
    @Test(dataProvider = "searchText")
    public void search(SearchData word) {
        logger.info("start search with " + word.toString());
        PypiOrgProjectSeleniumPage pypiOrgProjectSeleniumPage = new MainGooglePage(driver).searchText(word.getSearchText())
                .searchNeededLinkAndClick("pypi.org");
        PypiOrgSearchPage pypiOrgSearchPage = pypiOrgProjectSeleniumPage.searchText("selenium");

        String actual = pypiOrgSearchPage.openResultByNumberAndGetPackageHeaderName(2);
        String expected = "amazon-selenium";
        System.out.println("result = " + actual);
        Assert.assertTrue(actual.contains(expected), "test is failed");
    }
}
