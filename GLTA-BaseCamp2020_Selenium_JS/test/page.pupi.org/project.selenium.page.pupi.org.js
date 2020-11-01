/**
 * SeleniumPagePupi for page https://pypi.org/project/selenium/
 */
class SeleniumPagePupi {

    // get webelement 'search'
    get searchField() {
        return $('#search');
    }

    // get webelement button 'search'
    get searchButton() {
        return $('.search-form__button');
    }

    // input some value to webelement
    setValueInSearchField(value) {
        this.searchField.addValue(value);

    }

    // click to start search
    clickToStartSearch() {
        this.searchButton.click();
    }

}

module.exports = new SeleniumPagePupi();