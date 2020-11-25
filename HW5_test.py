from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


class BasePage:
    def __init__(self, driver):
        self.driver = driver

    def find_element(self, *points):
        WebDriverWait(self.driver, 10).until(
            EC.visibility_of_element_located((points))
        )
        return self.driver.find_element(*points)

    def find_elements(self, *points):
        WebDriverWait(self.driver, 10).until(
            EC.visibility_of_any_elements_located((points))
        )
        return self.driver.find_elements(*points)
    
    def click(self, *points):
        WebDriverWait(self.driver, 10).until(
            EC.visibility_of_element_located((points))
        )
        self.driver.find_element(*points).click()

class GLCareersResultPage(BasePage):
    
    SEARCH_RESULT = (By.XPATH, "//div[contains(@class,'career-searchpage')]//div[@class='row']//div[@class='career-pagelink']")
    TEXT_RESULT = (By.CLASS_NAME, "mb-0")
    
    
    def __init__(self, driver):
        super().__init__(driver)

    def open(self, by_keyword=None):
        self.driver.get(
            f"https://www.globallogic.com/ua/career-search-page/?keywords={by_keyword}&experience=&locations=&c="
        )


class GLCareersPage(BasePage):
    URL = 'https://www.globallogic.com/ua/careers/'

    SEARCH_FIELD = (By.ID, 'by_keyword')
    SEARCH_BUTTON = (By.XPATH, '//*[@id="hero"]/div/div/div/div/div/div/div/form/div/button')
    COOKIE_ALLOW_ALL_BUTTON = (By.ID, 'CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll')


    def __init__(self, driver):
        super().__init__(driver)
        self._AllowCookieButton = None

    def open(self):
        self.driver.get(GLCareersPage.URL)
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
    def text_res(self):
        return self.find_elements(*GLCareersResultPage.TEXT_RESULT)

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
driver.close()

