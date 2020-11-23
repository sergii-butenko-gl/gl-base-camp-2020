package home.kryvenkosergii.SeleniumSimpleProject.ui.data;

/**
 * SearchData class.
 * @author SergiiK
 */
public class SearchData {

    private String searchText;

    private String expectedResult;

    /**
     * Default constructor.
     */
    public SearchData() {
        this.searchText = "";
        this.expectedResult = "";
    }

    /**
     * Constructor with an entered parameter.
     * @param searchText String
     */
    public SearchData(String searchText) {
        this.searchText = searchText;
        this.expectedResult = "";
    }

    /**
     * Constructor with two entered parameters.
     * @param searchText String
     * @param expectedResult String
     */
    public SearchData(String searchText, String expectedResult) {
        this.searchText = searchText;
        this.expectedResult = expectedResult;
    }

    /**
     * Getting a search string.
     * @return String
     */
    public String getSearchText() {
        return searchText;
    }

    /**
     * Setting a searchText field.
     * @param searchText String
     */
    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    /**
     * Setting an expected result.
     * @param expectedResult String
     */
    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    @Override
    public String toString() {
        return "SearchData [searchText=" + searchText + ", expectedResult=" + expectedResult + "]";
    }

}
