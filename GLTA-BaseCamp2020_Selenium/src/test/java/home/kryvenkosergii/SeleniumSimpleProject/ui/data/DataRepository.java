package home.kryvenkosergii.SeleniumSimpleProject.ui.data;

/**
 * DataRepository class which holds different sets of data.
 * @author SergiiK
 */
public final class DataRepository {
    private static volatile DataRepository instance = null;

    private DataRepository() {
    }

    public static DataRepository get() {
        if (instance == null) {
            synchronized (DataRepository.class) {
                if (instance == null) {
                    instance = new DataRepository();
                }
            }
        }
        return instance;
    }

    public SearchData seleniumInstallUbuntuPythonSearch() {
        return new SearchData("selenium install ubuntu python", "Selenium-Screenshot");
    }
    
    public SearchData qaSearch() {
        return new SearchData("QA", "Senior QA Automation Engineer IRC104438");
    }

}