from selenium.webdriver.common.by import By

class Config() :

    URL = 'https://www.globallogic.com/ua/careers/'
    SEARCH_FIELD = (By.ID, 'by_keyword')
    SEARCH_BUTTON = (By.XPATH, '//*[@id="hero"]/div/div/div/div/div/div/div/form/div/button')
    COOKIE_ALLOW_ALL_BUTTON = (By.ID, 'CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll')
    SEARCH_RESULT = (By.XPATH, "//div[contains(@class,'career-searchpage')]//div[@class='row']//div[@class='career-pagelink']")
    TEXT_RESULT = (By.CLASS_NAME, "mb-0")    

    def __init__(self) :
        super().__init__()
