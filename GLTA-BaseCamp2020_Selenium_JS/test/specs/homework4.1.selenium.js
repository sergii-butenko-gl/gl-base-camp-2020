const assert = require('assert');
const googlePage = require('../page.google/start.page.google');
const projectSeleniumPypiPage = require('../page.pupi.org/project.selenium.page.pupi.org');
const searchResultsPypiPage = require('../page.pupi.org/search.results.page.pupi.org');

describe('Homework 4.1 : search some test using google and pypi.org', () => {
    //
    it('in google page, page we searching needed result and click', () => {
        browser.url('https://google.com');
        const searchText = 'selenium install ubuntu python';
        const neededLinkName = 'pypi.org';
        googlePage.setValueInSearchField(searchText);
        googlePage.clickToStartSearch();
        googlePage.clickToNeededResultLink(neededLinkName);
    })

    it('on site pypi.org search text "selenium" and getting the second result text', () => {
        const searchText = 'selenium';
        const numberOfResult = 2;
        projectSeleniumPypiPage.setValueInSearchField(searchText);
        projectSeleniumPypiPage.clickToStartSearch();
        let text = searchResultsPypiPage.getTextResult(numberOfResult);
        console.log("----------------------Result Homework 4.1 : " + text);
        assert.strictEqual(text.includes('amazon-selenium'), true, "Error: the result doesn't match as expected");
        // browser.pause(3000);
    })
})
