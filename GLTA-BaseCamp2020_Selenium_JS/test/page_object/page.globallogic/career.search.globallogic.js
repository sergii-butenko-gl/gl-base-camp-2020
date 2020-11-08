/**
 * CareerSearchPageGliobalLogic for page https://www.globallogic.com/ua/career-search-page/?keywords={text to search}&experience=&locations=&c=
 */
class CareerSearchPageGliobalLogic {

    getTextOfResultByNumberInListResults(numberOfResult) {
        const resultSelectorXpath = '//div[contains(@class,"career-searchpage")]//div[@class="row"]//div[@class="career-pagelink"][' + numberOfResult + ']';
        browser.waitUntil(() => {
            return $(resultSelectorXpath).isDisplayed();
        }, 5000, 'result is not displayed');
        const result = $(resultSelectorXpath);
        result.scrollIntoView();
        return result.getText();
    }

    checkExistsFieldOfResultNumbers() {
        const resultNumbersFieldSelectorTag = 'h5';
        browser.waitUntil(() => {
            return $(resultNumbersFieldSelectorTag).isDisplayed();
        }, 5000, 'field with result numbers is not displayed');
        const actualResult = $(resultNumbersFieldSelectorTag).getText();
        const expectedResult = ' Jobs Found';
        return actualResult.includes(expectedResult);
    }
}

module.exports = new CareerSearchPageGliobalLogic();