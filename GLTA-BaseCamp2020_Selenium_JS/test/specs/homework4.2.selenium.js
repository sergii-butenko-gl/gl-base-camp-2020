describe('Homework 4.2', () => {

    it('open page "https://www.globallogic.com/ua/careers/"', () => {
        browser.url('https://www.globallogic.com/ua/careers/');
        browser.waitUntil(() => {
            return $('#by_keyword').isDisplayed();
        }, 5000, 'field "Search" is not displayed');
    })

    it('put "QA" into search field', () => {
        browser.waitUntil(() => {
            return $('#by_keyword').isDisplayed();
        }, 5000, 'field "Search" is not displayed');
        const searchField = $('#by_keyword');
        searchField.scrollIntoView();
        searchField.setValue("QA");
        searchField.keys('\uE007');
    })

    it('print to console header of first result', () => {
        let resultSelector = '//div[contains(@class,"career-searchpage")]//div[@class="row"]//div[@class="career-pagelink"][1]';
        browser.waitUntil(() => {
            return $(resultSelector).isDisplayed();
        }, 5000, 'result is not displayed');
        const result = $(resultSelector);
        result.scrollIntoView();
        let text = result.getText();
        console.log("----------------------Result Homework 4.2 : " + text);
        // assert.strictEqual(text.includes('IRC103079'), true, "Error: the result doesn't match as expected");
        // browser.pause(3000);
    })
})