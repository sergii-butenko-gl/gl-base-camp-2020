/**
 * SearchResultsPagePupi for page 'https://pypi.org/search/'
 */
class SearchResultsPagePupi {

    // get text result
    getTextResult(resultNumberInList){
        const packageName = '';
        return $('//ul[@aria-label="Search results"]//li[' + resultNumberInList + ']//span[1]').getText();
    }
}

module.exports = new SearchResultsPagePupi();