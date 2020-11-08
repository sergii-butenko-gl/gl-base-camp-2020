/**
 * CareersPageGliobalLogic for page https://www.globallogic.com/ua/careers/
 */
class CareersPageGliobalLogic {

    closeCookies() {
        const cookiesButtonSelectorID = '#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll';
        browser.waitUntil(() => {
            return $(cookiesButtonSelectorID).isDisplayed();
        }, 5000, 'Cookies not displayed');
        $(cookiesButtonSelectorID).click();
    }

    // input text to search to field and click to start search
    searchText(textToSearch) {
        const searchFieldSelectorID = '#by_keyword';
        browser.waitUntil(() => {
            return $(searchFieldSelectorID).isClickable();
        }, 5000, 'Search Field is not Clickable');
        const searchField = $(searchFieldSelectorID);
        searchField.scrollIntoView();
        searchField.setValue(textToSearch);
        searchField.keys('\uE007');
    }
}

module.exports = new CareersPageGliobalLogic();