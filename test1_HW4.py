from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support.expected_conditions import presence_of_element_located


driver = webdriver.Chrome('/home/home/ch_dr/chromedriver')
driver.get("http://www.google.com/ncr")
driver.find_element_by_name("q").send_keys("selenium install ubuntu python" + Keys.RETURN)
driver.implicitly_wait(2)
first_result = driver.find_element_by_partial_link_text('pypi.org')
first_result.click()
search_field= driver.find_element_by_id('mobile-search')
search_field.clear()
search_field.send_keys('selenium библиотека'+Keys.RETURN)
selen_lib=driver.find_element_by_id('content')
selen_lib2=selen_lib.find_element_by_tag_name('li')
print(selen_lib2)

