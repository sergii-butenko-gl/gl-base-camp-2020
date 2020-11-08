/**
 * Start page google.com
 */
class StartPageGoogle {

    // get webelement 'search'
    get searchField() {
        return $('.//input[@name="q"]');
    }

    // input some value to webelement
    setValueInSearchField(value) {
        this.searchField.setValue(value);

    }

    // click to start search
    clickToStartSearch() {
        this.searchField.keys('\uE007');
    }

    // click to needed result link
    clickToNeededResultLink(text) {
        $('//cite[text()="' + text + '"]/../../h3').click();
    }
}

module.exports = new StartPageGoogle();