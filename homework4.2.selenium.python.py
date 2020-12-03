from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.expected_conditions import presence_of_element_located

driver = webdriver.Chrome('/home/serge/Desktop/tmp/chromedriver')
wait = WebDriverWait(driver, 10)
driver.get('https://www.globallogic.com/ua/careers/')

# try:
#     element = WebDriverWait(driver, 10).until(
#         EC.visibility_of_element_located((By.ID, "by_keyword"))
#     )
# finally:
#     driver.quit()
wait.until(presence_of_element_located((By.ID, "by_keyword")))

# print(driver.title)
assert "Вакансії / Кар'єра | GlobalLogic Ukraine" in driver.title
searchField = driver.find_element_by_id("by_keyword")
searchField.send_keys("QA" + Keys.RETURN)

wait.until(presence_of_element_located((By.CSS_SELECTOR, ".filter-main")))

searchResults = driver.find_elements(By.XPATH, "//div[contains(@class,'career-searchpage')]//div[@class='row']//div[@class='career-pagelink']")

result = searchResults[0].find_element_by_class_name("mb-0")
print(result.text)

driver.close()