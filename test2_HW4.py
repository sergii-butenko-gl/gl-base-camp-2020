from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support.expected_conditions import presence_of_element_located


driver = webdriver.Chrome('/home/home/ch_dr/chromedriver')
driver.get("http://www.globallogic.com/ua/careers/")
wait=WebDriverWait(driver,3)
driver.implicitly_wait(2)
search_field= driver.find_element_by_id('by_keyword')
search_field.clear()
search_field.send_keys('QA'+Keys.RETURN)
#driver.implicitly_wait(5)
searchresult_text =wait.until(presence_of_element_located((By.XPATH,'//div[@class="career-pagelink"][1]//p[1]')))
#searchresult_text = driver.find_elements_by_xpath('//div[@class="career-pagelink"][1]//p[1]')
print(f'\nHeader of first result:\n\t{searchresult_text}\n')

