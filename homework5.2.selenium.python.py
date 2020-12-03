from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium import webdriver
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains


class BasePage:

    def __init__(self, driver):
        self.driver = driver

    def open_wbepage_by_url(self, url):
        # self.driver.implicitly_wait(10)
        self.driver.get(url)

    def find_element_by_selector(self, selector):
        if self.waitUntil_presence_of_element(selector, 10):
            return self.driver.find_element(*selector)
        else:
            return None

    def find_elements_list(self, selector):
        if self.waitUntil_presence_of_all_elements(selector, 5):
            return self.driver.find_elements(*selector)
        else:
            return None

    def click_to_element(self, selector):
        if self.waitUntil_element_to_be_clickable(selector, 5):
            self.find_element_by_selector(selector).click()

    def click_to_button_or_submit(self, selector):
        if self.waitUntil_element_to_be_clickable(*selector, 5):
            self.find_element_by_selector(selector).send_keys(Keys.RETURN)

    def input_text_in_field(self, selector, text_for_input):
        while (self.check_if_input_text_displayed_in_field(selector, text_for_input) is not True):
            self.find_element_by_selector(selector).send_keys(text_for_input)

    def check_if_input_text_displayed_in_field(self, selector, text_to_check):
        actual_result = self.find_element_by_selector(
            selector).get_attribute("value")
        expected_result = text_to_check
        return str(actual_result) == expected_result

    def check_if_displayed_more_than_zero_results(self, selector):
        actual_result = len(self.find_elements_list(selector))
        return actual_result > 0

    def clear_field(self, selector):
        # self.find_element(selector).clear()
        self.find_element_by_selector(selector).sendKeys(Keys.CONTROL + "a")
        self.find_element_by_selector(selector).sendKeys(Keys.DELETE)

    def get_text_from_element(self, selector):
        if self.waitUntil_presence_of_element(selector, 2):
            return str(self.find_element_by_selector(selector).text)
        else:
            return "text not found"

    def input_text_in_field_and_click_submit(self, selectorForField, text_for_input, selectorForButtonSubmit, enter=False):
        self.input_text_in_field(selectorForField, text_for_input)
        if enter is not True:
            self.click_to_element(selectorForButtonSubmit)
        else:
            self.click_to_button_or_submit(selectorForButtonSubmit)

    def scroll_to_webelement(self, selector):
        element = self.find_element_by_selector(selector)
        self.driver.execute_script("arguments[0].scrollIntoView();", element)

    def waitUntil_presence_of_element(self, selector, time_sec_to_wait):
        try:
            return WebDriverWait(self.driver, time_sec_to_wait).until(
                EC.presence_of_element_located((selector)))
        except:
            print("Needed element not present")
            driver.close()
            return False

    def waitUntil_presence_of_all_elements(self, selector, time_sec_to_wait):
        try:
            return WebDriverWait(self.driver, time_sec_to_wait).until(
                EC.presence_of_all_elements_located((selector)))
        except:
            print("Needed elements not present")
            driver.close()
            return False

    def waitUntil_visibility_of_element(self, selector, time_sec_to_wait):
        try:
            return WebDriverWait(self.driver, time_sec_to_wait).until(
                EC.visibility_of_element_located((selector)))
        except:
            print("Needed element not visible")
            driver.close()
            return False

    def waitUntil_element_to_be_clickable(self, selector, time_sec_to_wait):
        try:
            return WebDriverWait(self.driver, time_sec_to_wait).until(
                EC.element_to_be_clickable((selector)))
        except:
            print("Needed element not clickable")
            driver.close()
            return False


class GLCareersPage(BasePage):
    URL = 'https://www.globallogic.com/ua/careers/'

    SEARCH_FIELD = (By.ID, 'by_keyword')
    SEARCH_BUTTON = (
        By.XPATH, '//*[@id="hero"]/div/div/div/div/div/div/div/form/div/button')
    COOKIE_ALLOW_ALL_BUTTON = (
        By.ID, 'CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll')

    def __init__(self, driver):
        super().__init__(driver)

    def open(self):
        self.open_wbepage_by_url(GLCareersPage.URL)
        self.click_to_element(GLCareersPage.COOKIE_ALLOW_ALL_BUTTON)

    def search_vacancy(self, vacancy):
        self.input_text_in_field_and_click_submit(
            GLCareersPage.SEARCH_FIELD, vacancy, GLCareersPage.SEARCH_BUTTON)


class GLCareersResultPage(BasePage):
    # URL = 'https://www.globallogic.com/ua/career-search-page/?keywords={by_keyword}&experience=&locations=&c='
    JOBS_FOUND_ELEMENT = (By.TAG_NAME, 'h5')
    KEYWORD_FOR_SEARCH = (By.CLASS_NAME, 'chip')
    RESULTS_GRID = (
        By.XPATH, "//div[contains(@class,'career-searchpage')]//div[@class='row']//div[@class='career-pagelink']")
    TEXT_TO_SEARCH = (By.CLASS_NAME, 'mb-0')

    def __init__(self, driver):
        super().__init__(driver)

    def printNumberOfResultsFoundAndKeyword(self):
        self.scroll_to_webelement(GLCareersResultPage.JOBS_FOUND_ELEMENT)
        print(self.get_text_from_element(
            GLCareersResultPage.JOBS_FOUND_ELEMENT))
        print(self.get_text_from_element(
            GLCareersResultPage.KEYWORD_FOR_SEARCH))

    def getFirstResult(self):
        self.scroll_to_webelement(GLCareersResultPage.JOBS_FOUND_ELEMENT)
        results_list = self.find_elements_list(
            GLCareersResultPage.RESULTS_GRID)
        # print(len(results_list))
        return results_list[0].find_element(*GLCareersResultPage.TEXT_TO_SEARCH).text


driver = webdriver.Chrome('/home/serge/Desktop/tmp/chromedriver')

careersPage = GLCareersPage(driver)
careersPage.open()
careersPage.search_vacancy('QA')

careerResults = GLCareersResultPage(driver)
careerResults.printNumberOfResultsFoundAndKeyword()
print(careerResults.getFirstResult())
driver.close()