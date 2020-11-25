from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from config import Config

class BasePage:
    def __init__(self, driver):
        self.driver = driver
        self.config = Config()


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
     
    def __init__(self, driver):
        super().__init__(driver)

    def open(self, by_keyword=None):
        self.driver.get(
            f"{self.config.SEARCH_URL}?keywords={by_keyword}&experience=&locations=&c="
        )

class GLCareersPage(BasePage):

    def __init__(self, driver):
        super().__init__(driver)
        self._AllowCookieButton = None

    def open(self):
    	self.driver.implicitly_wait(10)
    	self.driver.get(self.config.URL)
    	self.AllowCookieButton.click()

    @property
    def AllowCookieButton(self):
        return self.find_element(*self.config.COOKIE_ALLOW_ALL_BUTTON)

    @property
    def search_field(self):
        return self.find_element(*self.config.SEARCH_FIELD)

    @property
    def search_button(self):
        return self.find_element(*self.config.SEARCH_BUTTON)

    @property
    def text_res(self):
        return self.find_elements(*self.config.TEXT_RESULT)

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

