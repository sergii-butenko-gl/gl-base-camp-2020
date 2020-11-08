const assert = require('assert');
const careersGLPage = require('../page_object/page.globallogic/careers.ua.globallogic');
const careerSearchGLPage = require('../page_object/page.globallogic/career.search.globallogic');

describe('Homework 5.2', () => {

    it('open page "https://www.globallogic.com/ua/careers/" and start search "QA"', () => {
        browser.url('https://www.globallogic.com/ua/careers/');
        // careersGLPage.closeCookies();
        careersGLPage.searchText("QA");
        assert.strictEqual(careerSearchGLPage.checkExistsFieldOfResultNumbers(), true, "Error: the result doesn't match as expected");
    })

    it('print to console header of first result', () => {
        const actualResult = careerSearchGLPage.getTextOfResultByNumberInListResults(1);
        const expectedResult = 'IRC103517';
        console.log("----------------------Result Homework 5.2 : " + actualResult);
        assert.strictEqual(actualResult.includes(expectedResult), true, "Error: the result doesn't match as expected");
    })
})