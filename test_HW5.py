from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


class BasePage:
    def __init__(self, browser):
        self.browser = browser

    def click(self, *locators):
        WebDriverWait(self.browser, 10).until(
            EC.visibility_of_element_located((locators))
        )
        self.browser.find_element(*locators).click()

    def find_element(self, *locators):
        WebDriverWait(self.browser, 10).until(
            EC.visibility_of_element_located((locators))
        )
        return self.browser.find_element(*locators)

    def find_elements(self, *locators):
        WebDriverWait(self.browser, 10).until(
            EC.visibility_of_any_elements_located((locators))
        )
        return self.browser.find_elements(*locators)

class GLCareersResultPage(BasePage):
    
    SEARCH_RESULT = (By.XPATH, "//div[contains(@class,'career-searchpage')]//div[@class='row']//div[@class='career-pagelink']")
    TEXT_RESULT = (By.CLASS_NAME, "mb-0")
    
    
    def __init__(self, browser):
        super().__init__(browser)

    def open(self, by_keyword=None):
        self.browser.get(
            f"https://www.globallogic.com/ua/career-search-page/?keywords={by_keyword}&experience=&locations=&c="
        )


class GLCareersPage(BasePage):
    URL = 'https://www.globallogic.com/ua/careers/'

    SEARCH_FIELD = (By.ID, 'by_keyword')
    SEARCH_BUTTON = (By.XPATH, '//*[@id="hero"]/div/div/div/div/div/div/div/form/div/button')
    COOKIE_ALLOW_ALL_BUTTON = (By.ID, 'CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll')


    def __init__(self, browser):
        super().__init__(browser)
        self._AllowCookieButton = None

    def open(self):
        self.browser.get(GLCareersPage.URL)
        self.AllowCookieButton.click()

    @property
    def AllowCookieButton(self):
        return self.find_element(*GLCareersPage.COOKIE_ALLOW_ALL_BUTTON)

    @property
    def search_field(self):
        return self.find_element(*GLCareersPage.SEARCH_FIELD)

    @property
    def search_button(self):
        return self.find_element(*GLCareersPage.SEARCH_BUTTON)

    @property
    def search_res(self):
        return self.find_elements(*GLCareersPage.SEARCH_RESULT)

    @property
    def text_res(self):
        return self.find_elements(*GLCareersResultPage.TEXT_RESULT)

    def text_vacancy(self):
        list_result = self.find_elements_list()

    def search_vacancy(self, vacancy, enter=False):
        self.search_field.send_keys(vacancy)
        if enter:
            self.search_field.send_keys(Keys.RETURN)
        else:
            self.search_button.click()
            print(*self.text_res)

        return True


driver = webdriver.Chrome('/home/home/ch_dr/chromedriver')
carrersPage = GLCareersPage(driver)
carrersPage.open()
carrersPage.search_vacancy("QA")

